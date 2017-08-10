package org.mule.tooling.esb.launcher.configuration;


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
import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.launcher.configuration.runner.MuleRunnerCommandLineState;
import org.mule.tooling.esb.launcher.configuration.ui.MuleRunnerEditor;
import org.mule.tooling.esb.sdk.MuleSdk;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MuleConfiguration extends ModuleBasedConfiguration implements ModuleRunProfile, RunConfigurationWithSuppressedDefaultDebugAction
{

    public static final String PREFIX = "MuleESBConfig-";
    public static final String VM_ARGS_FIELD = PREFIX + "VmArgs";
    public static final String MULE_HOME_FIELD = PREFIX + "MuleHome";
    public static final String CLEAR_DATA_FIELD = PREFIX + "ClearData";

    private String vmArgs;
    private String muleHome;
    private String clearData;

    private Module[] modules = new Module[] {};

    private Project project;

    protected MuleConfiguration(String name, @NotNull ConfigurationFactory factory, Project project)
    {
        //super(name, new JavaRunConfigurationModule(project, true), factory);
        super(name, new MuleRunConfigurationModule(project, true), factory);
        this.project = project;
    }


    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor()
    {
        return new MuleRunnerEditor(this);
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException
    {
        return new MuleRunnerCommandLineState(executionEnvironment, this);
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException
    {
        super.readExternal(element);
        this.vmArgs = JDOMExternalizerUtil.readField(element, VM_ARGS_FIELD);
        this.muleHome = JDOMExternalizerUtil.readField(element, MULE_HOME_FIELD);
        this.clearData = JDOMExternalizerUtil.readField(element, CLEAR_DATA_FIELD);

        getConfigurationModule().readExternal(element);
    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException
    {
        super.writeExternal(element);
        // Stores the values of this class into the parent
        JDOMExternalizerUtil.writeField(element, VM_ARGS_FIELD, this.getVmArgs());
        JDOMExternalizerUtil.writeField(element, MULE_HOME_FIELD, this.getMuleHome());
        JDOMExternalizerUtil.writeField(element, CLEAR_DATA_FIELD, this.getClearData());

        getConfigurationModule().writeExternal(element);
    }

    @Override
    public Collection<Module> getValidModules()
    {
        return MuleConfigUtils.getMuleModules(this.project, true);
    }


    @Override
    public void checkConfiguration() throws RuntimeConfigurationException
    {
        final String muleHome = getMuleHome();
        if (StringUtils.isBlank(muleHome))
        {
            throw new RuntimeConfigurationException("Mule home can not be empty.");
        }
        if (!new File(muleHome).exists())
        {
            throw new RuntimeConfigurationException("Mule home does not exists : " + muleHome);
        }

        if (!MuleSdk.isValidMuleHome(getMuleHome()))
        {
            throw new RuntimeConfigurationException(muleHome + " path is not a valid Mule home.");
        }

        if (getModules() == null || getModules().length < 1)
        {
            throw new RuntimeConfigurationException("Modules list can not be empty.");
        }
        super.checkConfiguration();
    }

    @Nullable
    public String getVmArgs()
    {
        return vmArgs;
    }

    @Nullable
    public String getMuleHome()
    {
        return muleHome;
    }

    public void setVmArgs(@Nullable String vmArgs) {
        this.vmArgs = vmArgs;
    }

    public void setMuleHome(@Nullable String muleHome)
    {
        this.muleHome = muleHome;
    }

    @Nullable
    public String getClearData() {
        return clearData;
    }

    public void setClearData(@Nullable String clearData) {
        this.clearData = clearData;
    }

    @NotNull
    @Override
    public Module[] getModules() {
        MuleRunConfigurationModule configurationModule = (MuleRunConfigurationModule)this.getConfigurationModule();
        return configurationModule.getModules();
    }

    public void setModules(Module[] modules) {
//        this.modules = modules;
        MuleRunConfigurationModule configurationModule = (MuleRunConfigurationModule)this.getConfigurationModule();
        configurationModule.setModules(modules);
    }
}
