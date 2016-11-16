package org.mule.tooling.lang.dw.editor;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
<<<<<<< HEAD
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
=======
>>>>>>> machaval/develop-dw
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

import javax.swing.*;

/**
 * Created by eberman on 11/15/16.
 */
public class OpenSampleAction extends AnAction {

    final static Logger logger = Logger.getInstance(OpenSampleAction.class);
    final static Icon loadSampleIcon = IconLoader.findIcon("/opensample.png");

    Document document;

    public OpenSampleAction(Document document)
    {
        super("Load Sample", "Load Sample Data", loadSampleIcon);
        this.document = document;
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        logger.debug("Loading sample!");

        final Project project = anActionEvent.getProject();
        final PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);

        VirtualFile sample = FileChooser.chooseFile(FileChooserDescriptorFactory.createSingleFileNoJarsDescriptor(),
                project, null);
        if (sample == null)
            return;

        try {
            final String text = new String(sample.contentsToByteArray(), sample.getCharset());

            new WriteCommandAction.Simple(project, psiFile) {
                @Override
                protected void run() throws Throwable {
                    document.setText(text);
                }
            }.execute();
        } catch (Exception e) {
            logger.error(e);
        }

    }

}
