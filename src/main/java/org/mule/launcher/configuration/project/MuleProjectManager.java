package org.mule.launcher.configuration.project;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileMoveEvent;
import com.intellij.openapi.vfs.tracker.VirtualFileTracker;
import com.intellij.openapi.vfs.tracker.VirtualFileTrackerImpl;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by eberman on 3/3/16.
 */
public class MuleProjectManager  extends AbstractProjectComponent {
    Logger logger = Logger.getInstance(MuleProjectManager.class);

    protected MuleProjectManager(Project project) {
        super(project);
    }

    private final String appPath = MuleProjectManager.this.myProject.getBasePath() + "/" + MuleDeployProperties.MULE_DEPLOY_PROPERTIES_DIR;

    @Override
    public void projectOpened() {
        VirtualFileManager manager = VirtualFileManager.getInstance();

        manager.addVirtualFileListener(new VirtualFileAdapter()
        {
            @Override
            public void fileCreated(@NotNull VirtualFileEvent event) {
                String fileName = event.getFileName();
                String fileAbsolutePath = event.getFile().getPath();

                if (fileAbsolutePath.startsWith(appPath)) { //The file was created in src/main/app
                    if (fileName.endsWith(".xml")) { //This is config file
                        String pathRelative = getRelativePath(fileAbsolutePath, appPath);
                        MuleDeployProperties.addConfigFile(MuleProjectManager.this.myProject.getBasePath(), pathRelative);
                    }
                }
            }

            @Override
            public void fileDeleted(@NotNull VirtualFileEvent event) {
                String fileName = event.getFileName();
                String fileAbsolutePath = event.getFile().getPath();

                if (fileAbsolutePath.startsWith(appPath)) { //The file was deleted in src/main/app
                    if (fileName.endsWith(".xml")) { //This is config file
                        String pathRelative = getRelativePath(fileAbsolutePath, appPath);
                        MuleDeployProperties.deleteConfigFile(MuleProjectManager.this.myProject.getBasePath(), pathRelative);
                    } else if (event.getFile().isDirectory()) {
                        //TODO - how to delete all files in directory...
                    }
                }
            }

            @Override
            public void fileMoved(@NotNull VirtualFileMoveEvent event) {
                String fileName = event.getFileName();

                String oldAbsolutePath = event.getOldParent().getPath() + "/" + fileName;
                String newAbsolutePath = event.getNewParent() + "/" + fileName;

                if (fileName.endsWith(".xml")) { //This is config file

                    if (oldAbsolutePath.startsWith(appPath)) { //The file was in src/main/app, remove
                        String pathRelative = getRelativePath(oldAbsolutePath, appPath);
                        MuleDeployProperties.deleteConfigFile(MuleProjectManager.this.myProject.getBasePath(), pathRelative);
                    }
                    if (newAbsolutePath.startsWith(appPath)) { //The file was in src/main/app, remove
                        String pathRelative = getRelativePath(newAbsolutePath, appPath);
                        MuleDeployProperties.addConfigFile(MuleProjectManager.this.myProject.getBasePath(), pathRelative);
                    }
                }
            }

            //=======================================

            private String getRelativePath(String absolutePath, String appPath) {
                Path pathAbsolute = Paths.get(absolutePath);
                Path pathBase = Paths.get(appPath);
                Path pathRelative = pathBase.relativize(pathAbsolute);

                return pathRelative.toString();
            }

        });
    }

}
