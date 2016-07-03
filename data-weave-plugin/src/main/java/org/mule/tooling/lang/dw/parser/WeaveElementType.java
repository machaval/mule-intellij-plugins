package org.mule.tooling.lang.dw.parser;


import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.lang.dw.WeaveLanguage;

public class WeaveElementType extends IElementType {
    public WeaveElementType(@NotNull @NonNls String debugName) {
        super(debugName, WeaveLanguage.getInstance());
    }
}
