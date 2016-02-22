package org.mule.lang.dw.parser.psi;


import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import org.mule.lang.dw.WeaveFile;
import org.mule.lang.dw.WeaveFileType;
import org.mule.lang.dw.parser.psi.WeaveDocument;
import org.mule.lang.dw.parser.psi.WeaveKeyValuePair;

public class WeaveElementFactory {

    public static WeaveIdentifier createIdentifier(Project project, String name) {
        return ((WeaveVariableReferenceExpression) createFile(project, name).getBody().getExpression()).getIdentifier();
    }


    public static WeaveDocument createFile(Project project, String text) {
        String name = "dummy.wev";
        return (WeaveDocument) PsiFileFactory.getInstance(project).
                createFileFromText(name, WeaveFileType.getInstance(), text).getChildren()[0];
    }
}
