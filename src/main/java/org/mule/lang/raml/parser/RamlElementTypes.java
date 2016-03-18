package org.mule.lang.raml.parser;

import com.intellij.psi.tree.IFileElementType;
import org.mule.lang.raml.RamlLanguage;

/**
 * Types of elements returned from parser
 */
public interface RamlElementTypes {
    IFileElementType FILE = new IFileElementType(RamlLanguage.INSTANCE);

    RamlElementType KEY_VALUE_PAIR = new RamlElementType("Key value pair");
    RamlElementType KEY = new RamlElementType("Key");
    RamlElementType COMPOUND_KEY = new RamlElementType("Compound key");
    RamlElementType HASH = new RamlElementType("Hash");
    RamlElementType ITEM = new RamlElementType("Item");
    RamlElementType ENTITY = new RamlElementType("Entity");
    RamlElementType JINJA = new RamlElementType("Jinja2");

    RamlElementType ARRAY = new RamlElementType("Array");
    RamlElementType ARGS = new RamlElementType("Args");
    RamlElementType SEQUENCE = new RamlElementType("Sequence");
    RamlElementType COMPOUND_VALUE = new RamlElementType("Compound value");
    RamlElementType SCALAR_VALUE = new RamlElementType("Scalar value");
    RamlElementType REFERENCE = new RamlElementType("Reference");
}
