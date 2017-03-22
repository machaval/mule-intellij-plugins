package org.mule.tooling.esb.config.reference;

import com.intellij.patterns.XmlPatterns;
import com.intellij.psi.*;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.config.MuleConfigConstants;

public class MuleConfigurationReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(
                XmlPatterns.xmlAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE)
                        .withAncestor(2, XmlPatterns.xmlTag().withLocalName(MuleConfigConstants.FLOW_REF_TAG_NAME)
                        ),
                new FlowRefProvider());

//        registrar.registerReferenceProvider(
//                XmlPatterns.xmlAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE)
//                        .withAncestor(2, XmlPatterns.xmlTag().withLocalName(MuleConfigConstants.FLOW_TAG_NAME)
//                        ),
//                new FlowProvider());

        registrar.registerReferenceProvider(
                XmlPatterns.xmlAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE)
                        .withAncestor(2, XmlPatterns.xmlTag().withLocalName(MuleConfigConstants.FLOW_TAG_NAME)
                        ),
                new FlowRefProvider());
        registrar.registerReferenceProvider(
                XmlPatterns.xmlAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE)
                        .withAncestor(2, XmlPatterns.xmlTag().withLocalName(MuleConfigConstants.SUB_FLOW_TAG_NAME)
                        ),
                new FlowRefProvider());

        registrar.registerReferenceProvider(
                XmlPatterns.xmlAttributeValue(MuleConfigConstants.CONFIG_REF_ATTRIBUTE),
                new ConfigRefProvider());
    }

    private static class FlowRefProvider extends PsiReferenceProvider {
        @NotNull
        @Override
        public PsiReference[] getReferencesByElement(@NotNull final PsiElement element, @NotNull final ProcessingContext context) {
            if (element instanceof XmlAttributeValue && !isMelExpression((XmlAttributeValue) element)) {
                final XmlAttributeValue attribute = (XmlAttributeValue) element;
                return new PsiReference[]{new FlowRefPsiReference(attribute)};
            }
            return PsiReference.EMPTY_ARRAY;
        }

        private boolean isMelExpression(@NotNull XmlAttributeValue element) {
            String value = element.getValue().trim();
            return value.startsWith("#[") && value.endsWith("]");
        }
    }

//    private static class FlowProvider extends PsiReferenceProvider {
//        @NotNull
//        @Override
//        public PsiReference[] getReferencesByElement(@NotNull final PsiElement element, @NotNull final ProcessingContext context) {
//            if (element instanceof XmlAttributeValue && !isMelExpression((XmlAttributeValue) element)) {
//                final XmlAttributeValue attribute = (XmlAttributeValue) element;
//                return new PsiReference[]{new FlowPsiReference(attribute)};
//            }
//            return PsiReference.EMPTY_ARRAY;
//        }
//
//        private boolean isMelExpression(@NotNull XmlAttributeValue element) {
//            String value = element.getValue().trim();
//            return value.startsWith("#[") && value.endsWith("]");
//        }
//    }

    private static class ConfigRefProvider extends PsiReferenceProvider {
        @NotNull
        @Override
        public PsiReference[] getReferencesByElement(@NotNull final PsiElement element, @NotNull final ProcessingContext context) {
            if (element instanceof XmlAttributeValue) {
                final XmlAttributeValue attribute = (XmlAttributeValue) element;
                return new PsiReference[]{new ConfigRefPsiReference(attribute)};
            }
            return PsiReference.EMPTY_ARRAY;
        }
    }

}


