package org.mule.tooling.lang.dw.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.dw.parser.psi.WeaveTypes;

public class WeaveExpressionCompletionProvider extends CompletionProvider<CompletionParameters> {


    public static String[] UNARY_OPERATORS = {"not", "sizeOf", "flatten", "valuesOf", "keysOf", "trim", "sum", "avg", "upper", "lower", "capitalize", "camelize", "dasherize", "ordinalize", "pluralize", "singularize", "underscore", "typeOf", "max", "min", "unzip"};
    public static String[] BINARY_OPERATORS = {"mapObject", "map", "pluck", "filter", "reduce", "groupBy", "orderBy", "find", "scan", "match", "distinctBy", "startsWith", "endsWith", "matches", "contains", "splitBy", "joinBy", "zip", "++", "--"};

    @Override
    protected void addCompletions(@NotNull CompletionParameters completionParameters, ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
        PsiElement prevSibling = completionParameters.getPosition().getPrevSibling();
        while (prevSibling != null && prevSibling instanceof PsiWhiteSpace) {
            prevSibling = prevSibling.getPrevSibling();
        }
        if (prevSibling instanceof LeafPsiElement) {
            final IElementType elementType = ((LeafPsiElement) prevSibling).getElementType();
            if (elementType.equals(WeaveTypes.COLON) || elementType.equals(WeaveTypes.L_PARREN) || elementType.equals(WeaveTypes.COMMA) || elementType.equals(WeaveTypes.AND_AND)) {
                for (String unaryOperator : UNARY_OPERATORS) {
                    final LookupElementBuilder map = LookupElementBuilder.create(unaryOperator);
                    completionResultSet.addElement(map);
                }
            } else if (elementType.equals(WeaveTypes.ID) || elementType.equals(WeaveTypes.R_PARREN)) {
                for (String unaryOperator : BINARY_OPERATORS) {
                    final LookupElementBuilder map = LookupElementBuilder.create(unaryOperator);
                    completionResultSet.addElement(map);
                }
            }
        } else if (prevSibling == null) {
            for (String unaryOperator : BINARY_OPERATORS) {
                final LookupElementBuilder map = LookupElementBuilder.create(unaryOperator);
                completionResultSet.addElement(map);
            }
        }


    }
}
