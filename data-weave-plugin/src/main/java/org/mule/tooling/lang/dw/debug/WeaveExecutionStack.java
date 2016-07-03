package org.mule.tooling.lang.dw.debug;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.frame.XExecutionStack;
import com.intellij.xdebugger.frame.XStackFrame;
import com.mulesoft.weave.engine.debugger.DebuggerFrame;
import com.mulesoft.weave.engine.debugger.client.DebuggerClient;
import com.mulesoft.weave.engine.debugger.server.event.OnFrameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WeaveExecutionStack extends XExecutionStack
{

    private List<XStackFrame> frames;

    protected WeaveExecutionStack(DebuggerClient client, OnFrameEvent onFrameEvent, String displayName, XDebugSession session, VirtualFile file)
    {
        super(displayName, AllIcons.Debugger.ThreadSuspended);
        final DebuggerFrame[] frames = onFrameEvent.frames();
        this.frames = new ArrayList<>();
        for (int i = 0; i < frames.length; i++)
        {
            final DebuggerFrame debuggerFrame = frames[i];
            if (i == 0)
            {
                this.frames.add(new WeaveStackFrame(client, onFrameEvent.startPosition(), debuggerFrame, file));
            }
            else
            {
                this.frames.add(new WeaveStackFrame(client, frames[i - 1].startPosition(), debuggerFrame, file));
            }
        }
    }


    @Nullable
    @Override
    public XStackFrame getTopFrame()
    {
        return frames.get(0);
    }

    @Override
    public void computeStackFrames(int firstFrameIndex, XStackFrameContainer container)
    {
        if (firstFrameIndex <= frames.size())
        {
            container.addStackFrames(frames.subList(firstFrameIndex, frames.size()), true);
        }
        else
        {
            container.addStackFrames(Collections.<XStackFrame>emptyList(), true);
        }
    }
}
