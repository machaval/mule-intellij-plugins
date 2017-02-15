package org.mule.tooling.lang.dw.debug.breakpoint;

import com.intellij.xdebugger.XExpression;
import com.intellij.xdebugger.breakpoints.XBreakpointHandler;
import com.intellij.xdebugger.breakpoints.XBreakpointProperties;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;
import com.mulesoft.weave.engine.debugger.WeaveBreakpoint;
import com.mulesoft.weave.engine.debugger.client.DebuggerClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WeaveBreakpointHandler extends XBreakpointHandler<XLineBreakpoint<XBreakpointProperties>> {
  private final DebuggerClient debuggerClient;

  public WeaveBreakpointHandler(DebuggerClient debuggerClient) {
    super(WeaveBreakpointType.class);
    this.debuggerClient = debuggerClient;
  }

  @Override
  public void registerBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> lineBreakpoint) {
    debuggerClient.addBreakpoint(toWeaveBreakpoint(lineBreakpoint));
  }

  @NotNull
  private WeaveBreakpoint toWeaveBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> lineBreakpoint) {
    return new WeaveBreakpoint(lineBreakpoint.getLine() + 1, -1, getExpression(lineBreakpoint));
  }

  @Nullable
  private String getExpression(@NotNull XLineBreakpoint<XBreakpointProperties> lineBreakpoint) {
    final XExpression conditionExpression = lineBreakpoint.getConditionExpression();
    return conditionExpression != null ? conditionExpression.getExpression() : null;
  }

  @Override
  public void unregisterBreakpoint(@NotNull XLineBreakpoint<XBreakpointProperties> lineBreakpoint, boolean temporary) {
    debuggerClient.removeBreakpoint(toWeaveBreakpoint(lineBreakpoint));
  }
}
