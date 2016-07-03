package org.mule.tooling.esb.config.reference;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class FlowConstructReferenceContributor extends PsiReferenceContributor {

    private static List<String> FLOW_REF_METHOD_NAMES = Arrays.asList("flowRunner", "getFlowConstruct");

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
                        final PsiElement parent = literalExpression.getParent();
                        final PsiElement granParent = parent.getParent();
                        if (granParent instanceof PsiMethodCallExpression) {
                            final PsiReferenceExpression methodExpression = ((PsiMethodCallExpression) granParent).getMethodExpression();
                            if (FLOW_REF_METHOD_NAMES.contains(methodExpression.getReferenceName())) {
                                return new PsiReference[]{new StringLiteralPsiReference(literalExpression)};
                            }
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }
}
