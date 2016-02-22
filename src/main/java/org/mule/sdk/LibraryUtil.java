package org.mule.sdk;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.LocalFileProvider;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LibraryUtil {

    @Nullable
    public static VirtualFile findJarWithClass(@NotNull Module module, final String classQName) {
        GlobalSearchScope scope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(module);
        for (PsiClass psiClass : JavaPsiFacade.getInstance(module.getProject()).findClasses(classQName, scope)) {
            VirtualFile virtualFile = psiClass.getContainingFile().getVirtualFile();
            final VirtualFile local = getLocalFor(virtualFile);
            if (local != null) {
                return local;
            }
        }
        return null;
    }

    private static VirtualFile getLocalFor(VirtualFile virtualFile) {
        VirtualFileSystem fileSystem = virtualFile == null ? null : virtualFile.getFileSystem();
        return fileSystem instanceof LocalFileProvider ? ((LocalFileProvider)fileSystem).getLocalVirtualFileFor(virtualFile) : null;
    }

}
