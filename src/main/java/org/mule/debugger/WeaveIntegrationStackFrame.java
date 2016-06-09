package org.mule.debugger;


import com.intellij.openapi.project.Project;
import com.intellij.psi.xml.XmlTag;
import com.intellij.ui.ColoredTextContainer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XStackFrame;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleConfigUtils;

import java.util.List;

public class WeaveIntegrationStackFrame extends XStackFrame
{
    private final XSourcePosition position;
    private List<ObjectFieldDefinition> frame;
    private Project project;
    private MuleDebuggerSession session;


    public WeaveIntegrationStackFrame(Project project, MuleDebuggerSession session, String path, String internalPosition, @Nullable List<ObjectFieldDefinition> frame)
    {

        this.project = project;
        this.session = session;
        this.frame = frame;
        final XmlTag tag = MuleConfigUtils.getTagAt(project, path);
        this.position = MuleConfigUtils.createPositionByElement(tag);
    }

    @Nullable
    @Override
    public XSourcePosition getSourcePosition()
    {
        return position;
    }

    public void customizePresentation(@NotNull ColoredTextContainer component)
    {
        component.append("Data Weave", SimpleTextAttributes.REGULAR_ATTRIBUTES);
    }

    @Nullable
    @Override
    public XDebuggerEvaluator getEvaluator()
    {
        return new MuleScriptEvaluator(session);
    }

    @Override
    public Object getEqualityObject()
    {
        return WeaveIntegrationStackFrame.class;
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node)
    {
        final XValueChildrenList children = new XValueChildrenList();
        for (ObjectFieldDefinition objectFieldDefinition : frame)
        {
            children.add(objectFieldDefinition.getName(), new ObjectFieldDefinitionValue(session, objectFieldDefinition, PlatformIcons.PROPERTY_ICON));
        }
        node.addChildren(children, true);
    }

}

