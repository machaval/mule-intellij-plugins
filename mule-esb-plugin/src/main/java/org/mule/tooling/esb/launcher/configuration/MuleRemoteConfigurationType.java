package org.mule.tooling.esb.launcher.configuration;


import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;

public class MuleRemoteConfigurationType implements ConfigurationType {

  private ConfigurationFactory esbFactory;

  public MuleRemoteConfigurationType() {
    esbFactory = new MuleRemoteConfigurationFactory(this);
  }

  @Override
  public String getDisplayName() {
    return "Mule ESB Remote Debug";
  }

  @Override
  public String getConfigurationTypeDescription() {
    return "Mule ESB Remote Debug";
  }

  @Override
  public Icon getIcon() {
    return MuleIcons.MuleRemoteDebugIcon;
  }

  @NotNull
  @Override
  public String getId() {
    return "org.mule.esb.remote.configuration";
  }

  @Override
  public ConfigurationFactory[] getConfigurationFactories() {
    return new ConfigurationFactory[]{esbFactory};
  }

  @NotNull
  public static MuleRemoteConfigurationType getInstance() {
    return ConfigurationTypeUtil.findConfigurationType(MuleRemoteConfigurationType.class);
  }

}
