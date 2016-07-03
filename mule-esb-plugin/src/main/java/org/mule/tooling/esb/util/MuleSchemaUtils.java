package org.mule.tooling.esb.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.XmlElementFactory;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.SchemaReferencesProvider;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.xml.util.XmlUtil;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.config.MuleConfigConstants;

public class MuleSchemaUtils {

    public static final String HTTP_WWW_W3_ORG_2001_XMLSCHEMA = "http://www.w3.org/2001/XMLSchema";

    @Nullable
    public static MuleElementType getMuleElementTypeFromElement(XmlTag elementTypeTag) {
        final XmlAttribute type = elementTypeTag.getAttribute("type");
        if (type != null) {
            final PsiReference schemaReference = getSchemaReference(type);
            if (schemaReference != null) {
                final PsiElement resolve = schemaReference.resolve();
                if (resolve != null && resolve instanceof XmlTag) {
                    return getElementTypeFromComplexType((XmlTag) resolve);
                }
            }
        } else {
            final XmlAttribute substitutionGroup = elementTypeTag.getAttribute("substitutionGroup");
            if (substitutionGroup != null) {
                final PsiReference schemaReference = getSchemaReference(substitutionGroup);
                if (schemaReference != null) {
                    final PsiElement resolve = schemaReference.resolve();
                    if (resolve instanceof XmlTag) {
                        return getMuleElementTypeFromElement((XmlTag) resolve);
                    }
                }
            }
        }
        return null;
    }

    public static void insertSchemaLocationLookup(XmlFile xmlFile, String namespace, String locationLookup) {
        final XmlTag rootTag = xmlFile.getRootTag();
        if (rootTag == null)
            return;
        final XmlAttribute attribute = rootTag.getAttribute("xsi:schemaLocation", HTTP_WWW_W3_ORG_2001_XMLSCHEMA);
        if (attribute != null) {
            final String value = attribute.getValue();
            attribute.setValue(value + "\n\t\t\t" + namespace + " " + locationLookup);
        } else {
            final XmlElementFactory elementFactory = XmlElementFactory.getInstance(xmlFile.getProject());
            final XmlAttribute schemaLocation = elementFactory.createXmlAttribute("xsi:schemaLocation", XmlUtil.XML_SCHEMA_INSTANCE_URI);
            schemaLocation.setValue(namespace + " " + locationLookup);
            rootTag.add(schemaLocation);
        }

    }

    @Nullable
    public static MuleElementType getElementTypeFromComplexType(XmlTag complexTypeTag) {
        final PsiReference baseType = getBaseType(complexTypeTag);
        if (baseType != null) {
            final PsiElement resolve = baseType.resolve();
            if (resolve instanceof XmlTag) {
                final XmlTag typeReference = (XmlTag) resolve;
                final String name = typeReference.getAttributeValue(MuleConfigConstants.NAME_ATTRIBUTE);
                if (name != null && !name.isEmpty()) {
                    MuleElementType muleElementType = getMuleElementType(name);
                    if (muleElementType != null) {
                        return muleElementType;
                    }
                    return getElementTypeFromComplexType(typeReference);
                }
            } else {
                final String name = baseType.getCanonicalText();
                if (!name.isEmpty()) {
                    return getMuleElementType(name);
                }
            }
        }
        return null;
    }

    @Nullable
    private static MuleElementType getMuleElementType(String name) {
        final MuleElementType[] muleElementTypes = MuleElementType.values();
        for (MuleElementType muleElementType : muleElementTypes) {
            if (muleElementType.isValidType(name)) {
                return muleElementType;
            }
        }
        return null;
    }

    @Nullable
    private static PsiReference getBaseType(XmlTag complexTypeTag) {
        final XmlTag complexContent = getComplexContents(complexTypeTag);
        if (complexContent != null) {
            final XmlTag extension = getExtensions(complexContent);
            if (extension != null) {
                final XmlAttribute base = extension.getAttribute("base");
                final PsiReference prefix = getSchemaReference(base);
                if (prefix != null) return prefix;
            }
        }
        return null;
    }

    @Nullable
    public static PsiReference getSchemaReference(XmlAttribute base) {
        if (base != null && base.getValueElement() != null) {
            final String text = base.getValue();
            if (text != null && text.indexOf(":") > 0) {
                final String prefix = text.substring(0, text.indexOf(":"));
                return SchemaReferencesProvider.createTypeOrElementOrAttributeReference(base.getValueElement(), prefix);
            } else {
                return SchemaReferencesProvider.createTypeOrElementOrAttributeReference(base.getValueElement());
            }
        }
        return null;
    }

    @Nullable
    private static XmlTag getExtensions(XmlTag complexContent) {
        final XmlTag[] complexContents = complexContent.findSubTags("extension", HTTP_WWW_W3_ORG_2001_XMLSCHEMA);
        return complexContents.length > 0 ? complexContents[0] : null;
    }

    @Nullable
    private static XmlTag getComplexContents(XmlTag complexTypeTag) {
        final XmlTag[] complexContents = complexTypeTag.findSubTags("complexContent", HTTP_WWW_W3_ORG_2001_XMLSCHEMA);
        return complexContents.length > 0 ? complexContents[0] : null;
    }
}
