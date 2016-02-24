package org.mule.config.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.Function;
import com.intellij.util.xml.DomElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.config.MuleConfigConstants;
import org.mule.util.MuleSupport;

import java.util.List;

import static com.intellij.util.containers.ContainerUtil.mapNotNull;

public class ConfigRefPsiReference extends PsiReferenceBase<XmlAttributeValue> {
    public ConfigRefPsiReference(@NotNull XmlAttributeValue element) {
        super(element);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        final String elementName = getElementName();
        final XmlTag globalElement = MuleSupport.findGlobalElement(myElement, elementName);
        if (globalElement != null) {
            final XmlAttribute name = globalElement.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE);
            return name != null ? name.getValueElement() : null;
        }
        return null;
    }

    private String getElementName() {
        return myElement.getValue();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        final List<XmlTag> flow = MuleSupport.getGlobalElements(getElement().getProject());
        return mapNotNull(flow, new Function<XmlTag, Object>() {
            @Override
            public String fun(XmlTag domElement) {
                return domElement.getAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE);
            }
        }).toArray();
    }
}
