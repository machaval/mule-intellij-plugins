package org.mule.lang.dw.launcher.configuration;

import com.intellij.execution.BeforeRunTask;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import org.mule.launcher.configuration.MuleConfiguration;
import org.mule.launcher.configuration.MuleConfigurationType;


class WeaveConfigurationFactory extends ConfigurationFactory
{

    public WeaveConfigurationFactory(WeaveConfigurationType configurationType)
    {
        super(configurationType);
    }

    public RunConfiguration createTemplateConfiguration(Project project)
    {
        return new WeaveConfiguration("Data Weave", this, project);
    }

    @Override
    public void configureBeforeRunTaskDefaults(Key<? extends BeforeRunTask> providerID, BeforeRunTask task)
    {
        super.configureBeforeRunTaskDefaults(providerID, task);
    }
}
