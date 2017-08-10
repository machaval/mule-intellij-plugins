package org.mule.tooling.esb.debugger.breakpoint;


import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.breakpoints.XBreakpointProperties;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;
import com.mulesoft.mule.debugger.commons.Breakpoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.debugger.session.MuleDebuggerSession;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.util.Map;

public class MuleBreakpointHandler extends XBreakpointHandler<XLineBreakpoint<XBreakpointProperties>>
{

    private Map<String, String> modulesToAppsMap;
    private MuleDebuggerSession debuggerManager;

    public MuleBreakpointHandler(MuleDebuggerSession debuggerManager, @Nullable Map<String, String>modulesToAppsMap)
    {
        super(MuleBreakpointType.class);
        this.modulesToAppsMap = modulesToAppsMap;
        this.debuggerManager = debuggerManager;
    }

    @Override
    public void registerBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> xBreakpoint)
    {
        //TODO Here get map from the debuggerManager and pass to the toMuleBreakpoint
        final Breakpoint breakpoint = MuleConfigUtils.toMuleBreakpoint(debuggerManager.getProject(), xBreakpoint, modulesToAppsMap);
        System.out.println("breakpoint added = " + breakpoint.getApplicationName() + "  , path  " + breakpoint.getPath());
        debuggerManager.addBreakpoint(breakpoint);
    }

    @Override
    public void unregisterBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> xBreakpoint, boolean temporary)
    {
        final Breakpoint breakpoint = MuleConfigUtils.toMuleBreakpoint(debuggerManager.getProject(), xBreakpoint, modulesToAppsMap);
        System.out.println("breakpoint removed = " + breakpoint.getApplicationName() + "  , path  " + breakpoint.getPath());
        debuggerManager.removeBreakpoint(breakpoint);
    }
}
