package org.mule.tooling.esb.lang.mel.parser.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.mel.parser.psi.MelMethodCallExpression;
import org.mule.tooling.lang.mel.parser.psi.impl.MelExpressionImpl;


public abstract class MelMethodExpressionBase extends MelExpressionImpl implements MelMethodCallExpression
{

    public MelMethodExpressionBase(ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        return new PsiReference[]{new MethodPsiElementPsiReferenceBase()};
    }

    private class MethodPsiElementPsiReferenceBase extends PsiReferenceBase<PsiElement> {
        public MethodPsiElementPsiReferenceBase() {
            super(MelMethodExpressionBase.this);
        }

        @Nullable
        @Override
        public PsiElement resolve() {
            final PsiElement[] children = getChildren();
            if (children.length > 0) {
                final PsiReference[] references = children[0].getReferences();
                final PsiReference reference = references[references.length - 1];
                final PsiElement resolve = reference.resolve();
                if (resolve instanceof PsiField) {
                    final PsiType type = ((PsiField) resolve).getType();
                    if (type instanceof PsiClassType) {
                        final PsiClass aClass = ((PsiClassType) type).resolve();
                        if (aClass != null) {
                            final PsiMethod[] methodsByName = aClass.findMethodsByName(getText(), false);
                            if (methodsByName.length > 0)
                                return methodsByName[0];
                        }
                    }
                }
            }
            return null;
        }

        @NotNull
        @Override
        public Object[] getVariants() {
            return new Object[0];
        }
    }
}
