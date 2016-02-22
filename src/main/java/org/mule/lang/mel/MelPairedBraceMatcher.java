package org.mule.lang.mel;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.lang.mel.parser.psi.MelTypes;

public class MelPairedBraceMatcher implements PairedBraceMatcher {
    @Override
    public BracePair[] getPairs() {
        return new BracePair[]{new BracePair(MelTypes.LBRACE, MelTypes.RBRACE, true),
                new BracePair(MelTypes.LBRACKET, MelTypes.RBRACKET, true),
                new BracePair(MelTypes.LPARENTH, MelTypes.RPARENTH, true)};
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType iElementType, @Nullable IElementType iElementType1) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
