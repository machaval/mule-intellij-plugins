package org.mule.lang.raml.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import org.mule.lang.raml.editor.RamlStructureViewElement;
import org.mule.lang.raml.psi.YamlKey;
import org.mule.lang.raml.psi.YamlKeyValPair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public class YamlKeyImpl extends YamlPsiElementImpl implements YamlKey {
    public YamlKeyImpl(@NotNull ASTNode astNode) {
        super(astNode);
    }

    public String toString() {
        return "Yaml key";
    }


    @Override
    public String getKeyText() {
        return getNode().getText();
    }

    @Override
    public String getName() {
        return getKeyText();
    }

    @Override
    public ItemPresentation getPresentation() {
        return new RamlStructureViewElement(this) {
            @Nullable
            @Override
            public String getPresentableText() {
                if (YamlKeyImpl.this.getParent() instanceof YamlKeyValPair) {
                    YamlKeyValPair keyValPair = (YamlKeyValPair) YamlKeyImpl.this.getParent();
                    return keyValPair.getKeyText() + ": " + keyValPair.getValueText();
                }
                return super.getPresentableText();
            }
        };
    }
}
