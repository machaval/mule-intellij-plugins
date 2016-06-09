package org.mule.debugger;


import com.intellij.xdebugger.frame.XExecutionStack;
import com.intellij.xdebugger.frame.XStackFrame;
import com.intellij.xdebugger.frame.XSuspendContext;

public class MuleSuspendContext extends XSuspendContext {

    private MuleExecutionStack muleExecutionStack;

    public MuleSuspendContext(XStackFrame... frame) {
        muleExecutionStack = new MuleExecutionStack("Mule Execution", frame);
    }

    @Override
    public XExecutionStack getActiveExecutionStack() {
        return muleExecutionStack;
    }


}
