package org.mule.tooling.esb.debugger;

import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.*;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.debugger.session.MuleDebuggerSession;

import javax.swing.*;
import java.util.Map;


public class MapOfObjectFieldDefinitionValue extends XValue {

    private MuleDebuggerSession session;
    private Map<String, ObjectFieldDefinition> values;
    private Icon icon;

    public MapOfObjectFieldDefinitionValue(MuleDebuggerSession session, Map<String, ObjectFieldDefinition> values, Icon icon) {
        this.session = session;
        this.values = values;
        this.icon = icon;
    }

    @Override
    public void computePresentation(@NotNull XValueNode xValueNode, @NotNull XValuePlace xValuePlace) {
        xValueNode.setPresentation(icon, "", "", !values.isEmpty());
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node) {
        final XValueChildrenList list = new XValueChildrenList();
        for (Map.Entry<String, ObjectFieldDefinition> entry : values.entrySet()) {
            list.add(entry.getKey(), new ObjectFieldDefinitionValue(session, entry.getValue(), PlatformIcons.PROPERTY_ICON));
        }
        node.addChildren(list, false);
        super.computeChildren(node);
    }
}
