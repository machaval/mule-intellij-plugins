package org.mule.tooling.esb.config.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.Function;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.config.MuleConfigConstants;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.util.List;

import static com.intellij.util.containers.ContainerUtil.mapNotNull;

public class FlowRefPsiReference extends PsiReferenceBase<XmlAttributeValue> {
    public FlowRefPsiReference(@NotNull XmlAttributeValue element) {
        super(element);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        final String flowName = getFlowName();
        final XmlTag flow = MuleConfigUtils.findFlow(myElement, flowName);
        if (flow != null) {
            final XmlAttribute name = flow.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE);
            return name != null ? name.getValueElement() : null;
        }
        return null;
    }

    private String getFlowName() {
        return myElement.getValue();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        final List<DomElement> flow = MuleConfigUtils.getFlows(getElement().getProject());
        return mapNotNull(flow, (Function<DomElement, Object>) domElement -> domElement.getXmlTag().getAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE)).toArray();
    }
}
