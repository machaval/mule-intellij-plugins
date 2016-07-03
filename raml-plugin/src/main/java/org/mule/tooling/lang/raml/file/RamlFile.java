package org.mule.tooling.lang.raml.file;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.yaml.YAMLElementTypes;
import org.jetbrains.yaml.psi.YAMLDocument;
import org.jetbrains.yaml.psi.YAMLFile;
import org.jetbrains.yaml.psi.YAMLPsiElement;
import org.mule.tooling.lang.raml.RamlLanguage;

import java.util.ArrayList;
import java.util.List;

public class RamlFile extends PsiFileBase implements YAMLFile
{
    public RamlFile(@NotNull FileViewProvider viewProvider)
    {
        super(viewProvider, RamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType()
    {
        return RamlFileType.getInstance();
    }

    public List<YAMLDocument> getDocuments()
    {
        ArrayList<YAMLDocument> result = new ArrayList<>();
        ASTNode[] var2 = this.getNode().getChildren(TokenSet.create(YAMLElementTypes.DOCUMENT));
        for (ASTNode node : var2)
        {
            result.add((YAMLDocument) node.getPsi());
        }

        return result;
    }

    public List<YAMLPsiElement> getYAMLElements()
    {
        ArrayList<YAMLPsiElement> result = new ArrayList<>();
        ASTNode[] var2 = this.getNode().getChildren(null);
        for (ASTNode node : var2)
        {
            PsiElement psi = node.getPsi();
            if (psi instanceof YAMLPsiElement)
            {
                result.add((YAMLPsiElement) psi);
            }
        }

        return result;
    }
}