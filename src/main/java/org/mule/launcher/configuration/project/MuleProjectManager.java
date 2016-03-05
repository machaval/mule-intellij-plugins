package org.mule.launcher.configuration.project;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.*;
import com.intellij.openapi.vfs.tracker.VirtualFileTracker;
import com.intellij.openapi.vfs.tracker.VirtualFileTrackerImpl;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.mule.config.model.Mule;
import org.mule.util.MuleSupport;

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

    @Override
    public void projectOpened() {
        VirtualFileManager manager = VirtualFileManager.getInstance();

        manager.addVirtualFileListener(new VirtualFileAdapter()
        {
            @Override
            public void fileCreated(@NotNull VirtualFileEvent event) {

                try {
                    ProjectFileIndex projectIndex = ProjectRootManager.getInstance(MuleProjectManager.this.myProject).getFileIndex();
                    Module module = projectIndex.getModuleForFile(event.getFile());
                    if (module != null) { // File belongs to this module

                        String fileName = event.getFileName();
                        String fileAbsolutePath = event.getFile().getPath();

                        String moduleContentRoot = projectIndex.getContentRootForFile(event.getFile()).getCanonicalPath();
                        String appPath = moduleContentRoot + "/src/main/app";

                        PsiFile psiFile = PsiManager.getInstance(MuleProjectManager.this.myProject).findFile(event.getFile());

                        /** TODO - this does not work becase rootTag is empty
                        logger.warn("*** PSI FILE IS " + psiFile);
                        final XmlFile psiFile1 = (XmlFile) psiFile;
                        final XmlTag rootTag = psiFile1.getRootTag();
                        logger.warn("*** ROOT TAG IS " + rootTag);
                        logger.warn("*** LOCAL NAME IS " + rootTag.getLocalName());
                        */

                        if (fileAbsolutePath.startsWith(appPath)) { //The file was created in src/main/app
                            if (psiFile.getFileType() == StdFileTypes.XML) { //This is config file
                                String pathRelative = getRelativePath(fileAbsolutePath, appPath);
                                MuleDeployProperties.addConfigFile(appPath, pathRelative);
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.error(e);
                }
            }

            @Override
            public void beforeFileDeletion(@NotNull VirtualFileEvent event) {

                ProjectFileIndex projectIndex = ProjectRootManager.getInstance(MuleProjectManager.this.myProject).getFileIndex();
                Module module = projectIndex.getModuleForFile(event.getFile());

                if (module != null) { // File belongs to this module
                    String fileName = event.getFileName();
                    String fileAbsolutePath = event.getFile().getPath();

                    String moduleContentRoot = projectIndex.getContentRootForFile(event.getFile()).getCanonicalPath();
                    String appPath = moduleContentRoot + "/src/main/app";
                    PsiFile psiFile = PsiManager.getInstance(MuleProjectManager.this.myProject).findFile(event.getFile());
                    if (fileAbsolutePath.startsWith(appPath)) { //The file was deleted in src/main/app
                        if (MuleSupport.isMuleFile(psiFile)) { //This is config file
                            String pathRelative = getRelativePath(fileAbsolutePath, appPath);
                            MuleDeployProperties.deleteConfigFile(appPath, pathRelative);
                        } else if (event.getFile().isDirectory()) {
                            /* TODO
                            In `VirtualFileAdapter.beforeFileDeletion` the virtual directory still exists and you may invoke `getChildren()` on it.
                            */
                        }
                    }
                }
            }

            @Override
            public void beforeFileMovement(@NotNull VirtualFileMoveEvent event) {

                ProjectFileIndex projectIndex = ProjectRootManager.getInstance(MuleProjectManager.this.myProject).getFileIndex();
                Module module = projectIndex.getModuleForFile(event.getFile());

                if (module != null) { // File belongs to this module

                    String fileName = event.getFileName();

                    String oldAbsolutePath = event.getOldParent().getPath() + "/" + fileName;
                    String newAbsolutePath = event.getNewParent() + "/" + fileName;

                    String moduleContentRoot = projectIndex.getContentRootForFile(event.getFile()).getCanonicalPath();
                    String appPath = moduleContentRoot + "/src/main/app";

                    PsiFile psiFile = PsiManager.getInstance(MuleProjectManager.this.myProject).findFile(event.getFile());
                    if (MuleSupport.isMuleFile(psiFile)) { //This is config file

                        if (oldAbsolutePath.startsWith(appPath)) { //The file was in src/main/app, remove
                            String pathRelative = getRelativePath(oldAbsolutePath, appPath);
                            MuleDeployProperties.deleteConfigFile(appPath, pathRelative);
                        }
                        if (newAbsolutePath.startsWith(appPath)) { //The file now is in src/main/app, add
                            String pathRelative = getRelativePath(newAbsolutePath, appPath);
                            MuleDeployProperties.addConfigFile(appPath, pathRelative);
                        }
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
