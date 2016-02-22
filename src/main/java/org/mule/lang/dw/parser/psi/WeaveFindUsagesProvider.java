package org.mule.lang.dw.parser.psi;


import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.dw.parser.WeaveLexer;

public class WeaveFindUsagesProvider implements FindUsagesProvider {

    private static final DefaultWordsScanner WORDS_SCANNER =
            new DefaultWordsScanner(new WeaveLexer(),
                    TokenSet.create(WeaveTypes.ID), TokenSet.create(WeaveTypes.LINE_COMMENT), TokenSet.EMPTY);


    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return WORDS_SCANNER;
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return com.intellij.lang.HelpID.FIND_OTHER_USAGES;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement psiElement) {
        if (psiElement instanceof WeaveFunctionDefinition || psiElement instanceof WeaveFunctionCallExpression) {
            return "Function";
        } else if (psiElement instanceof WeaveFunctionParameter) {
            return "Parameter";
        } else if (psiElement instanceof WeaveVariableDefinition || psiElement instanceof WeaveVariableReferenceExpression) {
            return "Variable";
        }
        return psiElement.getClass().getSimpleName();
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement psiElement) {
        return ((PsiNamedElement) psiElement).getName();
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement psiElement, boolean b) {
        return ((PsiNamedElement) psiElement).getName();
    }
}
