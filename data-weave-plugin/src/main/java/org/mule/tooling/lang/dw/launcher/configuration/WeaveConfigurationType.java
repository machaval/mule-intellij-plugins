package org.mule.tooling.lang.dw.launcher.configuration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.dw.WeaveIcons;

import javax.swing.*;

public class WeaveConfigurationType implements ConfigurationType
{

    private ConfigurationFactory weaveFactory;

    public WeaveConfigurationType()
    {
        weaveFactory = new WeaveConfigurationFactory(this);
    }

    @Override
    public String getDisplayName()
    {
        return "DataWeave";
    }

    @Override
    public String getConfigurationTypeDescription()
    {
        return "Runs a DataWeave script";
    }

    @Override
    public Icon getIcon()
    {
        return WeaveIcons.DataWeaveIcon;
    }

    @NotNull
    @Override
    public String getId()
    {
        return "org.mule.lang.dw.configuration";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories()
    {
        return new ConfigurationFactory[] {weaveFactory};
    }

    @NotNull
    public static WeaveConfigurationType getInstance()
    {
        return ConfigurationTypeUtil.findConfigurationType(WeaveConfigurationType.class);
    }

}
