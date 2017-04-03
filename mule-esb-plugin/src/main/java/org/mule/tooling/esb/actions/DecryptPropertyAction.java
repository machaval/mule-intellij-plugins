package org.mule.tooling.esb.actions;

import com.intellij.icons.AllIcons;
import com.intellij.lang.properties.IProperty;
import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.ui.awt.RelativePoint;
import org.bouncycastle.util.encoders.Base64;
import org.jetbrains.annotations.Nullable;
import org.mule.security.encryption.binary.jce.algorithms.EncryptionAlgorithm;
import org.mule.security.encryption.binary.jce.algorithms.EncryptionMode;
import org.mule.tooling.esb.encrypt.ui.EncryptDialog;
import org.mule.tooling.esb.util.MuleUIUtils;

public class DecryptPropertyAction extends AnAction {

    private static final String ENCRYPT_SUFFIX = "]";
    private static final String ENCRYPT_PREFIX = "![";

    final static Logger logger = Logger.getInstance(DecryptPropertyAction.class);

    public DecryptPropertyAction() {
        super("Decrypt...", "Decrypt Property Value with one of available encryption algorithms", AllIcons.FileTypes.Properties);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        final Project project = (Project) anActionEvent.getData(CommonDataKeys.PROJECT);

        PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);

        IProperty selectedProperty = getSelectedProperty(anActionEvent.getDataContext());

        final EncryptDialog form = new EncryptDialog();
        form.setTitle("Decrypt Property: " + selectedProperty.getKey());
        form.show();
        boolean isOk = form.getExitCode() == DialogWrapper.OK_EXIT_CODE;

        logger.debug("**** ALGORITHM " + form.getAlgorithm().getSelectedItem());
        logger.debug("**** MODE " + form.getMode().getSelectedItem());

        if (isOk) {
            new WriteCommandAction.Simple(project, psiFile) {
                @Override
                protected void run() throws Throwable {
                    EncryptionAlgorithm algorithm = (EncryptionAlgorithm) form.getAlgorithm().getSelectedItem();
                    EncryptionMode mode = (EncryptionMode) form.getMode().getSelectedItem();

                    try {
                        String originalValue = selectedProperty.getValue();
                        String encryptedProperty = originalValue.substring(2, originalValue.length() - 1);

                        byte[] decryptedBytes = algorithm.getBuilder().forKey(form.getEncryptionKey().getText()).using(mode)
                                .build().decrypt(Base64.decode(encryptedProperty));

                        selectedProperty.setValue(new String(decryptedBytes));
                    } catch (Exception e) {
                        Notification notification = MuleUIUtils.MULE_NOTIFICATION_GROUP.createNotification("Unable to decrypt property",
                                "Property '" + selectedProperty.getKey() + "' cannot be decrypted : " + e, NotificationType.ERROR, null);
                        Notifications.Bus.notify(notification, project);
                    }
                }
            }.execute();
        }
    }

    @Override
    public void update(AnActionEvent anActionEvent) {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());

        boolean isProperty = false;
        boolean isPropertyFile = false;
        boolean isEncrypted = false;

        if (file != null) {
            isPropertyFile = "properties".equalsIgnoreCase(file.getExtension());
            if (isPropertyFile) {
                IProperty selectedProperty = getSelectedProperty(anActionEvent.getDataContext());
                String propertyValue = selectedProperty.getValue();
                isEncrypted = (propertyValue.startsWith("![") && propertyValue.endsWith("]"));
                isProperty = true;
            }
            anActionEvent.getPresentation().setEnabled(isPropertyFile && isEncrypted && isProperty);
            anActionEvent.getPresentation().setVisible(isPropertyFile && isProperty);
        }
    }

    @Nullable
    private IProperty getSelectedProperty(DataContext context) {
        IProperty selectedProperty = null;
        PsiElement selectedPropertyPsi = null;
        final PsiElement[] psiElementsArray = LangDataKeys.PSI_ELEMENT_ARRAY.getData(context);
        if (psiElementsArray != null && psiElementsArray.length > 0)
            selectedPropertyPsi = psiElementsArray[0];
        else
            selectedPropertyPsi = LangDataKeys.PSI_ELEMENT.getData(context);

        if (selectedPropertyPsi != null) {
            selectedProperty = (IProperty) selectedPropertyPsi;
        }
        return selectedProperty;
    }
}
