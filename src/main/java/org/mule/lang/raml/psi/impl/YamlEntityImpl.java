package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.IncorrectOperationException;
import org.mule.lang.raml.lexer.RamlTokenTypes;
import org.mule.lang.raml.psi.YamlArray;
import org.mule.lang.raml.psi.YamlEntity;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class YamlEntityImpl extends YamlPsiElementImpl implements YamlEntity {
    public YamlEntityImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public String toString() {
        return "Yaml entity";
    }

    @Override
    public String getName() {
        try {
            return getNode().findChildByType(RamlTokenTypes.RAML_LITERAL).getText();
        } catch (NullPointerException e) {
            return "?? Jinja ??";
        }
    }

    @Override
    public YamlArray getArgs() {
        ASTNode children[] = getNode().getChildren(TokenSet.create(RamlTokenTypes.RAML_LITERAL));
        if (children.length > 0) return (YamlArray) children[0].getPsi(); // should be hash I guess
        else return null;
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException {
        // TODO: for refactoring
        return null;
    }
}
