package org.mule.tooling.lang.dw.debug;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XDebugSession;
import com.mulesoft.weave.debugger.client.DebuggerClient;
import com.mulesoft.weave.debugger.client.DebuggerClientListener;
import com.mulesoft.weave.debugger.event.BreakpointAddedEvent;
import com.mulesoft.weave.debugger.event.BreakpointRemovedEvent;
import com.mulesoft.weave.debugger.event.OnFrameEvent;
import com.mulesoft.weave.debugger.event.ScriptResultEvent;

public class WeaveDebuggerClientListener implements DebuggerClientListener {

  private XDebugSession session;
  private final VirtualFile file;

  public WeaveDebuggerClientListener(XDebugSession session, VirtualFile file) {
    this.session = session;
    this.file = file;
  }

  @Override
  public void onFrame(DebuggerClient client, OnFrameEvent frame) {
    session.positionReached(new WeaveSuspendContext(client, frame, session, file));
  }


  @Override
  public void onBreakpointAdded(BreakpointAddedEvent bae) {

  }

  @Override
  public void onBreakpointCleaned() {

  }

  @Override
  public void onBreakpointRemoved(BreakpointRemovedEvent bre) {

  }

  @Override
  public void onScriptEvaluated(DebuggerClient client, ScriptResultEvent sr) {

  }
}
