package org.mule.tooling.esb.launcher.configuration.runner;

import com.intellij.debugger.DebuggerManagerEx;
import com.intellij.debugger.DefaultDebugEnvironment;
import com.intellij.debugger.engine.DebugProcessImpl;
import com.intellij.debugger.engine.JavaDebugProcess;
import com.intellij.debugger.impl.DebuggerSession;
import com.intellij.debugger.impl.GenericDebuggerRunner;
import com.intellij.debugger.ui.tree.render.BatchEvaluator;
import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.configurations.RemoteConnection;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.util.containers.HashMap;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugProcessStarter;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManager;
import com.intellij.xdebugger.impl.XDebugSessionImpl;
import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.debugger.ContextAwareDebugProcess;
import org.mule.tooling.esb.debugger.MuleDebugProcess;
import org.mule.tooling.esb.debugger.session.MessageReceivedListener;
import org.mule.tooling.esb.debugger.session.MuleDebuggerSession;
import org.mule.tooling.esb.launcher.configuration.MuleConfiguration;

import java.util.List;
import java.util.Map;


public class MuleProgramDebugger extends GenericDebuggerRunner {

  @NonNls
  private static final String ID = "MuleESBDebuggerRunner";
  public static final String JAVA_CONTEXT = "Java";
  public static final String MULE_CONTEXT = "Mule";

  public MuleProgramDebugger() {
    super();
  }

  @NotNull
  @Override
  public String getRunnerId() {
    return ID;
  }

  @Override
  public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
    return executorId.equals(DefaultDebugExecutor.EXECUTOR_ID) && profile instanceof MuleConfiguration;
  }

  @Override
  protected RunContentDescriptor doExecute(@NotNull RunProfileState state, @NotNull ExecutionEnvironment env) throws ExecutionException {
    FileDocumentManager.getInstance().saveAllDocuments();
    return createContentDescriptor(state, env);
  }

  @Nullable
  protected RunContentDescriptor attachVirtualMachine(final RunProfileState state, final @NotNull ExecutionEnvironment env, RemoteConnection connection, boolean pollConnection)
          throws ExecutionException {
    DefaultDebugEnvironment environment = new DefaultDebugEnvironment(env, state, connection, pollConnection);
    final DebuggerSession debuggerSession = DebuggerManagerEx.getInstanceEx(env.getProject()).attachVirtualMachine(environment);
    final MuleDebuggerSession muleDebuggerSession = new MuleDebuggerSession(env.getProject());
    if (debuggerSession == null) {
      return null;
    } else {
      final DebugProcessImpl debugProcess = debuggerSession.getProcess();
      if (!debugProcess.isDetached() && !debugProcess.isDetaching()) {
        if (environment.isRemote()) {
          debugProcess.putUserData(BatchEvaluator.REMOTE_SESSION_KEY, Boolean.TRUE);
        }

        return XDebuggerManager.getInstance(env.getProject()).startSession(env, new XDebugProcessStarter() {
          @NotNull
          public XDebugProcess start(@NotNull XDebugSession session) {

            final XDebugSessionImpl sessionImpl = (XDebugSessionImpl) session;
            final ExecutionResult executionResult = debugProcess.getExecutionResult();
            final Map<String, XDebugProcess> context = new HashMap<>();
            final ContextAwareDebugProcess contextAwareDebugProcess = new ContextAwareDebugProcess(session, executionResult.getProcessHandler(), context, JAVA_CONTEXT);

            muleDebuggerSession.addMessageReceivedListener(new MessageReceivedListener() {
              @Override
              public void onNewMessageReceived(MuleMessageInfo muleMessageInfo) {
                contextAwareDebugProcess.setContext(MULE_CONTEXT);
              }

              @Override
              public void onExceptionThrown(MuleMessageInfo muleMessageInfo, ObjectFieldDefinition exceptionThrown) {
                contextAwareDebugProcess.setContext(MULE_CONTEXT);
              }

              @Override
              public void onExecutionStopped(MuleMessageInfo muleMessageInfo, List<ObjectFieldDefinition> frame, String path, String internalPosition) {
                contextAwareDebugProcess.setContext(MULE_CONTEXT);
              }
            });

            debuggerSession.getContextManager().addListener((newContext, event) -> contextAwareDebugProcess.setContext(JAVA_CONTEXT));

            //Init Java Debug Process
            sessionImpl.addExtraActions(executionResult.getActions());
            if (executionResult instanceof DefaultExecutionResult) {
              sessionImpl.addRestartActions(((DefaultExecutionResult) executionResult).getRestartActions());
              sessionImpl.addExtraStopActions(((DefaultExecutionResult) executionResult).getAdditionalStopActions());
            }
            final JavaDebugProcess javaDebugProcess = JavaDebugProcess.create(session, debuggerSession);

            //Init Mule Debug Process
            final MuleRunnerState muleRunnerState = (MuleRunnerState) state;
            muleDebuggerSession.connectAsync(muleRunnerState.getHost(), muleRunnerState.getPort());
            final MuleDebugProcess muleDebugProcess = new MuleDebugProcess(session, muleDebuggerSession, executionResult, null);

            //Register All Processes
            context.put(JAVA_CONTEXT, javaDebugProcess);
            context.put(MULE_CONTEXT, muleDebugProcess);
            return contextAwareDebugProcess;
          }
        }).getRunContentDescriptor();
      } else {
        debuggerSession.dispose();
        muleDebuggerSession.disconnect();
        return null;
      }
    }
  }

}