package org.mule.tooling.lang.dw.util;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.CompilerModuleExtension;
import com.intellij.openapi.roots.OrderEnumerator;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by eberman on 2/22/17.
 */
public class PluginUtils {

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
        List<URL> loaderUrls = new ArrayList<>();

        String fullClasspath = OrderEnumerator.orderEntries(module).recursively().getPathsList().getPathsString();

        String[] cpEntries = fullClasspath.split(":");
        for (String nextEntry : cpEntries) {
            URL url = (nextEntry.endsWith(".jar") ? new URL("jar:file://" + nextEntry + "!/") : new URL("file://" + nextEntry));
            loaderUrls.add(url);
        }

        CompilerModuleExtension extension = CompilerModuleExtension.getInstance(module);
        String[] outputRootUrls = extension.getOutputRootUrls(false);
        for (String nextUrlString : outputRootUrls) {
            if (!nextUrlString.endsWith("/"))
                nextUrlString = nextUrlString + "/";
            loaderUrls.add(new URL(nextUrlString));
        }

        return loaderUrls;
    }
}
