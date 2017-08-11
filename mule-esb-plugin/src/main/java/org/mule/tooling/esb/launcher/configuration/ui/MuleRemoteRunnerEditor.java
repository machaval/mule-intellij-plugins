package org.mule.tooling.esb.launcher.configuration.ui;


import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.launcher.configuration.MuleRemoteConfiguration;

import javax.swing.*;

public class MuleRemoteRunnerEditor extends SettingsEditor<MuleRemoteConfiguration> {

    private MuleRemoteDebuggerConfPanel muleRemoteDebuggerConfPanel;

    public MuleRemoteRunnerEditor() {
        muleRemoteDebuggerConfPanel = new MuleRemoteDebuggerConfPanel();
    }

    public MuleRemoteRunnerEditor(MuleRemoteConfiguration runnerConfiguration)
    {
        this.muleRemoteDebuggerConfPanel = new MuleRemoteDebuggerConfPanel();
        super.resetFrom(runnerConfiguration);
    }

    @Override
    protected void resetEditorFrom(@NotNull MuleRemoteConfiguration configuration) {
        muleRemoteDebuggerConfPanel.updateFromConfig(configuration);
    }

    @Override
    protected void applyEditorTo(@NotNull MuleRemoteConfiguration configuration) throws ConfigurationException {
        configuration.setHost(muleRemoteDebuggerConfPanel.getHostText());
        configuration.setPort(muleRemoteDebuggerConfPanel.getPortNumber());
        configuration.setJvmPort(muleRemoteDebuggerConfPanel.getJvmPortNumber());
        configuration.setCustomAppsMap(muleRemoteDebuggerConfPanel.isCustomAppsMapping());
        configuration.setModulesToAppsMap(muleRemoteDebuggerConfPanel.getModuleToAppsMap());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return muleRemoteDebuggerConfPanel.getMainPanel();
    }
}
