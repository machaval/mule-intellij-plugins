package org.mule.tooling.esb.editor;

import org.mule.runtime.api.meta.model.ComponentModel;

import java.util.HashMap;
import java.util.Map;

public class MuleXMLComponent {

    private final String operationName;
    private final String namespace;
    private Map<String, String> parameters = new HashMap<>();
    private ComponentModel componentModel;

    public MuleXMLComponent(String operationName, String namespace, ComponentModel componentModel) {
        this.operationName = operationName;
        this.namespace = namespace;
        this.componentModel = componentModel;
    }

    public String getOperationName() {
        return operationName;
    }

    public String getNamespace() {
        return namespace;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void addParameter(String attribute, String value) {
        parameters.put(attribute, value);
    }

    public ComponentModel getComponentModel() {
        return componentModel;
    }
}
