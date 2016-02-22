package org.mule.lang.dw.structure;


import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.dw.parser.psi.WeaveArrayElement;
import org.mule.lang.dw.parser.psi.WeaveArrayExpression;
import org.mule.lang.dw.parser.psi.WeaveExpression;
import org.mule.lang.dw.parser.psi.WeaveSimpleArrayElement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeaveArrayView extends PsiTreeElementBase<WeaveArrayExpression> {
    protected WeaveArrayView(WeaveArrayExpression psiElement) {
        super(psiElement);
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        List<StructureViewTreeElement> result = new ArrayList<>();
        final List<WeaveArrayElement> arrayElementList = getElement().getArrayElementList();
        for (WeaveArrayElement weaveArrayElement : arrayElementList) {
            final WeaveSimpleArrayElement simpleArrayElement = weaveArrayElement.getSimpleArrayElement();
            if (simpleArrayElement != null) {
                final WeaveExpression expression = simpleArrayElement.getExpression();
                final StructureViewTreeElement structureViewTreeElement = WeaveStructureElementFactory.create(expression);
                if (structureViewTreeElement != null) {
                    result.add(structureViewTreeElement);
                }
            }
        }
        return result;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return "";
    }

    @Override
    public Icon getIcon(boolean open) {
        return getElement().getPresentation().getIcon(open);
    }
}
