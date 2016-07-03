package org.mule.tooling.lang.dw.structure;


import com.intellij.icons.AllIcons;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.parser.psi.WeaveFunctionDirective;
import org.mule.tooling.lang.dw.parser.psi.WeaveVariableDirective;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

public class WeaveFunctionDirectiveView extends PsiTreeElementBase<WeaveFunctionDirective> {
    protected WeaveFunctionDirectiveView(WeaveFunctionDirective psiElement) {
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
        return getElement().getFunctionDefinition().getName();
    }

    @Override
    public Icon getIcon(boolean open) {
        return AllIcons.Nodes.Function;
    }
}
