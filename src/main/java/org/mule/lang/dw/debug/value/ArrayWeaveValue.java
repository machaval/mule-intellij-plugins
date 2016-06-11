package org.mule.lang.dw.debug.value;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.ArrayDebuggerValue;
import com.mulesoft.weave.engine.debugger.DebuggerValue;
import org.jetbrains.annotations.NotNull;

public class ArrayWeaveValue extends XValue
{

    private ArrayDebuggerValue debuggerValue;

    public ArrayWeaveValue(ArrayDebuggerValue debuggerValue)
    {
        this.debuggerValue = debuggerValue;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace)
    {
        xValueNode.setPresentation(PlatformIcons.VARIABLE_ICON, "Array", "length : " + debuggerValue.values().length, true);
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node)
    {
        final XValueChildrenList list = new XValueChildrenList();
        final DebuggerValue[] innerElements = debuggerValue.values();
        int i = 0;
        for (DebuggerValue innerElement : innerElements)
        {
            final XValue value = WeaveValueFactory.create(innerElement);
            if (value != null)
            {
                list.add("[" + i + "]", value);
            }
            i++;
        }
        node.addChildren(list, false);
        super.computeChildren(node);
    }
}
