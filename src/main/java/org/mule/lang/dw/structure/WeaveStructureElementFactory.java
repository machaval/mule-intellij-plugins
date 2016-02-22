package org.mule.lang.dw.structure;


import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.dw.parser.psi.*;

public class WeaveStructureElementFactory {

    @Nullable
    public static StructureViewTreeElement create(PsiElement element) {
        if (element instanceof WeaveObjectExpression) {
            return new WeaveObjectView((WeaveObjectExpression) element);
        } else if (element instanceof WeaveArrayExpression) {
            return new WeaveArrayView((WeaveArrayExpression) element);
        } else if (element instanceof WeaveBinaryExpression) {
            return create(((WeaveBinaryExpression) element).getRight());
        } else if (element instanceof WeaveBinaryClojureExpression) {
            return create(((WeaveBinaryClojureExpression) element).getRight());
        } else if (element instanceof WeaveUsingExpression) {
            return create(((WeaveUsingExpression) element).getExpression());
        } else if (element instanceof WeaveUnaryExpression) {
            return create(((WeaveUnaryExpression) element).getExpression());
        } else {
            return null;
        }
    }
}
