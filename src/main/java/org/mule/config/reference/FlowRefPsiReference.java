package org.mule.config.reference;


import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.Function;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.config.MuleConfigConstants;
import org.mule.util.MuleSupport;

import java.util.List;

import static com.intellij.util.containers.ContainerUtil.mapNotNull;

public class FlowRefPsiReference extends PsiReferenceBase<PsiElement> {
    public FlowRefPsiReference(@NotNull PsiElement element) {
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
        return ((XmlAttribute) myElement).getValue();
    }

    @Override
    public boolean isReferenceTo(PsiElement element) {
        return element instanceof XmlAttribute && getFlowName().equals(((XmlAttribute) element).getValue());
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        ((XmlAttribute) myElement).setValue(newElementName);
        return myElement;
    }

    @Override
    public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
        return getElement();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        final List<DomElement> flow = MuleSupport.getFlows(getElement().getProject());
        return mapNotNull(flow, new Function<DomElement, Object>() {
            @Override
            public String fun(DomElement domElement) {
                return domElement.getXmlTag().getAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE);
            }
        }).toArray();
    }
}
