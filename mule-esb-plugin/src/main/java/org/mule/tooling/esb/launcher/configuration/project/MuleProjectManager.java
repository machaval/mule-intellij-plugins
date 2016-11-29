package org.mule.tooling.esb.launcher.configuration.project;

import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileMoveEvent;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.esb.util.MulePathUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MuleProjectManager extends AbstractProjectComponent {

    static final Logger logger = Logger.getInstance(MuleProjectManager.class);

    protected MuleProjectManager(Project project) {
        super(project);
    }

    @Override
    public void projectOpened() {
        VirtualFileManager manager = VirtualFileManager.getInstance();
        manager.addVirtualFileListener(new VirtualFileAdapter() {
            @Override
            public void fileCreated(@NotNull VirtualFileEvent event) {
                try {
                    if (MuleProjectManager.this.myProject != null && MuleProjectManager.this.myProject.isInitialized() && MuleProjectManager.this.myProject.isOpen()) {
                        ProjectRootManager mgr = ProjectRootManager.getInstance(MuleProjectManager.this.myProject);
                        if (mgr != null) {
                            ProjectFileIndex projectIndex = mgr.getFileIndex();
                            Module module = projectIndex.getModuleForFile(event.getFile());
                            if (module != null) { // File belongs to this module

                                String fileAbsolutePath = event.getFile().getPath();

                                String moduleContentRoot = projectIndex.getContentRootForFile(event.getFile()).getCanonicalPath();
                                String appPath = Paths.get(moduleContentRoot, MuleConfigUtils.CONFIG_RELATIVE_PATH).toString();

                                PsiFile psiFile = PsiManager.getInstance(MuleProjectManager.this.myProject).findFile(event.getFile());

                                /** TODO - this does not work becase rootTag is empty
                                 logger.warn("*** PSI FILE IS " + psiFile);
                                 final XmlFile psiFile1 = (XmlFile) psiFile;
                                 final XmlTag rootTag = psiFile1.getRootTag();
                                 logger.warn("*** ROOT TAG IS " + rootTag);
                                 logger.warn("*** LOCAL NAME IS " + rootTag.getLocalName());
                                 */

                                if (psiFile != null && fileAbsolutePath.startsWith(appPath)) { //The file was created in src/main/app
                                    if (psiFile.getFileType() == StdFileTypes.XML) { //This is config file
                                        String pathRelative = MulePathUtils.getRelativePath(fileAbsolutePath, appPath);
                                        MuleDeployProperties.addConfigFile(appPath, pathRelative);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    logger.error(e);
                }
            }

            @Override
            public void beforeFileDeletion(@NotNull VirtualFileEvent event) {
                if (MuleProjectManager.this.myProject != null && MuleProjectManager.this.myProject.isInitialized() && MuleProjectManager.this.myProject.isOpen()) {
                    ProjectRootManager mgr = ProjectRootManager.getInstance(MuleProjectManager.this.myProject);
                    if (mgr != null) {

                        ProjectFileIndex projectIndex = mgr.getFileIndex();
                        Module module = projectIndex.getModuleForFile(event.getFile());

                        if (module != null) { // File belongs to this module
                            String fileAbsolutePath = event.getFile().getPath();

                            String moduleContentRoot = projectIndex.getContentRootForFile(event.getFile()).getCanonicalPath();
                            String appPath = Paths.get(moduleContentRoot, MuleConfigUtils.CONFIG_RELATIVE_PATH).toString();
                            PsiFile psiFile = PsiManager.getInstance(MuleProjectManager.this.myProject).findFile(event.getFile());
                            if (fileAbsolutePath.startsWith(appPath)) { //The file was deleted in src/main/app
                                if (MuleConfigUtils.isMuleFile(psiFile)) { //This is config file
                                    String pathRelative = MulePathUtils.getRelativePath(fileAbsolutePath, appPath);
                                    MuleDeployProperties.deleteConfigFile(appPath, pathRelative);
                                } else if (event.getFile().isDirectory()) {
                            /* TODO
                            In `VirtualFileAdapter.beforeFileDeletion` the virtual directory still exists and you may invoke `getChildren()` on it.
                            */
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void beforeFileMovement(@NotNull VirtualFileMoveEvent event) {

                if (MuleProjectManager.this.myProject != null && MuleProjectManager.this.myProject.isInitialized() && MuleProjectManager.this.myProject.isOpen()) {
                    ProjectRootManager mgr = ProjectRootManager.getInstance(MuleProjectManager.this.myProject);
                    if (mgr != null) {

                        ProjectFileIndex projectIndex = mgr.getFileIndex();
                        Module module = projectIndex.getModuleForFile(event.getFile());

                        if (module != null) { // File belongs to this module

                            String fileName = event.getFileName();

                            String oldAbsolutePath = Paths.get(event.getOldParent().getPath(), fileName).toString();
                            String newAbsolutePath = Paths.get(event.getNewParent().getPath(), fileName).toString();

                            String moduleContentRoot = projectIndex.getContentRootForFile(event.getFile()).getCanonicalPath();
                            String appPath = Paths.get(moduleContentRoot, MuleConfigUtils.CONFIG_RELATIVE_PATH).toString();

                            PsiFile psiFile = PsiManager.getInstance(MuleProjectManager.this.myProject).findFile(event.getFile());
                            if (MuleConfigUtils.isMuleFile(psiFile)) { //This is config file

                                if (oldAbsolutePath.startsWith(appPath)) { //The file was in src/main/app, remove
                                    String pathRelative = MulePathUtils.getRelativePath(oldAbsolutePath, appPath);
                                    MuleDeployProperties.deleteConfigFile(appPath, pathRelative);
                                }
                                if (newAbsolutePath.startsWith(appPath)) { //The file now is in src/main/app, add
                                    String pathRelative = MulePathUtils.getRelativePath(newAbsolutePath, appPath);
                                    MuleDeployProperties.addConfigFile(appPath, pathRelative);
                                }
                            }

                        }
                    }
                }
            }
            //=======================================



        });
    }

}
