package org.mule.tooling.esb.debugger;


import com.intellij.execution.ExecutionResult;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ExecutionConsole;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.util.ArrayUtil;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.evaluation.XDebuggerEditorsProvider;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.intellij.xdebugger.frame.XSuspendContext;
import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.debugger.actions.ExceptionBreakpointSwitchAction;
import org.mule.tooling.esb.debugger.breakpoint.MuleBreakpointHandler;
import org.mule.tooling.esb.debugger.session.MessageReceivedListener;
import org.mule.tooling.esb.debugger.session.MuleDebuggerSession;
import org.mule.tooling.esb.launcher.configuration.MuleConfiguration;

import java.util.List;

import static org.mule.tooling.esb.util.MuleConfigUtils.getMulePath;
import static org.mule.tooling.esb.util.MuleConfigUtils.getXmlTagAt;

public class MuleDebugProcess extends XDebugProcess
{

    private MuleBreakpointHandler muleBreakpointHandler;
    private MuleDebuggerSession muleDebuggerSession;
    private MuleDebuggerEditorProperties editorProperties;
    private final ProcessHandler processHandler;
    private final ExecutionConsole executionConsole;

    public MuleDebugProcess(@NotNull final XDebugSession session, @NotNull final MuleDebuggerSession muleDebuggerSession, ExecutionResult result)
    {
        super(session);
        this.muleDebuggerSession = muleDebuggerSession;
        this.muleBreakpointHandler = new MuleBreakpointHandler(muleDebuggerSession);
        this.editorProperties = new MuleDebuggerEditorProperties();
        this.processHandler = result.getProcessHandler();
        this.executionConsole = result.getExecutionConsole();
        init();
    }

//    private Module getModule()
//    {
//        Module[] m = ((MuleConfiguration) getSession().getRunProfile()).getModules();
//        if (m != null && m.length > 0) {
//            return m[0];
//        }
//
//        return null;
//        //return ((MuleConfiguration) getSession().getRunProfile()).getModule();
//    }

    public void init()
    {
        muleDebuggerSession.addMessageReceivedListener(new MessageReceivedListener()
        {
            @Override
            public void onNewMessageReceived(MuleMessageInfo muleMessageInfo)
            {

                getSession().positionReached(new MuleSuspendContext(new MuleStackFrame(getSession().getProject(), muleDebuggerSession, muleMessageInfo)));
            }

            @Override
            public void onExceptionThrown(MuleMessageInfo muleMessageInfo, ObjectFieldDefinition exceptionThrown)
            {

                getSession().positionReached(new MuleSuspendContext(new MuleStackFrame(getSession().getProject(), muleDebuggerSession, muleMessageInfo, exceptionThrown)));
            }

            @Override
            public void onExecutionStopped(MuleMessageInfo muleMessageInfo, List<ObjectFieldDefinition> frame, String path, String internalPosition)
            {
                System.out.println("MuleDebugProcess.onExecutionStopped : " + path + "#" + internalPosition);
                final WeaveIntegrationStackFrame weaveStackFrame = new WeaveIntegrationStackFrame(getSession().getProject(), muleDebuggerSession, path, internalPosition, frame);
                final MuleStackFrame muleStackFrame = new MuleStackFrame(getSession().getProject(), muleDebuggerSession, muleMessageInfo, null);
                getSession().positionReached(new MuleSuspendContext(weaveStackFrame, muleStackFrame));
            }

        });
    }

    protected Project getProject()
    {
        return getSession().getProject();
    }

    @Override
    public void startStepOver(@Nullable XSuspendContext context)
    {
        muleDebuggerSession.nextStep();
    }

    @NotNull
    @Override
    public ExecutionConsole createConsole()
    {
        return executionConsole;
    }

    @Override
    protected ProcessHandler doGetProcessHandler()
    {
        return processHandler;
    }

    @Override
    public void startStepInto(@Nullable XSuspendContext context)
    {
        muleDebuggerSession.nextStep();
    }

    @Override
    public void startStepOut(@Nullable XSuspendContext context)
    {
        muleDebuggerSession.nextStep();
    }

    @Override
    public void resume(@Nullable XSuspendContext context)
    {
        muleDebuggerSession.resume();
    }

    @Override
    public void registerAdditionalActions(@NotNull DefaultActionGroup leftToolbar, @NotNull DefaultActionGroup topToolbar, @NotNull DefaultActionGroup settings)
    {
        super.registerAdditionalActions(leftToolbar, topToolbar, settings);
        leftToolbar.add(new ExceptionBreakpointSwitchAction(muleDebuggerSession));
    }

    @Nullable
    @Override
    public XDebuggerEvaluator getEvaluator()
    {
        return new MuleScriptEvaluator(muleDebuggerSession);
    }

    @Override
    public void runToPosition(@NotNull XSourcePosition xSourcePosition, @Nullable XSuspendContext context)
    {
        //muleDebuggerSession.runToCursor(getMulePath(getXmlTagAt(getModule().getProject(), xSourcePosition)));
        muleDebuggerSession.runToCursor(getMulePath(getXmlTagAt(getProject(), xSourcePosition)));
    }

    @Override
    public void stop()
    {
        muleDebuggerSession.disconnect();
    }

    @NotNull
    @Override
    public XBreakpointHandler<?>[] getBreakpointHandlers()
    {
        final XBreakpointHandler<?>[] breakpointHandlers = super.getBreakpointHandlers();
        return ArrayUtil.append(breakpointHandlers, muleBreakpointHandler);
    }

    @NotNull
    @Override
    public XDebuggerEditorsProvider getEditorsProvider()
    {
        return editorProperties;
    }

}
