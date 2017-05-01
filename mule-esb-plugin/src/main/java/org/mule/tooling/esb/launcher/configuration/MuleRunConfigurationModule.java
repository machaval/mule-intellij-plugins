package org.mule.tooling.esb.launcher.configuration;

import com.intellij.execution.configurations.JavaRunConfigurationModule;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by eberman on 4/27/17.
 */
public class MuleRunConfigurationModule extends JavaRunConfigurationModule {
    private static final Logger LOG = Logger.getInstance(MuleRunConfigurationModule.class);

    private Set<String> myModules = new HashSet<>();

    public MuleRunConfigurationModule(@NotNull Project project, boolean classesInLibs) {
        super(project, classesInLibs);
    }

    @Override
    public void writeExternal(@NotNull Element parent) {
        super.writeExternal(parent);
        Element prev = parent.getChild("modules");
        if (prev == null) {
            prev = new Element("modules");
            parent.addContent(prev);
        }
        if (myModules.size() > 0)
            prev.removeContent();
        for (String nextName : myModules.toArray(new String[] {})) {
            Element nextM = new Element("module");
            nextM.setAttribute("name", nextName);
            prev.addContent(nextM);
        }
    }

    @Override
    public void readExternal(@NotNull Element element) {
        super.readExternal(element);
        List<Element> modules = element.getChildren("modules");
        if(!modules.isEmpty()) {
            if(modules.size() > 1) {
                LOG.warn("Modules serialized more than one time");
            }

            Element modulesElement = modules.get(0);
            List<Element> moduleElements = modulesElement.getChildren("module");

            for (Element nextM :  moduleElements) {
                String nextModuleName = nextM.getAttributeValue("name");
                if (!StringUtil.isEmpty(nextModuleName)) {
//                    Module m = findModule(nextModuleName);
//                    Module m = ModuleManager.getInstance(getProject()).findModuleByName(nextModuleName);
//                    if (m != null) {
                        myModules.add(nextModuleName);
//                    }
                }
            }
        }
    }

    public Module[] getModules() {
        List<Module> modules = new ArrayList<>();
        for (String mName : myModules.toArray(new String[] {})) {
            modules.add(this.findModule((mName)));
        }
        return modules.toArray(new Module[] {});
    }

    public void setModules(Module[] modules) {
        myModules.clear();
        for (Module m : modules) {
            myModules.add(m.getName());
        }
    }

}
