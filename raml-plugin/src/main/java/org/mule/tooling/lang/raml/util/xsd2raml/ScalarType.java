package org.mule.tooling.lang.raml.util.xsd2raml;

/**
 * Created by eberman on 5/18/17.
 */
public class ScalarType {

    public static String forXsdType(String xsdType) {
        if ("string".equals(xsdType)) return "string";
        if ("decimal".equals(xsdType)) return "number";
        if ("integer".equals(xsdType)) return "integer";
        if ("boolean".equals(xsdType)) return "boolean";
        if ("base64Binary".equals(xsdType)) return "file";
        if ("double".equals(xsdType)) return "number";

        return null;
    }

}
