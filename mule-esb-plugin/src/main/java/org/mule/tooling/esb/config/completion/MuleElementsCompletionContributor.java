package org.mule.tooling.esb.config.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.psi.xml.XmlTokenType;
import org.mule.tooling.esb.config.MuleConfigConstants;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.or;
import static com.intellij.patterns.XmlPatterns.xmlTag;


public class MuleElementsCompletionContributor extends CompletionContributor {

    public MuleElementsCompletionContributor() {
        extend(CompletionType.BASIC,
                psiElement(XmlTokenType.XML_NAME)
                        .afterSibling(psiElement(XmlTokenType.XML_START_TAG_START)).withSuperParent(2, or(
                        xmlTag().withLocalName(MuleConfigConstants.FLOW_TAG_NAME),
                        xmlTag().withLocalName(MuleConfigConstants.WHEN_TAG_NAME),
                        xmlTag().withLocalName(MuleConfigConstants.OTHERWISE_TAG_NAME),
                        xmlTag().withLocalName(MuleConfigConstants.FOREACH_TAG_NAME),
                        xmlTag().withLocalName(MuleConfigConstants.CHAIN_TAG_NAME),
                        xmlTag().withLocalName(MuleConfigConstants.ENRICHER),
                        xmlTag().withLocalName(MuleConfigConstants.SUB_FLOW_TAG_NAME))
                ), new MuleElementCompletionProvider());
    }

}
