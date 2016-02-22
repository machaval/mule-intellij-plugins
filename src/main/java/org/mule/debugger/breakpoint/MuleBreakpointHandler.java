package org.mule.debugger.breakpoint;


import com.intellij.openapi.project.Project;
import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.breakpoints.XBreakpointProperties;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;
import com.mulesoft.mule.debugger.commons.Breakpoint;
import org.jetbrains.annotations.NotNull;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleSupport;

public class MuleBreakpointHandler extends XBreakpointHandler<XLineBreakpoint<XBreakpointProperties>> {

    private Project project;
    private MuleDebuggerSession debuggerManager;

    public MuleBreakpointHandler(@NotNull Project project, MuleDebuggerSession debuggerManager) {
        super(MuleBreakpointType.class);
        this.project = project;
        this.debuggerManager = debuggerManager;
    }

    @Override
    public void registerBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> xBreakpoint) {
        final Breakpoint breakpoint = MuleSupport.toMuleBreakpoint(project, xBreakpoint);
        debuggerManager.addBreakpoint(breakpoint);
    }

    @Override
    public void unregisterBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> xBreakpoint, boolean temporary) {
        final Breakpoint breakpoint = MuleSupport.toMuleBreakpoint(project, xBreakpoint);
        debuggerManager.removeBreakpoint(breakpoint);
    }
}
