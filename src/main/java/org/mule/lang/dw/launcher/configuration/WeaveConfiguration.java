package org.mule.lang.dw.launcher.configuration;


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
import org.mule.lang.dw.launcher.configuration.runner.WeaveRunnerCommandLine;
import org.mule.lang.dw.launcher.configuration.ui.WeaveInput;
import org.mule.lang.dw.util.WeaveSdk;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WeaveConfiguration extends ModuleBasedConfiguration implements ModuleRunProfile, RunConfigurationWithSuppressedDefaultDebugAction
{

    public static final String PREFIX = "DataWeaveConfig-";
    public static final String WEAVE_HOME_FIELD = PREFIX + "WeaveHome";
    public static final String WEAVE_FILE = PREFIX + "WeaveFile";
    public static final String WEAVE_OUTPUT = PREFIX + "WeaveOutput";
    public static final String WEAVE_INPUT = "WeaveInput";


    private String weaveHome;
    private Project project;
    private String weaveFile;
    private String weaveOutput;
    private List<WeaveInput> weaveInputs;

    protected WeaveConfiguration(String name, @NotNull ConfigurationFactory factory, Project project)
    {
        super(name, new JavaRunConfigurationModule(project, true), factory);
        this.project = project;
        this.weaveInputs = new ArrayList<>();
    }


    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor()
    {
        return new WeaveRunnerEditor(this);
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException
    {
        return new WeaveRunnerCommandLine(executionEnvironment, this);
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException
    {
        super.readExternal(element);
        this.weaveHome = JDOMExternalizerUtil.readField(element, WEAVE_HOME_FIELD);
        this.weaveFile = JDOMExternalizerUtil.readField(element, WEAVE_FILE);
        this.weaveOutput = JDOMExternalizerUtil.readField(element, WEAVE_OUTPUT);
        final List<Element> children = element.getChildren(WEAVE_INPUT);
        this.weaveInputs = new ArrayList<>();
        for (Element child : children)
        {
            final WeaveInput weaveInput = new WeaveInput();
            weaveInput.readExternal(child);
            weaveInputs.add(weaveInput);
        }
        getConfigurationModule().readExternal(element);
    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException
    {
        super.writeExternal(element);
        // Stores the values of this class into the parent
        JDOMExternalizerUtil.writeField(element, WEAVE_HOME_FIELD, this.getWeaveHome());
        JDOMExternalizerUtil.writeField(element, WEAVE_FILE, this.getWeaveFile());
        JDOMExternalizerUtil.writeField(element, WEAVE_OUTPUT, this.getWeaveOutput());
        JDOMExternalizerUtil.addChildren(element, WEAVE_INPUT, weaveInputs);
        getConfigurationModule().writeExternal(element);
    }

    @Override
    public Collection<Module> getValidModules()
    {
        final ModuleManager moduleManager = ModuleManager.getInstance(this.project);
        return Arrays.asList(moduleManager.getModules());
    }


    @Override
    public void checkConfiguration() throws RuntimeConfigurationException
    {
        final String muleHome = getWeaveHome();
        if (StringUtils.isBlank(muleHome))
        {
            throw new RuntimeConfigurationException("Weave home can not be empty.");
        }
        if (!new File(muleHome).exists())
        {
            throw new RuntimeConfigurationException("Weave home does not exists : " + muleHome);
        }

        if (!WeaveSdk.isValidWeaveHome(getWeaveHome()))
        {
            throw new RuntimeConfigurationException(muleHome + " path is not a valid Weave home.");
        }

        if (StringUtils.isBlank(getWeaveFile()))
        {
            throw new RuntimeConfigurationException(getWeaveFile() + " weave file can not be empty.");
        }

        if (getModule() == null)
        {
            throw new RuntimeConfigurationException("Module can not be empty.");
        }
        super.checkConfiguration();
    }


    @Nullable
    public String getWeaveHome()
    {
        return weaveHome;
    }

    @Nullable
    public String getModuleName()
    {
        final Module module = getModule();
        return module != null ? module.getName() : null;
    }


    public String getWeaveFile()
    {
        return weaveFile;
    }

    public void setWeaveFile(String weaveFile)
    {
        this.weaveFile = weaveFile;
    }

    public String getWeaveOutput()
    {
        return weaveOutput;
    }

    public void setWeaveOutput(String weaveOutput)
    {
        this.weaveOutput = weaveOutput;
    }

    public void setMuleHome(String weaveHome)
    {
        this.weaveHome = weaveHome;
    }

    public Module getModule()
    {
        return getConfigurationModule().getModule();
    }

    public List<WeaveInput> getWeaveInputs()
    {
        return weaveInputs;
    }

    public void setWeaveInputs(@NotNull List<WeaveInput> weaveInputs)
    {
        this.weaveInputs = weaveInputs;
    }
}
