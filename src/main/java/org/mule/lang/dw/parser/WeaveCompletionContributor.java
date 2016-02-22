package org.mule.lang.dw.parser;

import com.intellij.codeInsight.TailType;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.lookup.TailTypeDecorator;
import com.intellij.openapi.project.DumbAware;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.patterns.StandardPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.dw.parser.psi.WeaveExpression;
import org.mule.lang.dw.parser.psi.WeaveTypes;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class WeaveCompletionContributor extends CompletionContributor implements DumbAware {

    public static String[] UNARY_OPERATORS = {"not", "sizeOf", "flatten", "valuesOf", "keysOf", "trim", "sum", "avg", "upper", "lower", "capitalize", "camelize", "dasherize", "ordinalize", "pluralize", "singularize", "underscore", "typeOf", "max", "min", "unzip"};
    public static String[] BINARY_OPERATORS = {"mapObject", "map", "pluck", "filter", "reduce", "groupBy", "orderBy", "find", "scan", "match", "distinctBy", "startsWith", "endsWith", "matches", "contains", "splitBy", "joinBy", "zip", "++", "--"};

    public WeaveCompletionContributor() {
//        installUnaryOperations();
//        installBinaryOperations();
    }

    private void installBinaryOperations() {
        final PsiElementPattern.Capture<PsiElement> afterExpression = psiElement().afterSiblingSkipping(PlatformPatterns.psiElement().whitespaceCommentEmptyOrError(), StandardPatterns.instanceOf(WeaveExpression.class));
        extendKeywordCompletion(afterExpression, BINARY_OPERATORS);
    }

    private void installUnaryOperations() {
        final PsiElementPattern.Capture<PsiElement> afterExpression = psiElement().afterLeaf(psiElement().withElementType(WeaveTypes.COLON));
        extendKeywordCompletion(afterExpression, UNARY_OPERATORS);
    }


    private void extendKeywordCompletion(final PsiElementPattern.Capture<PsiElement> pattern,
                                         final String... keywords) {
        extend(CompletionType.BASIC,
                pattern,
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull final CompletionParameters completionParameters,
                                                  final ProcessingContext processingContext,
                                                  @NotNull final CompletionResultSet completionResultSet) {
                        for (final String keyword : keywords) {
                            final LookupElementBuilder builder = LookupElementBuilder.create(keyword).bold();
                            completionResultSet.addElement(TailTypeDecorator.withTail(builder, TailType.SPACE));
                        }
                    }
                });
    }
}
