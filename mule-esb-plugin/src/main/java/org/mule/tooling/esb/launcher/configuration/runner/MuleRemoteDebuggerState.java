package org.mule.tooling.esb.launcher.configuration.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.RemoteConnection;
import com.intellij.execution.configurations.RemoteState;
import com.intellij.execution.runners.ProgramRunner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class MuleRemoteDebuggerState implements MuleRunnerState, RemoteState {

  private String host;
  private int port;
  private int jvmPort;

  public MuleRemoteDebuggerState(String host, int port, int jvmPort) {
    this.host = host;
    this.port = port;
    this.jvmPort = jvmPort;
  }

  @Override
  public String getHost() {
    return host;
  }

  @Override
  public int getPort() {
    return port;
  }

  @Override
  public RemoteConnection getRemoteConnection() {
    return new RemoteConnection(true, host, jvmPort + "", false);
  }

  @Nullable
  @Override
  public ExecutionResult execute(Executor executor, @NotNull ProgramRunner runner) throws ExecutionException {
    return null;
  }
}
