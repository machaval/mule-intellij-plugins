package org.mule.tooling.esb.config.refactoring.rename;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.refactoring.listeners.RefactoringElementListener;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.launcher.configuration.project.MuleDeployProperties;
import org.mule.tooling.esb.launcher.configuration.project.MuleProjectManager;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.esb.util.MulePathUtils;

import java.nio.file.Paths;

/**
 * Created by eberman on 11/29/16.
 */
public class RenameXMLConfigProcessor extends RenamePsiElementProcessor {
    final static Logger logger = Logger.getInstance(RenameXMLConfigProcessor.class);

    @Override
    public boolean canProcessElement(@NotNull PsiElement psiElement) {
        logger.debug("PSI Element is " + psiElement);
        return (psiElement instanceof PsiFile && MuleConfigUtils.isMuleFile((PsiFile)psiElement));
    }

    @Override
    public void renameElement(PsiElement element, String newName, UsageInfo[] usages, @Nullable RefactoringElementListener listener) throws IncorrectOperationException {
        PsiFile psiFile = (PsiFile)element;
        String oldName = psiFile.getName();

        super.renameElement(element, newName, usages, listener);

        VirtualFile virtualFile = psiFile.getVirtualFile();

        ProjectRootManager mgr = ProjectRootManager.getInstance(psiFile.getProject());
        if (mgr != null) {

            ProjectFileIndex projectIndex = mgr.getFileIndex();
            Module module = projectIndex.getModuleForFile(virtualFile);

            if (module != null) { // File belongs to this module
                String moduleContentRoot = projectIndex.getContentRootForFile(virtualFile).getCanonicalPath();
                String appPath = Paths.get(moduleContentRoot, MuleConfigUtils.CONFIG_RELATIVE_PATH).toString();

                String oldAbsolutePath = Paths.get(virtualFile.getParent().getPath(), oldName).toString();
                String newAbsolutePath = Paths.get(virtualFile.getParent().getPath(), newName).toString();
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
