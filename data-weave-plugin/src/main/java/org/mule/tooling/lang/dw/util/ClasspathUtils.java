package org.mule.tooling.lang.dw.util;

import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.CompilerModuleExtension;
import com.intellij.openapi.roots.OrderEnumerator;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.CachedValueProvider;
import com.intellij.psi.util.CachedValuesManager;
import com.intellij.psi.util.ParameterizedCachedValue;
import com.intellij.psi.util.ParameterizedCachedValueProvider;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.editor.WeaveEditor;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * Created by eberman on 2/22/17.
 */
public class ClasspathUtils {
    private static final Key<ParameterizedCachedValue<List<URL>, Module>> URLS_KEY = Key.create("MODULE.URLS");

    public static ClassLoader getProjectClassLoader(Project project, ClassLoader parent) throws Exception {
        ClassLoader fullClassLoader = null;

        List<URL> loaderUrls = new ArrayList<>();

        Module[] modulesList = ModuleManager.getInstance(project).getModules();
        for (Module nextModule : modulesList) {
            loaderUrls.addAll(getURLsForModule(nextModule));
        }

        fullClassLoader = new URLClassLoader(loaderUrls.toArray(new URL[] {}), parent);

        return fullClassLoader;
    }

    public static ClassLoader getModuleClassLoader(Module module, ClassLoader parent) throws Exception {
        ClassLoader moduleClassLoader = null;

        List<URL> loaderUrls = getURLsForModule(module);

        moduleClassLoader = new URLClassLoader(loaderUrls.toArray(new URL[] {}), parent);

        return moduleClassLoader;
    }

    private static List<URL> getURLsForModule(Module module) throws Exception {

        final CachedValuesManager manager = CachedValuesManager.getManager(module.getProject());
        List<URL> loaderUrls = manager.getParameterizedCachedValue(module, URLS_KEY, new ClasspathUtils.UrlsCachedProvider(), false, module);

        return loaderUrls;
    }

    private static class UrlsCachedProvider implements ParameterizedCachedValueProvider<List<URL>, Module> {
        @Nullable
        @Override
        public CachedValueProvider.Result<List<URL>> compute(Module module) {
            List<URL> loaderUrls = new ArrayList<>();

            ArrayList<Object> dependencies = new ArrayList<Object>();
            dependencies.add(ProjectRootManager.getInstance(module.getProject()));
            //dependencies.add(module);

            String fullClasspath = OrderEnumerator.orderEntries(module).recursively().getPathsList().getPathsString();

            String[] cpEntries = fullClasspath.split(":");
            for (String nextEntry : cpEntries) {
                try {
                    URL url = (nextEntry.endsWith(".jar") ? new URL("jar:file://" + nextEntry + "!/") : new URL("file://" + nextEntry));
                    loaderUrls.add(url);
                } catch (Exception e) {

                }
            }

            CompilerModuleExtension extension = CompilerModuleExtension.getInstance(module);
            String[] outputRootUrls = extension.getOutputRootUrls(false);
            for (String nextUrlString : outputRootUrls) {
                if (!nextUrlString.endsWith("/"))
                    nextUrlString = nextUrlString + "/";
                try {
                    loaderUrls.add(new URL(nextUrlString));
                } catch (Exception e) {

                }
            }

            return CachedValueProvider.Result.create(loaderUrls, dependencies);
        }


    }
}
