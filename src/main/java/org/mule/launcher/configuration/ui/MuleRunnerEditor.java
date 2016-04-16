package org.mule.launcher.configuration.ui;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.mule.launcher.configuration.MuleConfiguration;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;


public class MuleRunnerEditor extends SettingsEditor<MuleConfiguration>
{

    private MuleRunnerConfPanel configurationPanel;

    public MuleRunnerEditor(MuleConfiguration runnerConfiguration)
    {
        this.configurationPanel = new MuleRunnerConfPanel(runnerConfiguration.getProject());
        super.resetFrom(runnerConfiguration);
    }

    /**
     * This is invoked when the form is first loaded.
     * The values may be stored in disk, if not, set some defaults
     */
    @Override
    protected void resetEditorFrom(MuleConfiguration runnerConfiguration)
    {
        this.configurationPanel.getModuleCombo().setModules(runnerConfiguration.getValidModules());
        Module selectedModule = runnerConfiguration.getModule();
        if (selectedModule == null)
        {
            Collection<Module> modules = runnerConfiguration.getValidModules();
            if (modules.size() > 0)
            {
                selectedModule = modules.iterator().next();
            }
        }
        this.configurationPanel.getModuleCombo().setSelectedModule(selectedModule);
        this.configurationPanel.getVmArgsField().setText(runnerConfiguration.getVmArgs());
        String muleHome = runnerConfiguration.getMuleHome();
        if (StringUtils.isBlank(muleHome))
        {
            muleHome = System.getenv("MULE_HOME");
        }
        this.configurationPanel.getMuleHome().setText(muleHome);
    }

    /**
     * This is invoked when the user fills the form and pushes apply/ok
     *
     * @param runnerConfiguration runnerConfiguration
     * @throws ConfigurationException ex
     */
    @Override
    protected void applyEditorTo(MuleConfiguration runnerConfiguration) throws ConfigurationException
    {
        runnerConfiguration.setVmArgs(this.configurationPanel.getVmArgsField().getText());
        runnerConfiguration.setMuleHome(this.configurationPanel.getMuleHome().getText());
        final Module selectedModule = this.configurationPanel.getModuleCombo().getSelectedModule();
        if (selectedModule != null)
        {
            runnerConfiguration.setModule(selectedModule);
        }
    }

    @NotNull
    @Override
    protected JComponent createEditor()
    {
        return this.configurationPanel.getMainPanel();
    }

    // Helpers


    public void setConfigurationPanel(MuleRunnerConfPanel configurationPanel)
    {
        this.configurationPanel = configurationPanel;
    }
}
