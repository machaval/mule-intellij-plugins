package org.mule.tooling.esb.editor;

import java.util.HashMap;
import java.util.Map;

public class MuleXMLComponent {

    private final String operationName;

    public String getOperationName() {
        return operationName;
    }

    public String getExtensionName() {
        return extensionName;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void addParameter(String attribute, String value) {
        parameters.put(attribute, value);
    }

    private final String extensionName;

    public MuleXMLComponent(String operationName, String extensionName) {
        this.operationName = operationName;
        this.extensionName = extensionName;
    }

    private Map<String, String> parameters = new HashMap<>();
}
