package org.mule.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;

import org.mule.tools.apikit.ScaffolderAPI;
import org.mule.lang.raml.file.RamlFileType;

import org.mule.util.MuleIcons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class APIKitScaffoldingAction extends AnAction {

    final static Logger logger = Logger.getInstance(APIKitScaffoldingAction.class);

    public APIKitScaffoldingAction() {
        super("Generate Flows", "Generate APIKit scaffolding from the RAML definition", MuleIcons.RamlFileType);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        Project project = anActionEvent.getProject();
        VirtualFile moduleContentRoot = ProjectRootManager.getInstance(project).getFileIndex().getContentRootForFile(file);
        String appPath = moduleContentRoot.getPath() + "/src/main/app";
        logger.debug("*** APP PATH IS " + appPath);
        File appDir = new File(appPath);
        List<File> ramlFiles = new ArrayList<File>();
        ramlFiles.add(new File(file.getPath()));
        logger.debug("*** RAML FILES : " + ramlFiles);
        new ScaffolderAPI().execute(ramlFiles, appDir, null, null);
        logger.debug("*** ScaffolderAPI ran successfully");
    }

    @Override
    public void update(AnActionEvent anActionEvent) {

        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final boolean isRAML;
        if (file != null)
        {
            isRAML = RamlFileType.getInstance().getDefaultExtension().equalsIgnoreCase(file.getExtension());
            anActionEvent.getPresentation().setEnabled(isRAML);
            anActionEvent.getPresentation().setVisible(isRAML);
        }

    }


}
