package org.mule.debugger.breakpoint;


import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.breakpoints.XBreakpointProperties;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;
import com.mulesoft.mule.debugger.commons.Breakpoint;
import org.jetbrains.annotations.NotNull;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleConfigUtils;

public class MuleBreakpointHandler extends XBreakpointHandler<XLineBreakpoint<XBreakpointProperties>>
{

    final static Logger logger = Logger.getInstance(MuleBreakpointHandler.class);

    private Module module;
    private MuleDebuggerSession debuggerManager;

    public MuleBreakpointHandler(@NotNull Module module, MuleDebuggerSession debuggerManager)
    {
        super(MuleBreakpointType.class);
        this.module = module;
        this.debuggerManager = debuggerManager;
    }

    @Override
    public void registerBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> xBreakpoint)
    {
        final Breakpoint breakpoint = MuleConfigUtils.toMuleBreakpoint(module, xBreakpoint);
        logger.debug("breakpoint added = " + breakpoint.getApplicationName() + "  , path  " + breakpoint.getPath());
        debuggerManager.addBreakpoint(breakpoint);
    }

    @Override
    public void unregisterBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> xBreakpoint, boolean temporary)
    {
        final Breakpoint breakpoint = MuleConfigUtils.toMuleBreakpoint(module, xBreakpoint);
        logger.debug("breakpoint removed = " + breakpoint.getApplicationName() + "  , path  " + breakpoint.getPath());
        debuggerManager.removeBreakpoint(breakpoint);
    }
}
