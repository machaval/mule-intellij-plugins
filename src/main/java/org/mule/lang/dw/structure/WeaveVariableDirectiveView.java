package org.mule.lang.dw.structure;


import com.intellij.icons.AllIcons;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.dw.parser.psi.WeaveVariableDirective;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

public class WeaveVariableDirectiveView extends PsiTreeElementBase<WeaveVariableDirective> {
    protected WeaveVariableDirectiveView(WeaveVariableDirective psiElement) {
        super(psiElement);
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        return Arrays.asList();
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return getElement().getVariableDefinition().getName();
    }

    @Override
    public Icon getIcon(boolean open) {
        return AllIcons.Nodes.Variable;
    }
}
