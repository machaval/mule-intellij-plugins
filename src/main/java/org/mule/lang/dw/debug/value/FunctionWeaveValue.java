package org.mule.lang.dw.debug.value;

import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.DebuggerFunction;
import com.mulesoft.weave.engine.debugger.FieldDebuggerValue;
import com.mulesoft.weave.engine.debugger.ObjectDebuggerValue;
import org.jetbrains.annotations.NotNull;

public class FunctionWeaveValue extends XValue
{

    private DebuggerFunction debuggerValue;

    public FunctionWeaveValue(DebuggerFunction debuggerValue)
    {
        this.debuggerValue = debuggerValue;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace)
    {
        xValueNode.setPresentation(PlatformIcons.FUNCTION_ICON, "Function", StringUtil.join(debuggerValue.parameters(), ","), false);
    }

}
