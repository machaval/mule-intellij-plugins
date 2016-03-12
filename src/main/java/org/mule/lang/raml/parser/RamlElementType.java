package org.mule.lang.raml.parser;


import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.mel.MelLanguage;
import org.mule.lang.raml.RamlLanguage;

public class RamlElementType extends IElementType {
    public RamlElementType(@NotNull @NonNls String debugName) {
        super(debugName, RamlLanguage.getInstance());
    }
}
