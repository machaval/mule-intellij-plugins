package org.mule.tooling.esb.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.lang.raml.file.RamlFileType;
import org.mule.tooling.lang.raml.util.RamlIcons;
import org.mule.tools.apikit.ScaffolderAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class APIKitScaffoldingAction extends AnAction
{

    final static Logger logger = Logger.getInstance(APIKitScaffoldingAction.class);

    public APIKitScaffoldingAction()
    {
        super("Generate Flows", "Generate APIKit scaffolding from the RAML definition", RamlIcons.RamlFileType);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent)
    {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final Project project = anActionEvent.getProject();
        final VirtualFile moduleContentRoot = ProjectRootManager.getInstance(project).getFileIndex().getContentRootForFile(file);
        String appPath = moduleContentRoot.getPath() + File.separator + MuleConfigUtils.CONFIG_RELATIVE_PATH;

        logger.debug("*** APP PATH IS " + appPath);

        final File appDir = new File(appPath);

        logger.debug("*** APP DIR IS DIRECTORY = " + appDir.isDirectory());

        final List<File> ramlFiles = new ArrayList<File>();
        final File ramlFile = new File(file.getPath());
        ramlFiles.add(ramlFile);
        try
        {
            new ScaffolderAPI().execute(ramlFiles, appDir, null, "3.8");
        }
        finally
        {
            file.getParent().getParent().refresh(false, true);
        }
    }

    @Override
    public void update(AnActionEvent anActionEvent)
    {
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
