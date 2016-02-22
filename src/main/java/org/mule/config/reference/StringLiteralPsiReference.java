package org.mule.config.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.config.MuleConfigConstants;
import org.mule.util.MuleSupport;

public class StringLiteralPsiReference extends PsiReferenceBase<PsiLiteralExpression> {

    public StringLiteralPsiReference(@NotNull PsiLiteralExpression element) {
        super(element);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        final String flowName = getFlowName();
        final XmlTag flow = MuleSupport.findFlow(myElement.getProject(), flowName);
        if (flow != null) {
            final XmlAttribute name = flow.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE);
            return name != null ? name.getValueElement() : null;
        }
        return null;
    }

    private String getFlowName() {
        return String.valueOf(myElement.getValue());
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }
}
