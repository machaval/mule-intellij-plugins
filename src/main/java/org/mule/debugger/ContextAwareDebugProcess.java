package org.mule.debugger;

import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ExecutionConsole;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.evaluation.XDebuggerEditorsProvider;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.intellij.xdebugger.frame.XValueMarkerProvider;
import com.intellij.xdebugger.stepping.XSmartStepIntoHandler;
import com.intellij.xdebugger.ui.XDebugTabLayouter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.concurrency.Promise;

import javax.swing.event.HyperlinkListener;
import java.util.*;

public class ContextAwareDebugProcess extends XDebugProcess {
    private ProcessHandler processHandler;
    private Map<String, XDebugProcess> debugProcesses;
    private String currentContext;
    private String defaultContext;

    public ContextAwareDebugProcess(@NotNull XDebugSession session, ProcessHandler processHandler, Map<String, XDebugProcess> debugProcesses, String defaultContext) {
        super(session);
        this.processHandler = processHandler;
        this.debugProcesses = debugProcesses;
        this.currentContext = defaultContext;
        this.defaultContext = defaultContext;
    }


    public void setContext(String context) {
        this.currentContext = context;
    }

    @Override
    @NotNull
    public XBreakpointHandler<?>[] getBreakpointHandlers() {
        List<XBreakpointHandler> breakpointHandlers = new ArrayList<>();
        final Collection<XDebugProcess> values = debugProcesses.values();
        for (XDebugProcess value : values) {
            breakpointHandlers.addAll(Arrays.asList(value.getBreakpointHandlers()));
        }
        return breakpointHandlers.toArray(new XBreakpointHandler[breakpointHandlers.size()]);
    }

    @Override
    @NotNull
    public XDebuggerEditorsProvider getEditorsProvider() {
        return getDebugProcesses().getEditorsProvider();
    }

    @Override
    public void sessionInitialized() {
        getDebugProcesses().sessionInitialized();
    }

    @Override
    public void startPausing() {
        getDefaultDebugProcesses().startPausing();
    }

    @Override
    public void startStepOver() {
        getDebugProcesses().startStepOver();
    }

    @Override
    public void startForceStepInto() {
        getDebugProcesses().startForceStepInto();
    }

    @Override
    public void startStepInto() {
        getDebugProcesses().startStepInto();
    }

    @Override
    public void startStepOut() {
        getDebugProcesses().startStepOut();
    }

    @Override
    @Nullable
    public XSmartStepIntoHandler<?> getSmartStepIntoHandler() {
        return getDebugProcesses().getSmartStepIntoHandler();
    }

    @Override
    public void stop() {
        final Collection<XDebugProcess> values = debugProcesses.values();
        for (XDebugProcess value : values) {
            value.stop();
        }
    }

    @Override
    @NotNull
    public Promise stopAsync() {
        final Collection<XDebugProcess> values = debugProcesses.values();
        for (XDebugProcess value : values) {
            value.stopAsync();
        }
        return getDefaultDebugProcesses().stopAsync();
    }

    @Override
    public void resume() {
        getDebugProcesses().resume();
    }

    @Override
    public void runToPosition(@NotNull XSourcePosition xSourcePosition) {
        getDebugProcesses().runToPosition(xSourcePosition);
    }

    @Override
    public boolean checkCanPerformCommands() {
        return getDebugProcesses().checkCanPerformCommands();
    }

    @Override
    public boolean checkCanInitBreakpoints() {
        return getDebugProcesses().checkCanInitBreakpoints();
    }

    @Override
    @Nullable
    public ProcessHandler doGetProcessHandler() {
        return processHandler;
    }

    @Override
    @NotNull
    public ExecutionConsole createConsole() {
        return getDefaultDebugProcesses().createConsole();
    }

    @Override
    @Nullable
    public XValueMarkerProvider<?, ?> createValueMarkerProvider() {
        return getDefaultDebugProcesses().createValueMarkerProvider();
    }

    @Override
    public void registerAdditionalActions(@NotNull DefaultActionGroup leftToolbar, @NotNull DefaultActionGroup topToolbar, @NotNull DefaultActionGroup settings) {
        final Collection<XDebugProcess> values = debugProcesses.values();
        for (XDebugProcess value : values) {
            value.registerAdditionalActions(leftToolbar, topToolbar, settings);
        }
    }

    @Override
    public String getCurrentStateMessage() {
        return getDebugProcesses().getCurrentStateMessage();
    }

    @Override
    @Nullable
    public HyperlinkListener getCurrentStateHyperlinkListener() {
        return getDebugProcesses().getCurrentStateHyperlinkListener();
    }

    @Override
    @NotNull
    public XDebugTabLayouter createTabLayouter() {
        return getDefaultDebugProcesses().createTabLayouter();
    }

    @Override
    public boolean isValuesCustomSorted() {
        return getDebugProcesses().isValuesCustomSorted();
    }

    @Override
    @Nullable
    public XDebuggerEvaluator getEvaluator() {
        return getDebugProcesses().getEvaluator();
    }

    public XDebugProcess getDefaultDebugProcesses() {
        return debugProcesses.get(defaultContext);
    }

    public XDebugProcess getDebugProcesses() {
        final XDebugProcess debugProcess = currentContext != null ? debugProcesses.get(currentContext) : null;
        return debugProcess != null ? debugProcess : getDefaultDebugProcesses();
    }

}
