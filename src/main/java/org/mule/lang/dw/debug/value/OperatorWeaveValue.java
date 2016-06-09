package org.mule.lang.dw.debug.value;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.DebuggerFunction;
import com.mulesoft.weave.engine.debugger.OperatorDebuggerValue;
import org.jetbrains.annotations.NotNull;

public class OperatorWeaveValue extends XValue
{

    private OperatorDebuggerValue debuggerValue;

    public OperatorWeaveValue(OperatorDebuggerValue debuggerValue)
    {
        this.debuggerValue = debuggerValue;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace)
    {
        xValueNode.setPresentation(PlatformIcons.FUNCTION_ICON, debuggerValue.name(), StringUtil.join(debuggerValue.types(), ","), false);
    }

}
