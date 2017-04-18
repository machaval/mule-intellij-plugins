package org.mule.tooling.esb.actions;

import com.intellij.icons.AllIcons;
import com.intellij.lang.properties.IProperty;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.bouncycastle.util.encoders.Base64;
import org.jetbrains.annotations.Nullable;
import org.mule.security.encryption.binary.jce.algorithms.EncryptionAlgorithm;
import org.mule.security.encryption.binary.jce.algorithms.EncryptionMode;
import org.mule.tooling.esb.encrypt.ui.EncryptDialog;

public class EncryptPropertyAction extends AnAction
{

    private static final String ENCRYPT_SUFFIX = "]";
    private static final String ENCRYPT_PREFIX = "![";

    final static Logger logger = Logger.getInstance(EncryptPropertyAction.class);


    public EncryptPropertyAction()
    {
        super("Encrypt...", "Encrypt Property Value with one of available encryption algorithms", AllIcons.FileTypes.Properties);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent)
    {
        final Project project = (Project)anActionEvent.getData(CommonDataKeys.PROJECT);

        PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);

        IProperty selectedProperty = getSelectedProperty(anActionEvent.getDataContext());
        if (selectedProperty == null)
            return;

        final EncryptDialog form = new EncryptDialog();
        form.setTitle("Encrypt Property: " + selectedProperty.getKey());
        form.show();
        boolean isOk = form.getExitCode() == DialogWrapper.OK_EXIT_CODE;

//        System.out.println("******** IS OK " + isOk);
        logger.debug("**** ALGORITHM " + form.getAlgorithm().getSelectedItem());
        logger.debug("**** MODE " + form.getMode().getSelectedItem());

        if (isOk) {
            new WriteCommandAction.Simple(project, psiFile) {
                @Override
                protected void run() throws Throwable {
                    EncryptionAlgorithm algorithm = (EncryptionAlgorithm) form.getAlgorithm().getSelectedItem();
                    EncryptionMode mode = (EncryptionMode) form.getMode().getSelectedItem();

                    byte[] encryptedBytes = algorithm.getBuilder().forKey(form.getEncryptionKey().getText()).using(mode)
                            .build().encrypt(selectedProperty.getValue().getBytes());
                    StringBuilder result = new StringBuilder();
                    result.append(ENCRYPT_PREFIX);
                    result.append(new String(Base64.encode(encryptedBytes)));
                    result.append(ENCRYPT_SUFFIX);
                    selectedProperty.setValue(result.toString());
                }
            }.execute();
        }
    }

    @Override
    public void update(AnActionEvent anActionEvent)
    {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());

        boolean isProperty = false;
        boolean isPropertyFile = false;
        boolean isEncrypted = false;

        if (file != null)
        {
            isPropertyFile = "properties".equalsIgnoreCase(file.getExtension());
            if (isPropertyFile) {

                IProperty selectedProperty = getSelectedProperty(anActionEvent.getDataContext());
                if (selectedProperty != null) {
                    String propertyValue = selectedProperty.getValue();
                    isEncrypted = (propertyValue.startsWith("![") && propertyValue.endsWith("]"));
                    isProperty = true;
                }
            }
            anActionEvent.getPresentation().setEnabled(isPropertyFile && !isEncrypted && isProperty);
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

        if (selectedPropertyPsi != null && selectedPropertyPsi instanceof IProperty) {
            selectedProperty = (IProperty) selectedPropertyPsi;
        }
        return selectedProperty;
    }
}
