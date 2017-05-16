package org.mule.tooling.esb.launcher.configuration.ui;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.launcher.configuration.MuleConfiguration;
import org.mule.tooling.esb.sdk.MuleSdkManager;
import org.mule.tooling.esb.sdk.MuleSdk;

import javax.swing.*;
import java.util.Collection;


public class MuleRunnerEditor extends SettingsEditor<MuleConfiguration>
{
    public static String CLEAR_DATA_ALWAYS = "Always";
    public static String CLEAR_DATA_NEVER = "Never";
    public static String CLEAR_DATA_PROMPT = "Prompt";

    private MuleRunnerConfPanel configurationPanel;

    public MuleRunnerEditor(MuleConfiguration runnerConfiguration)
    {
        this.configurationPanel = new MuleRunnerConfPanel();
        super.resetFrom(runnerConfiguration);
    }

    /**
     * This is invoked when the form is first loaded.
     * The values may be stored in disk, if not, set some defaults
     */
    @Override
    protected void resetEditorFrom(MuleConfiguration runnerConfiguration)
    {
        this.configurationPanel.getModulesList().setModules(runnerConfiguration.getValidModules());

        Module[] selectedModules = runnerConfiguration.getModules();
        if (selectedModules != null) {
            for (Module m : selectedModules)
                this.configurationPanel.getModulesList().selectModule(m, true);
        }
        this.configurationPanel.getVmArgsField().setText(runnerConfiguration.getVmArgs());

        String muleHome = runnerConfiguration.getMuleHome();
        if (StringUtils.isBlank(muleHome))
        {
            if (selectedModules != null && selectedModules.length > 0) {
            final MuleSdk from = MuleSdk.getFrom(selectedModules[0]);
                if (from != null)
                {
                    muleHome = from.getMuleHome();
                }
            }
        }
        this.configurationPanel.getMuleHome().setSelectedItem(MuleSdkManager.getInstance().findSdk(muleHome));

        String clearData = runnerConfiguration.getClearData();
        JRadioButton selectedButton = this.configurationPanel.getPromptRadioButton();

        if (CLEAR_DATA_ALWAYS.equals(clearData))
            selectedButton = this.configurationPanel.getAlwaysRadioButton();
        else if (CLEAR_DATA_NEVER.equals(clearData))
            selectedButton = this.configurationPanel.getNeverRadioButton();

        selectedButton.setSelected(true);
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
        final Object selectedItem = this.configurationPanel.getMuleHome().getSelectedItem();
        runnerConfiguration.setMuleHome(selectedItem instanceof MuleSdk ? ((MuleSdk) selectedItem).getMuleHome() : "");

        if (this.configurationPanel.getAlwaysRadioButton().isSelected())
            runnerConfiguration.setClearData(CLEAR_DATA_ALWAYS);
        else if (this.configurationPanel.getNeverRadioButton().isSelected())
            runnerConfiguration.setClearData(CLEAR_DATA_NEVER);
        else
            runnerConfiguration.setClearData(CLEAR_DATA_PROMPT);

        Module[] selectedModules = this.configurationPanel.getModulesList().getSelectedModules(runnerConfiguration.getProject());
//        final Module selectedModule = this.configurationPanel.getModuleCombo().getSelectedModule();
        if (selectedModules != null)
        {
            runnerConfiguration.setModules(selectedModules);
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
