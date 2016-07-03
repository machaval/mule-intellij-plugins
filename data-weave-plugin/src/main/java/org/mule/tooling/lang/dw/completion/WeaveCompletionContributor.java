package org.mule.tooling.lang.dw.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class WeaveCompletionContributor extends CompletionContributor {

    public WeaveCompletionContributor() {
        extend(
                CompletionType.BASIC,
                psiElement(),
                new WeaveExpressionCompletionProvider());
    }
}
