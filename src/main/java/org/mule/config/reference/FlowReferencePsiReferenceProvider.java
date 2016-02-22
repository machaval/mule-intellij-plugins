package org.mule.config.reference;

import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.*;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.mule.config.MuleConfigConstants;

public class FlowReferencePsiReferenceProvider extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(
                XmlPatterns.xmlAttribute(MuleConfigConstants.NAME_ATTRIBUTE)
                        .withParent(XmlPatterns.xmlTag().withLocalName(MuleConfigConstants.FLOW_REF_TAG_NAME)
                ),
                new FlowRefProvider());
    }

    private static class FlowRefProvider extends PsiReferenceProvider {
        @NotNull
        @Override
        public PsiReference[] getReferencesByElement(@NotNull final PsiElement element, @NotNull final ProcessingContext context) {
            if (element instanceof XmlAttribute) {
                return new PsiReference[]{new FlowRefPsiReference(element)};
            }
            return PsiReference.EMPTY_ARRAY;
        }
    }

}


