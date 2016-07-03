package org.mule.tooling.lang.dw.debug.value;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XValue;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.intellij.xdebugger.frame.XValueNode;
import com.intellij.xdebugger.frame.XValuePlace;
import com.mulesoft.weave.engine.debugger.AttributeDebuggerValue;
import com.mulesoft.weave.engine.debugger.FieldDebuggerValue;
import com.mulesoft.weave.engine.debugger.KeyDebuggerValue;
import org.jetbrains.annotations.NotNull;

public class FieldWeaveValue extends XValue
{

    private FieldDebuggerValue debuggerValue;

    public FieldWeaveValue(FieldDebuggerValue debuggerValue)
    {
        this.debuggerValue = debuggerValue;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace)
    {
        xValueNode.setPresentation(PlatformIcons.VARIABLE_ICON, "", "", true);
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node)
    {
        final XValueChildrenList list = new XValueChildrenList();
        final KeyDebuggerValue key = debuggerValue.key();
        final AttributeDebuggerValue[] attr = key.attr();
        for (AttributeDebuggerValue attributeDebuggerValue : attr)
        {
            list.add("@" + attributeDebuggerValue.name(), WeaveValueFactory.create(attributeDebuggerValue.value()));
        }
        list.add("value", WeaveValueFactory.create(debuggerValue.value()));
        node.addChildren(list, false);
        super.computeChildren(node);
    }
}
