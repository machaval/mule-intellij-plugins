package org.mule.debugger;

import com.intellij.icons.AllIcons;
import com.intellij.xdebugger.frame.XExecutionStack;
import com.intellij.xdebugger.frame.XStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MuleExecutionStack extends XExecutionStack {

    private XStackFrame frame;

    protected MuleExecutionStack(XStackFrame frame, @NotNull String displayName) {
        super(displayName, AllIcons.Debugger.ThreadSuspended);
        this.frame = frame;
    }

    @Nullable
    @Override
    public XStackFrame getTopFrame() {
        return frame;
    }

    @Override
    public void computeStackFrames(int firstFrameIndex, XStackFrameContainer container) {
        final List<XStackFrame> frames = new ArrayList<XStackFrame>();
        frames.add(frame);
        if (firstFrameIndex <= frames.size()) {
            container.addStackFrames(frames.subList(firstFrameIndex, frames.size()), true);
        } else {
            container.addStackFrames(Collections.<XStackFrame>emptyList(), true);
        }
    }
}
