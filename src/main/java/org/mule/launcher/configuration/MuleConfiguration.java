package org.mule.launcher.configuration;


import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizerUtil;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.launcher.configuration.runner.MuleRunnerCommandLine;
import org.mule.launcher.configuration.ui.MulRunnerEditor;

public class MuleConfiguration extends LocatableConfigurationBase implements ModuleRunProfile, RunConfigurationWithSuppressedDefaultDebugAction {

    public static final String PREFIX = "MuleESBConfig-";
    public static final String VM_ARGS_FIELD = PREFIX + "VmArgs";
    public static final String MULE_HOME_FIELD = PREFIX + "MuleHome";
    public static final String MULE_MODULE_FIELD = PREFIX + "Module";
    private String vmArgs;
    private String muleHome;
    private String moduleName;
    private Project project;


    protected MuleConfiguration(String name, @NotNull ConfigurationFactory factory, Project project) {
        super(project, factory, name);
        this.project = project;
    }


    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new MulRunnerEditor(this);
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
        return new MuleRunnerCommandLine(executionEnvironment, this);
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException {
        super.readExternal(element);
        this.vmArgs = JDOMExternalizerUtil.readField(element, VM_ARGS_FIELD);
        this.muleHome = JDOMExternalizerUtil.readField(element, MULE_HOME_FIELD);
        this.moduleName = JDOMExternalizerUtil.readField(element, MULE_MODULE_FIELD);
    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException {
        super.writeExternal(element);
        // Stores the values of this class into the parent
        JDOMExternalizerUtil.writeField(element, VM_ARGS_FIELD, this.getVmArgs());
        JDOMExternalizerUtil.writeField(element, MULE_HOME_FIELD, this.getMuleHome());
        JDOMExternalizerUtil.writeField(element, MULE_MODULE_FIELD, this.getModuleName());
    }

    @NotNull
    @Override
    public Module[] getModules() {
        ModuleManager moduleManager = ModuleManager.getInstance(this.project);
        return moduleManager.getModules();
    }

    @Nullable
    public String getVmArgs() {
        return vmArgs;
    }

    @Nullable
    public String getMuleHome() {
        return muleHome;
    }

    @Nullable
    public String getModuleName() {
        return moduleName;
    }

    @Nullable
    public Module getModule() {
        if (getModuleName() != null) {
            return ModuleManager.getInstance(project).findModuleByName(getModuleName());
        } else {
            return null;
        }
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setVmArgs(String vmArgs) {
        this.vmArgs = vmArgs;
    }

    public void setMuleHome(String muleHome) {
        this.muleHome = muleHome;
    }

}
