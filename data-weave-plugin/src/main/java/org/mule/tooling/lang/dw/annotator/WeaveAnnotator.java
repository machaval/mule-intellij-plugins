package org.mule.tooling.lang.dw.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.dw.highlighter.WeaveSyntaxHighlighter;
import org.mule.tooling.lang.dw.parser.psi.*;


public class WeaveAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof WeaveKeyExpression) {
            holder.createInfoAnnotation(element, "Property key").setTextAttributes(WeaveSyntaxHighlighter.KEY);
        }
        if (element instanceof WeaveIdentifier && element.getParent() instanceof WeaveFunctionDefinition) {
            holder.createInfoAnnotation(element, "Function").setTextAttributes(WeaveSyntaxHighlighter.FUNCTION_DECLARATION);
        }
        if (element instanceof WeaveIdentifier && element.getParent() instanceof WeaveVariableDefinition) {
            holder.createInfoAnnotation(element, "Variable").setTextAttributes(WeaveSyntaxHighlighter.VARIABLE);
        }
        if (element instanceof WeaveIdentifier && element.getParent() instanceof WeaveFunctionCallExpression) {
            holder.createInfoAnnotation(element, "Function call").setTextAttributes(WeaveSyntaxHighlighter.FUNCTION_CALL);
        }
    }
}
