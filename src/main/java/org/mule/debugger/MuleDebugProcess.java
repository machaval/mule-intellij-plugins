package org.mule.debugger;


import com.intellij.execution.ExecutionResult;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ExecutionConsole;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.util.ArrayUtil;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.evaluation.XDebuggerEditorsProvider;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.debugger.actions.ExceptionBreakpointSwitchAction;
import org.mule.debugger.breakpoint.MuleBreakpointHandler;
import org.mule.debugger.session.MessageReceivedListener;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleSupport;

public class MuleDebugProcess extends XDebugProcess {

    private MuleBreakpointHandler muleBreakpointHandler;
    private MuleDebuggerSession muleDebuggerSession;
    private MuleDebuggerEditorProperties editorProperties;
    private final ProcessHandler processHandler;
    private final ExecutionConsole executionConsole;

    public MuleDebugProcess(@NotNull final XDebugSession session, @NotNull MuleDebuggerSession muleDebuggerSession, ExecutionResult result) {
        super(session);
        this.muleDebuggerSession = muleDebuggerSession;
        this.muleBreakpointHandler = new MuleBreakpointHandler(session.getProject(), muleDebuggerSession);
        this.editorProperties = new MuleDebuggerEditorProperties();
        this.processHandler = result.getProcessHandler();
        this.executionConsole = result.getExecutionConsole();
        init();
    }

    public void init() {
        muleDebuggerSession.addMessageReceivedListener(new MessageReceivedListener() {
            @Override
            public void onNewMessageReceived(MuleMessageInfo muleMessageInfo) {
                getSession().positionReached(new MuleSuspendContext(new MuleStackFrame(getSession().getProject(), muleDebuggerSession, muleMessageInfo)));
            }

            @Override
            public void onExceptionThrown(MuleMessageInfo muleMessageInfo, ObjectFieldDefinition exceptionThrown) {
                getSession().positionReached(new MuleSuspendContext(new MuleStackFrame(getSession().getProject(), muleDebuggerSession, muleMessageInfo, exceptionThrown)));
            }
        });
    }

    protected Project getProject() {
        return getSession().getProject();
    }

    @Override
    public void startStepOver() {
        muleDebuggerSession.nextStep();
    }

    @NotNull
    @Override
    public ExecutionConsole createConsole() {
        return executionConsole;
    }

    @Override
    protected ProcessHandler doGetProcessHandler() {
        return processHandler;
    }

    @Override
    public void startStepInto() {
        muleDebuggerSession.nextStep();
    }

    @Override
    public void startStepOut() {
        muleDebuggerSession.nextStep();
    }

    @Override
    public void resume() {
        muleDebuggerSession.resume();
    }

    @Override
    public void registerAdditionalActions(@NotNull DefaultActionGroup leftToolbar, @NotNull DefaultActionGroup topToolbar, @NotNull DefaultActionGroup settings) {
        super.registerAdditionalActions(leftToolbar, topToolbar, settings);
        leftToolbar.add(new ExceptionBreakpointSwitchAction(muleDebuggerSession));
    }

    @Nullable
    @Override
    public XDebuggerEvaluator getEvaluator() {
        return new MuleScriptEvaluator(muleDebuggerSession);
    }

    @Override
    public void runToPosition(@NotNull XSourcePosition xSourcePosition) {
        muleDebuggerSession.runToCursor(MuleSupport.getMulePath(getProject(), xSourcePosition));
    }

    @Override
    public void stop() {
        muleDebuggerSession.disconnect();
    }

    @NotNull
    @Override
    public XBreakpointHandler<?>[] getBreakpointHandlers() {
        final XBreakpointHandler<?>[] breakpointHandlers = super.getBreakpointHandlers();
        return ArrayUtil.append(breakpointHandlers, muleBreakpointHandler);
    }

    @NotNull
    @Override
    public XDebuggerEditorsProvider getEditorsProvider() {
        return editorProperties;
    }

}
