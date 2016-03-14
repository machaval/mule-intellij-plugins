package org.mule.config.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import org.mule.config.MuleConfigConstants;

import static com.intellij.patterns.PlatformPatterns.psiElement;
import static com.intellij.patterns.StandardPatterns.or;
import static com.intellij.patterns.XmlPatterns.xmlTag;


public class MuleElementsCompletionContributor extends CompletionContributor {

    public MuleElementsCompletionContributor() {
        extend(CompletionType.BASIC, psiElement().inside(or(
                xmlTag().withLocalName(MuleConfigConstants.FLOW_TAG_NAME),
                xmlTag().withLocalName(MuleConfigConstants.SUB_FLOW_TAG_NAME)
        )), new MuleElementCompletionProvider());
    }

}
