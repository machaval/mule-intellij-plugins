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

  @Override
  protected void resetEditorFrom(@NotNull MuleRemoteConfiguration configuration) {
    muleRemoteDebuggerConfPanel.updateFromConfig(configuration);
  }

  @Override
  protected void applyEditorTo(@NotNull MuleRemoteConfiguration configuration) throws ConfigurationException {
    configuration.setHost(muleRemoteDebuggerConfPanel.getHostText());
    configuration.setPort(muleRemoteDebuggerConfPanel.getPortNumber());
  }

  @NotNull
  @Override
  protected JComponent createEditor() {
    return muleRemoteDebuggerConfPanel.getMainPanel();
  }
}
