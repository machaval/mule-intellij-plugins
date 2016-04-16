package org.mule.lang.mel.parser.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.JavaClassReferenceProvider;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.JavaClassReferenceSet;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.mel.parser.psi.impl.MelExpressionImpl;

public abstract class MelFqnTypeExpressionBase extends MelExpressionImpl implements MelFqnTypeExpression
{

    public MelFqnTypeExpressionBase(ASTNode node)
    {
        super(node);
    }

    @NotNull
    @Override
    public PsiReference[] getReferences()
    {
        final JavaClassReferenceProvider referenceProvider = new JavaClassReferenceProvider();
        referenceProvider.setOption(JavaClassReferenceProvider.DEFAULT_PACKAGE, CommonClassNames.DEFAULT_PACKAGE);
        final String text = getText();
        final PsiElement nextSibling = getNextSibling();
        if (nextSibling != null && nextSibling.getText() != null && nextSibling.getText().equals("("))
        {
            //Is method call
            final int lastDotIndex = text.lastIndexOf('.');
            if (lastDotIndex > 0)
            {
                final String baseExpression = text.substring(0, lastDotIndex);
                final String methodName = text.substring(lastDotIndex + 1);
                final JavaClassReferenceSet classReferenceSet = new JavaClassReferenceSet(baseExpression, this, 0, true, referenceProvider);
                final PsiReference[] references = classReferenceSet.getReferences();
                final PsiReference reference = ArrayUtil.getLastElement(references);
                if (reference != null)
                {
                    final TextRange rangeInElement = reference.getRangeInElement();
                    final int startOffset = rangeInElement.getEndOffset() + 1;
                    return ArrayUtil.append(references, new MethodPsiElementPsiReferenceBase(reference, methodName,
                            new TextRange(startOffset, startOffset + methodName.length())), PsiReference.class);
                }
                else
                {
                    return new PsiReference[0];
                }
            }
            else
            {
                return new PsiReference[0];
            }
        }
        else
        {
            final JavaClassReferenceSet classReferenceSet = new JavaClassReferenceSet(text, this, 0, true, referenceProvider);
            return classReferenceSet.getReferences();
        }
    }

    @Nullable
    public PsiType getType()
    {
        final String text = getText();
        final String qualifiedClassName = StringUtil.containsChar(text, '.') ? text : CommonClassNames.DEFAULT_PACKAGE + "." + text;
        final String escapedName = StringUtil.replaceChar(qualifiedClassName, '$', '.');
        return JavaPsiFacade.getInstance(getProject()).getElementFactory().createTypeByFQClassName(escapedName);
    }

    private class MethodPsiElementPsiReferenceBase extends PsiReferenceBase<PsiElement>
    {
        private PsiReference reference;
        private String methodName;

        public MethodPsiElementPsiReferenceBase(PsiReference reference, String methodName, TextRange rangeInElement)
        {
            super(MelFqnTypeExpressionBase.this, rangeInElement);
            this.reference = reference;
            this.methodName = methodName;
        }

        @Nullable
        @Override
        public PsiElement resolve()
        {
            final PsiElement resolve = reference.resolve();
            if (resolve instanceof PsiField)
            {
                final PsiType type = ((PsiField) resolve).getType();
                if (type instanceof PsiClassType)
                {
                    final PsiClass aClass = ((PsiClassType) type).resolve();
                    if (aClass != null)
                    {
                        final PsiMethod[] methodsByName = aClass.findMethodsByName(methodName, false);
                        if (methodsByName.length > 0)
                            return methodsByName[0];
                    }
                }
            }
            return null;
        }

        @NotNull
        @Override
        public Object[] getVariants()
        {
            final PsiElement resolve = reference.resolve();
            if (resolve instanceof PsiField)
            {
                final PsiType type = ((PsiField) resolve).getType();
                if (type instanceof PsiClassType)
                {
                    final PsiClass aClass = ((PsiClassType) type).resolve();
                    if (aClass != null)
                    {
                        return aClass.getAllMethods();

                    }
                }
            }
            return new Object[0];
        }
    }

}


