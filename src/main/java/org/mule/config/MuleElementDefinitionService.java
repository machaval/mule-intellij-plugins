package org.mule.config;

import com.intellij.ide.highlighter.XmlFileType;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.xml.XmlDocument;
import com.intellij.psi.xml.XmlTag;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.mule.util.MuleElementType;
import org.mule.util.MuleSchemaUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MuleElementDefinitionService extends AbstractProjectComponent {


    protected MuleElementDefinitionService(Project project) {
        super(project);
    }

    public List<MuleModuleDefinition> getDefinitions() {
        return getModuleDefinitions(myProject, GlobalSearchScope.allScope(myProject));
    }


    @NotNull
    private List<MuleModuleDefinition> getModuleDefinitions(Project project, GlobalSearchScope searchScope) {
        final List<MuleModuleDefinition> result = new ArrayList<>();
        final Collection<VirtualFile> files = FileTypeIndex.getFiles(XmlFileType.INSTANCE, searchScope);
        for (VirtualFile file : files) {
            final PsiFile xmlFile = PsiManager.getInstance(project).findFile(file);
            if (xmlFile != null && isMuleSchema(xmlFile)) {
//                System.out.println("xmlFile = " + xmlFile.getName());
                final PsiElement[] children = xmlFile.getChildren();
                final XmlTag rootTag = ((XmlDocument) children[0]).getRootTag();
                if (rootTag != null) {
                    final String namespace = getNamespace(rootTag);
                    final String name = ArrayUtil.getLastElement(namespace.split("/"));
//                    System.out.println("namespace = " + namespace);
//                    System.out.println("name = " + name);
                    final XmlTag[] elements = rootTag.findSubTags("element", MuleSchemaUtils.HTTP_WWW_W3_ORG_2001_XMLSCHEMA);
                    final List<MuleElementDefinition> definitions = new ArrayList<>();
                    for (XmlTag element : elements) {
                        final String elementName = element.getAttributeValue("name");
//                        System.out.println("name = " + elementName);
                        final MuleElementType muleElementType = MuleSchemaUtils.getMuleElementTypeFromElement(element);
                        if (muleElementType != null) {
                            String description = "";
                            final XmlTag annotation = ArrayUtil.getFirstElement(element.findSubTags("annotation", MuleSchemaUtils.HTTP_WWW_W3_ORG_2001_XMLSCHEMA));
                            if (annotation != null) {
                                final XmlTag documentation = ArrayUtil.getFirstElement(annotation.findSubTags("documentation", MuleSchemaUtils.HTTP_WWW_W3_ORG_2001_XMLSCHEMA));
                                if (documentation != null) {
                                    description = documentation.getValue().getText();
                                }
                            }
                            definitions.add(new MuleElementDefinition(element, elementName, description, muleElementType));
//                            System.out.println("muleElementType = " + muleElementType);
//                            System.out.println("description = " + description);
                        }
                    }
                    result.add(new MuleModuleDefinition(name, StringUtil.capitalize(name), namespace, xmlFile, definitions));
                }
            }
        }
        return result;
    }

    public boolean isMuleSchema(PsiFile file) {
        if (!file.getName().endsWith(".xsd")) {
            return false;
        }
        final PsiElement[] children = file.getChildren();
        if (children.length > 0 && children[0] instanceof XmlDocument) {
            final XmlTag rootTag = ((XmlDocument) children[0]).getRootTag();
            if (rootTag != null) {
                final String xmlns = getNamespace(rootTag);
                if (xmlns != null && xmlns.startsWith("http://www.mulesoft.org/schema/mule/")) {
                    return true;
                }
            }
        }

        return false;

    }

    private String getNamespace(XmlTag rootTag) {
        return rootTag.getAttributeValue("xmlns");
    }

    public static MuleElementDefinitionService getInstance(Project p) {
        return p.getComponent(MuleElementDefinitionService.class);
    }
}
