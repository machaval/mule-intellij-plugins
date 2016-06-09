package org.mule.lang.dw.debug;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XDebugSession;
import com.mulesoft.weave.engine.debugger.client.DebuggerClient;
import com.mulesoft.weave.engine.debugger.client.DebuggerClientListener;
import com.mulesoft.weave.engine.debugger.server.event.BreakpointAddedEvent;
import com.mulesoft.weave.engine.debugger.server.event.BreakpointRemovedEvent;
import com.mulesoft.weave.engine.debugger.server.event.OnFrameEvent;
import com.mulesoft.weave.engine.debugger.server.event.ScriptResultEvent;

public class WeaveDebuggerClientListener implements DebuggerClientListener
{

    private XDebugSession session;
    private final VirtualFile file;

    public WeaveDebuggerClientListener(XDebugSession session, VirtualFile file)
    {
        this.session = session;
        this.file = file;
    }

    @Override
    public void onFrame(DebuggerClient client, OnFrameEvent frame)
    {
        session.positionReached(new WeaveSuspendContext(client, frame, session, file));
    }


    @Override
    public void onBreakpointAdded(BreakpointAddedEvent bae)
    {

    }

    @Override
    public void onBreakpointCleaned()
    {

    }

    @Override
    public void onBreakpointRemoved(BreakpointRemovedEvent bre)
    {

    }

    @Override
    public void onScriptEvaluated(DebuggerClient client, ScriptResultEvent sr)
    {

    }
}
