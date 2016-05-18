package org.mule.lang.dw.launcher.configuration;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.dw.launcher.configuration.ui.WeaveRunnerConfPanel;

import javax.swing.*;
import java.util.Collection;


public class WeaveRunnerEditor extends SettingsEditor<WeaveConfiguration>
{

    private WeaveRunnerConfPanel configurationPanel;

    public WeaveRunnerEditor(WeaveConfiguration runnerConfiguration)
    {
        this.configurationPanel = new WeaveRunnerConfPanel(runnerConfiguration.getProject());
        super.resetFrom(runnerConfiguration);
    }


    /**
     * This is invoked when the form is first loaded.
     * The values may be stored in disk, if not, set some defaults
     */
    @Override
    protected void resetEditorFrom(WeaveConfiguration runnerConfiguration)
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
        this.configurationPanel.getWeaveFile().setText(runnerConfiguration.getWeaveFile());
        this.configurationPanel.getOutput().setText(runnerConfiguration.getWeaveOutput());
        this.configurationPanel.getWeaveHome().setText(runnerConfiguration.getWeaveHome());
        this.configurationPanel.getWeaveInputs().setItems(runnerConfiguration.getWeaveInputs());
    }

    /**
     * This is invoked when the user fills the form and pushes apply/ok
     *
     * @param runnerConfiguration runnerConfiguration
     * @throws ConfigurationException ex
     */
    @Override
    protected void applyEditorTo(WeaveConfiguration runnerConfiguration) throws ConfigurationException
    {
        runnerConfiguration.setWeaveOutput(this.configurationPanel.getOutput().getText());
        runnerConfiguration.setWeaveFile(this.configurationPanel.getWeaveFile().getText());
        runnerConfiguration.setMuleHome(this.configurationPanel.getWeaveHome().getText());
        final Module selectedModule = this.configurationPanel.getModuleCombo().getSelectedModule();
        if (selectedModule != null)
        {
            runnerConfiguration.setModule(selectedModule);
        }
        runnerConfiguration.setWeaveInputs(this.configurationPanel.getWeaveInputs().getItems());
    }

    @NotNull
    @Override
    protected JComponent createEditor()
    {
        return this.configurationPanel.getMainPanel();
    }


}
