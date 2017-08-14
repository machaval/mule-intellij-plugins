package org.mule.tooling.lang.raml.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import org.mule.tooling.lang.raml.RamlLanguage;
import org.mule.tooling.lang.raml.file.RamlFileType;
import org.mule.tooling.lang.raml.util.RamlIcons;
import org.mule.tooling.lang.raml.util.xsd2raml.Xsd2Raml;

public class XSDToRAMLAction extends AnAction {

    final static Logger logger = Logger.getInstance(XSDToRAMLAction.class);

    public XSDToRAMLAction()
    {
        super("Generate RAML Types from XSD (Beta)", "Generate RAML 1.0 Types from XSD (Beta)", RamlIcons.RamlFileType);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent)
    {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final Project project = anActionEvent.getProject();

        Xsd2Raml xsd2Raml = new Xsd2Raml(file.getUrl());
        String raml = xsd2Raml.getRaml();

        PsiFile psiFile = PsiFileFactory.getInstance(anActionEvent.getProject()).createFileFromText(RamlLanguage.INSTANCE, raml);

        new WriteCommandAction.Simple(project, psiFile) {
            @Override
            protected void run() throws Throwable {
                psiFile.setName(file.getNameWithoutExtension() + "." + RamlFileType.INSTANCE.getDefaultExtension());

                PsiDirectory directory = CommonDataKeys.PSI_FILE.getData(anActionEvent.getDataContext()).getContainingDirectory();
                directory.add(psiFile);
            }
        }.execute();

    }

    @Override
    public void update(AnActionEvent anActionEvent)
    {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final boolean isXSD;
        if (file != null)
        {
            isXSD = "xsd".equalsIgnoreCase(file.getExtension()) || "wsdl".equalsIgnoreCase(file.getExtension());
            anActionEvent.getPresentation().setEnabled(isXSD);
            anActionEvent.getPresentation().setVisible(isXSD);
        }

    }

}
