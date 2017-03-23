package org.mule.tooling.lang.dw.debug;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.DefaultProgramRunner;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugProcessStarter;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManager;
import com.mulesoft.weave.debugger.client.DebuggerClient;
import com.mulesoft.weave.debugger.client.tcp.TcpClientDebuggerProtocol;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.launcher.configuration.WeaveConfiguration;
import org.mule.tooling.lang.dw.launcher.configuration.runner.WeaveRunnerCommandLine;

public class WeaveDebuggerRunner extends DefaultProgramRunner {

  @NonNls
  private static final String ID = "WeaveDebuggerRunner";

  public WeaveDebuggerRunner() {
    super();
  }

  @NotNull
  @Override
  public String getRunnerId() {
    return ID;
  }

  @Override
  public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
    return executorId.equals(DefaultDebugExecutor.EXECUTOR_ID) && profile instanceof WeaveConfiguration;
  }

  @Override
  protected RunContentDescriptor doExecute(@NotNull RunProfileState state, @NotNull ExecutionEnvironment env) throws ExecutionException {
    FileDocumentManager.getInstance().saveAllDocuments();
    return attachVirtualMachine(state, env);
  }

  @Nullable
  protected RunContentDescriptor attachVirtualMachine(final RunProfileState state, final @NotNull ExecutionEnvironment env)
          throws ExecutionException {

    return XDebuggerManager.getInstance(env.getProject()).startSession(env, new XDebugProcessStarter() {
      @NotNull
      public XDebugProcess start(@NotNull XDebugSession session) throws ExecutionException {
        WeaveRunnerCommandLine weaveRunnerCommandLine = (WeaveRunnerCommandLine) state;
        final String weaveFile = weaveRunnerCommandLine.getModel().getWeaveFile();
        final Project project = weaveRunnerCommandLine.getEnvironment().getProject();
        final VirtualFile projectFile = project.getBaseDir();
        final String path = project.getBasePath();
        final String relativePath = weaveFile.substring(path.length());
        final VirtualFile fileByRelativePath = projectFile.findFileByRelativePath(relativePath);
        final DebuggerClient localhost = new DebuggerClient(new WeaveDebuggerClientListener(session, fileByRelativePath), new TcpClientDebuggerProtocol("localhost", 6565));
        final ExecutionResult result = state.execute(env.getExecutor(), WeaveDebuggerRunner.this);
        new DebuggerConnector(localhost).start();
        return new WeaveDebugProcess(session, localhost, result);
      }
    }).getRunContentDescriptor();

  }

  private static class DebuggerConnector extends Thread {
    private final DebuggerClient localhost;

    public DebuggerConnector(DebuggerClient localhost) {
      this.localhost = localhost;
    }

    @Override
    public void run() {
      int i = 0;
      while (i < 50) {
        try {
          System.out.println("Trying to connect " + i);
          localhost.connect();
          System.out.println("Weave connected");
          return;
        } catch (Exception e) {
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e1) {
            return;
          }
          i++;
        }
      }
    }
  }
}