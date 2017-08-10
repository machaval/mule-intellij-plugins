package org.mule.tooling.esb.launcher.configuration.runner;

import com.intellij.debugger.impl.GenericDebuggerRunner;
import com.intellij.execution.DefaultExecutionResult;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.RemoteConnection;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugProcessStarter;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManager;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.debugger.MuleDebugProcess;
import org.mule.tooling.esb.debugger.session.MuleDebuggerSession;
import org.mule.tooling.esb.launcher.configuration.MuleRemoteConfiguration;

import java.util.Map;


public class MuleRemoteDebugger extends GenericDebuggerRunner {

    @NonNls
    private static final String ID = "MuleESBDebuggerRunner";
    public static final String JAVA_CONTEXT = "Java";
    public static final String MULE_CONTEXT = "Mule";

    public MuleRemoteDebugger() {
        super();
    }

    @NotNull
    @Override
    public String getRunnerId() {
        return ID;
    }

    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        return executorId.equals(DefaultDebugExecutor.EXECUTOR_ID) && profile instanceof MuleRemoteConfiguration;
    }

    @Override
    protected RunContentDescriptor doExecute(@NotNull RunProfileState state, @NotNull ExecutionEnvironment env) throws ExecutionException {
        FileDocumentManager.getInstance().saveAllDocuments();
        return createContentDescriptor(state, env);
    }

    @Nullable
    protected RunContentDescriptor attachVirtualMachine(final RunProfileState state, final @NotNull ExecutionEnvironment env, RemoteConnection connection, boolean pollConnection)
            throws ExecutionException {
        final MuleDebuggerSession muleDebuggerSession = new MuleDebuggerSession(env.getProject());

        //TODO - pass the module name to the muleDebuggerSession
        final MuleRemoteConfiguration configuration = (MuleRemoteConfiguration) env.getRunProfile();

        final MuleRunnerState muleRunnerState = (MuleRunnerState) state;
        muleDebuggerSession.connect(muleRunnerState.getHost(), muleRunnerState.getPort());
        return XDebuggerManager.getInstance(env.getProject()).startSession(env, new XDebugProcessStarter() {
            @NotNull
            public XDebugProcess start(@NotNull XDebugSession session) {
                //Init Mule Debug Process
                //Register All Processes
                Map<String, String> modulesToAppsMap = null;
                if (configuration.isCustomAppsMap())
                    modulesToAppsMap = configuration.getModulesToAppsMap();
                return new MuleDebugProcess(session, muleDebuggerSession, new DefaultExecutionResult(), modulesToAppsMap);
            }
        }).getRunContentDescriptor();

    }

}