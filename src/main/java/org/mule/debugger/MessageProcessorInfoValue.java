package org.mule.debugger;

import com.intellij.icons.AllIcons;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.xdebugger.frame.*;
import com.mulesoft.mule.debugger.response.MessageProcessorInfo;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.jetbrains.annotations.NotNull;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleConfigUtils;

import java.util.List;


public class MessageProcessorInfoValue extends XValue {

    private MessageProcessorInfo messageProcessorInfo;
    private MuleDebuggerSession session;

    public MessageProcessorInfoValue(@NotNull MuleDebuggerSession session, @NotNull MessageProcessorInfo messageProcessorInfo) {
        this.session = session;
        this.messageProcessorInfo = messageProcessorInfo;
    }

    @Override
    public void computePresentation(@NotNull XValueNode node, @NotNull XValuePlace xValuePlace) {
        node.setPresentation(AllIcons.Debugger.Value, messageProcessorInfo.getClassName(), messageProcessorInfo.getPath(), messageProcessorInfo.getFields() != null);
    }

    @Override
    public boolean canNavigateToTypeSource() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return true;
    }

    @Override
    public void computeSourcePosition(@NotNull XNavigatable navigatable) {
        PsiClass aClass = JavaPsiFacade.getInstance(session.getProject()).findClass(messageProcessorInfo.getClassName(), GlobalSearchScope.allScope(session.getProject()));
        if (aClass != null) {
            navigatable.setSourcePosition(MuleConfigUtils.createPositionByElement(aClass));
        }
    }


    @Override
    public void computeChildren(@NotNull XCompositeNode node) {
        final XValueChildrenList list = new XValueChildrenList();
        final List<ObjectFieldDefinition> field = messageProcessorInfo.getFields();
        if (field != null) {
            for (int i = 0; i < field.size(); i++) {
                ObjectFieldDefinition objectFieldDefinition = field.get(i);
                list.add(objectFieldDefinition.getName(), new ObjectFieldDefinitionValue(session, objectFieldDefinition, AllIcons.Debugger.Value));
            }
        }
        node.addChildren(list, false);
        super.computeChildren(node);
    }
}
