package org.mule.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.mule.lang.raml.RamlFileType;
import org.mule.tools.apikit.ScaffolderAPI;
import org.mule.util.MuleIcons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eberman on 3/4/16.
 */
public class APIKitScaffoldingAction extends AnAction {

    Logger logger = Logger.getInstance(APIKitScaffoldingAction.class);

    public APIKitScaffoldingAction() {
        super("Generate Flows", "Generate APIKit scaffolding from the RAML definition", MuleIcons.RamlFileType);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        Project project = anActionEvent.getProject();
        VirtualFile moduleContentRoot = ProjectRootManager.getInstance(project).getFileIndex().getContentRootForFile(file);
        String appPath = moduleContentRoot.getPath() + "/src/main/app";
        //logger.warn("*** APP PATH IS " + appPath);
        File appDir = new File(appPath);
        List<File> ramlFiles = new ArrayList<File>();
        ramlFiles.add(new File(file.getPath()));
        //new ScaffolderAPI().run(ramlFiles, appDir);
        new ScaffolderAPI().execute(ramlFiles, appDir, null, null);
        //logger.warn("*** ScaffolderAPI ran successfully");
    }

    @Override
    public void update(AnActionEvent anActionEvent) {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final boolean isRAML = RamlFileType.getInstance().getDefaultExtension().equalsIgnoreCase(file.getExtension());
        anActionEvent.getPresentation().setEnabled(isRAML);
        anActionEvent.getPresentation().setVisible(isRAML);
    }
}
