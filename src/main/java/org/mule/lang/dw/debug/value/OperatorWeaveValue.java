package org.mule.lang.dw.debug.value;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XNamedValue;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.DebuggerValue;
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
        xValueNode.setPresentation(PlatformIcons.FUNCTION_ICON, null, debuggerValue.name(), true);
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node)
    {
        final XValueChildrenList list = new XValueChildrenList();
        final DebuggerValue[] innerElements = debuggerValue.params();
        for (int i = 0; i < innerElements.length; i++)
        {
            DebuggerValue innerElement = innerElements[i];
            list.add("Param[" + i + "]", WeaveValueFactory.create(innerElement));
        }
        node.addChildren(list, false);
        super.computeChildren(node);
    }

}
