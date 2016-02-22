package org.mule.debugger;

import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.PlatformIcons;
import com.intellij.xdebugger.frame.*;
import com.mulesoft.mule.debugger.response.ObjectFieldDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.debugger.session.MuleDebuggerSession;
import org.mule.util.MuleSupport;

import javax.swing.*;
import java.util.List;


public class ObjectFieldDefinitionValue extends XValue {
    private MuleDebuggerSession session;
    private ObjectFieldDefinition fieldDefinition;
    private Icon icon;

    public ObjectFieldDefinitionValue(MuleDebuggerSession session, ObjectFieldDefinition fieldDefinition, Icon icon) {
        this.session = session;
        this.fieldDefinition = fieldDefinition;
        this.icon = icon;
    }

    @Override
    public void computePresentation(@NotNull XValueNode node, @NotNull XValuePlace xValuePlace) {
        final List<ObjectFieldDefinition> innerElements = fieldDefinition.getInnerElements();
        node.setPresentation(icon, fieldDefinition.getClassName(), "'" + String.valueOf(fieldDefinition.getValue()) + "'", !innerElements.isEmpty() || fieldDefinition.isHasUnloadedChildren());
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
        PsiClass aClass = JavaPsiFacade.getInstance(session.getProject()).findClass(fieldDefinition.getClassName(), GlobalSearchScope.allScope(session.getProject()));
        if (aClass != null) {
            navigatable.setSourcePosition(MuleSupport.createPositionByElement(aClass));
        }
    }

    @Override
    public void computeChildren(@NotNull XCompositeNode node) {
        final XValueChildrenList list = new XValueChildrenList();
        if (fieldDefinition.isHasUnloadedChildren()) {
            final List<ObjectFieldDefinition> innerElements = session.loadInnerFields(fieldDefinition);
            for (ObjectFieldDefinition innerElement : innerElements) {
                list.add(innerElement.getName(), new ObjectFieldDefinitionValue(session, innerElement, PlatformIcons.FIELD_ICON));
            }
        } else {
            final List<ObjectFieldDefinition> innerElements = fieldDefinition.getInnerElements();
            for (ObjectFieldDefinition innerElement : innerElements) {
                list.add(innerElement.getName(), new ObjectFieldDefinitionValue(session, innerElement, PlatformIcons.FIELD_ICON));
            }
        }
        node.addChildren(list, false);
        super.computeChildren(node);
    }
}
