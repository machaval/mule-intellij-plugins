package org.mule.tooling.lang.dw.parser.psi;


import com.google.common.base.Optional;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WeaveVariablePsiReference extends PsiReferenceBase<PsiElement> {
    private String variableName;

    public WeaveVariablePsiReference(@NotNull WeaveVariableReferenceExpression element, TextRange textRange) {
        super(element, textRange);
        variableName = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        if (variableName.equals("$") || variableName.equals("$$")) {
            return WeavePsiUtils.findImplicitVariable(myElement);
        } else {
            Optional<? extends PsiElement> variables = WeavePsiUtils.findVariables(myElement, variableName);
            if (variables.isPresent()) {
                return variables.get();
            } else {
                return WeavePsiUtils.findFunction(myElement, variableName).orNull();
            }

        }
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        final List<WeaveVariable> variables = WeavePsiUtils.findVariables(myElement);
        final List<LookupElement> variants = new ArrayList<>();
        for (final WeaveVariable property : variables) {
            if (property.getName() != null && property.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(property).
                        withIcon(AllIcons.Nodes.Variable).
                        withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
