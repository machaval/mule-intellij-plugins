package org.mule.lang.dw.debug.value;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.SimpleDebuggerValue;
import org.jetbrains.annotations.NotNull;

public class SimpleWeaveValue extends XValue
{

    private SimpleDebuggerValue debuggerValue;

    public SimpleWeaveValue(SimpleDebuggerValue debuggerValue)
    {
        this.debuggerValue = debuggerValue;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace)
    {
        xValueNode.setPresentation(PlatformIcons.FUNCTION_ICON, debuggerValue.typeName(), debuggerValue.value(), false);
    }

}
