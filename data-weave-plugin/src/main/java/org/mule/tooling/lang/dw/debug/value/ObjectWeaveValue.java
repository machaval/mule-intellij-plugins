package org.mule.tooling.lang.dw.debug.value;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.FieldDebuggerValue;
import com.mulesoft.weave.engine.debugger.ObjectDebuggerValue;
import org.jetbrains.annotations.NotNull;

public class ObjectWeaveValue extends XValue
{

    private ObjectDebuggerValue debuggerValue;

    public ObjectWeaveValue(ObjectDebuggerValue debuggerValue)
    {
        this.debuggerValue = debuggerValue;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace)
    {
        xValueNode.setPresentation(PlatformIcons.VARIABLE_ICON, "Object", "length " + debuggerValue.fields().length + "'", true);
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node)
    {
        final XValueChildrenList list = new XValueChildrenList();
        final FieldDebuggerValue[] innerElements = debuggerValue.fields();
        for (FieldDebuggerValue innerElement : innerElements)
        {
            final XValue value = innerElement.key().attr().length > 0 ? WeaveValueFactory.create(innerElement) : WeaveValueFactory.create(innerElement.value());
            if (value != null)
            {
                list.add(innerElement.key().name(), value);
            }
        }
        node.addChildren(list, false);
        super.computeChildren(node);
    }
}
