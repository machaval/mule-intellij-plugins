package org.mule.tooling.lang.dw.parser.psi;


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

public class WeaveFunctionPsiReference extends PsiReferenceBase<PsiElement> {
    private String variableName;

    public WeaveFunctionPsiReference(@NotNull WeaveFunctionCallExpression element, TextRange textRange) {
        super(element, textRange);
        variableName = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return WeavePsiUtils.findFunction(myElement, variableName);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        final List<WeaveNamedElement> variables = WeavePsiUtils.findFunctions(myElement);
        final List<LookupElement> variants = new ArrayList<>();
        for (final WeaveNamedElement property : variables) {
            if (property.getName() != null && property.getName().length() > 0) {
                variants.add(LookupElementBuilder.create(property).
                        withIcon(AllIcons.Nodes.Function).
                        withTypeText(property.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }


}
