package org.mule.tooling.esb.launcher.configuration;


import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.LocatableConfigurationBase;
import com.intellij.execution.configurations.RemoteRunProfile;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationWithSuppressedDefaultDebugAction;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.RunConfigurationWithSuppressedDefaultRunAction;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizerUtil;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.launcher.configuration.runner.MuleRemoteDebuggerState;
import org.mule.tooling.esb.launcher.configuration.ui.MuleRemoteRunnerEditor;

public class MuleRemoteConfiguration extends LocatableConfigurationBase implements RunConfigurationWithSuppressedDefaultRunAction, RemoteRunProfile {

  public static final String PORT_PROP_NAME = "mule.remote.port";
  public static final String HOST_PORT_NAME = "mule.remote.host";
  private int port = 6666;
  private String host = "localhost";

  protected MuleRemoteConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory, String name) {
    super(project, factory, name);
  }

  @Nullable
  @Override
  public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
    return new MuleRemoteDebuggerState(host, port);
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    super.readExternal(element);
    try {
      this.port = Integer.parseInt(JDOMExternalizerUtil.readField(element, PORT_PROP_NAME, "6666"));
    } catch (Exception e) {
      //Ignore bad ports
    }
    this.host = JDOMExternalizerUtil.readField(element, HOST_PORT_NAME, "localhost");
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    super.writeExternal(element);
    // Stores the values of this class into the parent
    JDOMExternalizerUtil.writeField(element, HOST_PORT_NAME, this.host);
    JDOMExternalizerUtil.writeField(element, PORT_PROP_NAME, String.valueOf(this.port));
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  @Nullable
  @Override
  public String suggestedName() {
    return "Remote Mule Debugger Configuration";
  }

  @NotNull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    return new MuleRemoteRunnerEditor();
  }


}
