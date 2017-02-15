package org.mule.tooling.lang.dw.debug;


import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.frame.XExecutionStack;
import com.intellij.xdebugger.frame.XSuspendContext;
import com.mulesoft.weave.engine.debugger.client.DebuggerClient;
import com.mulesoft.weave.engine.debugger.server.event.OnFrameEvent;

public class WeaveSuspendContext extends XSuspendContext {

  public static final String WEAVE_STACK = "Weave Thread";

  private WeaveExecutionStack weaveExecutionStack;

  public WeaveSuspendContext(DebuggerClient client, OnFrameEvent frame, XDebugSession session, VirtualFile file) {

    weaveExecutionStack = new WeaveExecutionStack(client, frame, WEAVE_STACK, session, file);
  }

  @Override
  public XExecutionStack getActiveExecutionStack() {
    return weaveExecutionStack;
  }

}
