package org.mule.lang.mel.parser.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.CommonClassNames;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiType;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.JavaClassReferenceProvider;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.JavaClassReferenceSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.mel.parser.psi.impl.MelExpressionImpl;

public abstract class MelFqnTypeExpressionBase extends MelExpressionImpl implements MelFqnTypeExpression {

    public MelFqnTypeExpressionBase(ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public PsiReference[] getReferences() {
        final JavaClassReferenceProvider referenceProvider = new JavaClassReferenceProvider();
        referenceProvider.setOption(JavaClassReferenceProvider.DEFAULT_PACKAGE, CommonClassNames.DEFAULT_PACKAGE);
        final JavaClassReferenceSet classReferenceSet =
                new JavaClassReferenceSet(getText(), this, 0, true, referenceProvider);
        return classReferenceSet.getReferences();
    }

    @Nullable
    public PsiType getType() {
        final String text = getText();
        final String qualifiedClassName = StringUtil.containsChar(text, '.') ? text : CommonClassNames.DEFAULT_PACKAGE + "." + text;
        final String escapedName = StringUtil.replaceChar(qualifiedClassName, '$', '.');
        return JavaPsiFacade.getInstance(getProject()).getElementFactory().createTypeByFQClassName(escapedName);
    }

}
