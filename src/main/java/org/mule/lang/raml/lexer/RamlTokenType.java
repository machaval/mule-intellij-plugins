package org.mule.lang.raml.lexer;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.RamlLanguage;


public class RamlTokenType extends IElementType {
    public RamlTokenType(@NotNull String debugName) {
        super(debugName, RamlLanguage.INSTANCE);
    }

    public String toString() {
        return "[RAML] " + super.toString();
    }
}
