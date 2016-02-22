package org.mule.lang.mel.parser;


import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.mel.MelLanguage;

public class MelElementType extends IElementType {
    public MelElementType(@NotNull @NonNls String debugName) {
        super(debugName, MelLanguage.getInstance());
    }
}
