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


public class MulRunnerEditor extends SettingsEditor<MuleConfiguration> {

    private MuleRunnerConfPanel configurationPanel;
    private String mainOutputDirectory;

    public MulRunnerEditor(MuleConfiguration runnerConfiguration) {
        this.configurationPanel = new MuleRunnerConfPanel(runnerConfiguration.getProject());
        super.resetFrom(runnerConfiguration);
    }

    /**
     * This is invoked when the form is first loaded.
     * The values may be stored in disk, if not, set some defaults
     */
    @Override
    protected void resetEditorFrom(MuleConfiguration runnerConfiguration) {
        final Project project = runnerConfiguration.getProject();
        //TODO filter for mule modules only
        this.configurationPanel.getModuleCombo().setModules(Arrays.asList(runnerConfiguration.getModules()));
        //Fix for intermittent java.lang.ArrayIndexOutOfBoundsException
        Module[] modules = runnerConfiguration.getModules();
        if (modules != null && modules.length > 0) {
            Module selectedModule = modules[0];
            final String moduleName = runnerConfiguration.getModuleName();
            if (StringUtils.isNotBlank(moduleName)) {
                final Module moduleByName = ModuleManager.getInstance(project).findModuleByName(moduleName);
                if (moduleByName != null) {
                    selectedModule = moduleByName;
                }
            }
            this.configurationPanel.getModuleCombo().setSelectedModule(selectedModule);
            this.configurationPanel.getVmArgsField().setText(runnerConfiguration.getVmArgs());
            this.configurationPanel.getMuleHome().setText(runnerConfiguration.getMuleHome());
        }
    }

    /**
     * This is invoked when the user fills the form and pushes apply/ok
     *
     * @param runnerConfiguration runnerConfiguration
     * @throws ConfigurationException ex
     */
    @Override
    protected void applyEditorTo(MuleConfiguration runnerConfiguration) throws ConfigurationException {
        runnerConfiguration.setVmArgs(this.configurationPanel.getVmArgsField().getText());
        runnerConfiguration.setMuleHome(this.configurationPanel.getMuleHome().getText());
        final Module selectedModule = this.configurationPanel.getModuleCombo().getSelectedModule();
        if (selectedModule != null) {
            runnerConfiguration.setModuleName(selectedModule.getName());
        }
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return this.configurationPanel.getMainPanel();
    }

    // Helpers


    public void setConfigurationPanel(MuleRunnerConfPanel configurationPanel) {
        this.configurationPanel = configurationPanel;
    }
}
