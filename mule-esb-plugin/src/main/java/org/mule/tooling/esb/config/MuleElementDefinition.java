package org.mule.tooling.esb.config;

import com.intellij.psi.xml.XmlTag;
import org.mule.tooling.esb.util.MuleElementType;

public class MuleElementDefinition {
    private XmlTag element;
    private String name;
    private String description;
    private MuleElementType type;

    public MuleElementDefinition(XmlTag element, String name, String description, MuleElementType type) {
        this.element = element;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public XmlTag getElement() {
        return element;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MuleElementType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "MuleElementDefinition{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
