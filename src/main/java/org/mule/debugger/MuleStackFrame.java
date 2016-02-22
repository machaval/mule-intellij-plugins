package org.mule.debugger;


import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.psi.xml.XmlTag;
import com.intellij.ui.ColoredTextContainer;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.XDebuggerEvaluator;
import com.intellij.xdebugger.frame.XCompositeNode;
import com.intellij.xdebugger.frame.XStackFrame;
import com.intellij.xdebugger.frame.XValueChildrenList;
import com.mulesoft.mule.debugger.response.MuleMessageInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleSupport;

public class MuleStackFrame extends XStackFrame {
    private final XSourcePosition position;
    private MuleDebuggerSession session;
    private MuleMessageInfo muleMessageInfo;
    @Nullable
    private ObjectFieldDefinition exceptionThrown;
    private final XmlTag tag;

    public MuleStackFrame(@NotNull Project project, @NotNull MuleDebuggerSession session, MuleMessageInfo muleMessageInfo) {
        this(project, session, muleMessageInfo, null);
    }

    public MuleStackFrame(@NotNull Project project, MuleDebuggerSession session, MuleMessageInfo muleMessageInfo, @Nullable ObjectFieldDefinition exceptionThrown) {
        super();
        this.session = session;
        this.muleMessageInfo = muleMessageInfo;
        this.exceptionThrown = exceptionThrown;
        this.tag = MuleSupport.getTagAt(project, muleMessageInfo.getMessageProcessorInfo().getPath());
        this.position = MuleSupport.createPositionByElement(tag);
    }

    @Nullable
    @Override
    public XSourcePosition getSourcePosition() {
        return position;
    }

    public void customizePresentation(@NotNull ColoredTextContainer component) {
        final String mp = StringUtils.isNotBlank(tag.getNamespacePrefix()) ? tag.getNamespacePrefix() + ":" + tag.getLocalName() : tag.getLocalName();
        component.append(mp, SimpleTextAttributes.REGULAR_ATTRIBUTES);
    }

    @Nullable
    @Override
    public XDebuggerEvaluator getEvaluator() {
        return new MuleScriptEvaluator(session);
    }

    @Override
    public Object getEqualityObject() {
        return MuleStackFrame.class;
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node) {
        final XValueChildrenList children = new XValueChildrenList();
        children.add("Message Processor", new MessageProcessorInfoValue(this.session, this.muleMessageInfo.getMessageProcessorInfo()));
        children.add("Payload", new ObjectFieldDefinitionValue(this.session, this.muleMessageInfo.getPayloadDefinition(), AllIcons.Debugger.Value));
        if (exceptionThrown != null) {
            children.add("Exception", new ObjectFieldDefinitionValue(this.session, exceptionThrown, AllIcons.General.Error));
        }
        children.add("Flow Vars", new MapOfObjectFieldDefinitionValue(this.session, this.muleMessageInfo.getInvocationProperties(), AllIcons.Nodes.Parameter));
        children.add("Session Properties", new MapOfObjectFieldDefinitionValue(this.session, this.muleMessageInfo.getSessionProperties(), AllIcons.Nodes.Parameter));
        children.add("Inbound Properties", new MapOfObjectFieldDefinitionValue(this.session, this.muleMessageInfo.getInboundProperties(), AllIcons.Nodes.Parameter));
        children.add("OutboundProperties", new MapOfObjectFieldDefinitionValue(this.session, this.muleMessageInfo.getOutboundProperties(), AllIcons.Nodes.Parameter));
        node.addChildren(children, true);
    }

}

