package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.IncorrectOperationException;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.parser.RamlElementTypes;
import org.mule.lang.raml.psi.*;
import org.mule.lang.raml.psi.YamlScalar;
import org.mule.lang.raml.psi.YamlValue;

/**
 *
 */
public class YamlKeyValPairImpl extends YamlPsiElementImpl implements YamlKeyValPair {
    public YamlKeyValPairImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public String toString() {
        return "Yaml key-val pair";
    }


    @Override
    public YamlKey getKey() {
        ASTNode keys[];

        ASTNode[] compoundKeys = getNode().getChildren(TokenSet.create(RamlElementTypes.COMPOUND_KEY));
        if (compoundKeys.length > 0) {
            keys = compoundKeys[0].getChildren(TokenSet.create(RamlElementTypes.KEY));
        } else {
            keys = getNode().getChildren(TokenSet.create(RamlElementTypes.KEY));
        }

        return keys.length > 0 ? (YamlKey) keys[0].getPsi() : null;
    }

    @Override
    public String getKeyText() {
        return this.getKey() != null ? this.getKey().getText() : null;
    }

    @Override
    public YamlValue getValue() {
        if (getNode().getLastChildNode().getPsi() instanceof YamlValue)
            return (YamlValue) getNode().getLastChildNode().getPsi();

        return null;
    }

    @Override
    public String getValueText() {
        if (getValue() instanceof YamlScalar)
            return getValue().getText();
        else
            return "?? complex value ??";
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException {
        // TODO: needed for refactoring
        return null;
    }

    @Override
    public String getName() {
        return getKeyText();
    }
}
