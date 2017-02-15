package org.mule.tooling.lang.dw;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.parser.psi.WeaveTypes;

public class WeavePairedBraceMatcher implements PairedBraceMatcher {
  @Override
  public BracePair[] getPairs() {
    return new BracePair[]{
            new BracePair(WeaveTypes.L_BRACKET, WeaveTypes.R_BRACKET, true),
            new BracePair(WeaveTypes.L_PARREN, WeaveTypes.R_PARREN, true),
            new BracePair(WeaveTypes.L_CURLY, WeaveTypes.R_CURLY, true)
    };
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
