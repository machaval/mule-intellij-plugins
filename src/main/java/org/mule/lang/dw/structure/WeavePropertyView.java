package org.mule.lang.dw.structure;


import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.dw.parser.psi.WeaveExpression;
import org.mule.lang.dw.parser.psi.WeaveSimpleKeyValuePair;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeavePropertyView extends PsiTreeElementBase<WeaveSimpleKeyValuePair> {
    protected WeavePropertyView(WeaveSimpleKeyValuePair psiElement) {
        super(psiElement);
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        final List<StructureViewTreeElement> result = new ArrayList<>();
        final WeaveExpression expression = getElement().getExpression();
        final StructureViewTreeElement treeElement = WeaveStructureElementFactory.create(expression);
        if (treeElement != null) {
            result.add(treeElement);
        }else{
            //
        }
        return result;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return getElement().getPresentation().getPresentableText();
    }

    @Override
    public Icon getIcon(boolean open) {
        return getElement().getPresentation().getIcon(open);
    }
}
