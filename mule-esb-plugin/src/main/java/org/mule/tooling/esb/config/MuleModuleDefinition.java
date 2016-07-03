package org.mule.tooling.esb.config;

import com.intellij.psi.PsiFile;

import java.util.List;

public class MuleModuleDefinition {

    private String name;
    private String label;
    private String namespace;
    private PsiFile xsdFile;
    private List<MuleElementDefinition> elementDefinitions;

    public MuleModuleDefinition(String name, String label, String namespace, PsiFile xsdFile, List<MuleElementDefinition> elementDefinitions) {
        this.name = name;
        this.label = label;
        this.namespace = namespace;
        this.xsdFile = xsdFile;
        this.elementDefinitions = elementDefinitions;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getNamespace() {
        return namespace;
    }

    public PsiFile getXsdFile() {
        return xsdFile;
    }

    public List<MuleElementDefinition> getElementDefinitions() {
        return elementDefinitions;
    }

    public String getLocationLookup() {
        return namespace + "/current/" + getXsdFile().getName();
    }
}
