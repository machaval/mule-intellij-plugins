// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.lang.raml.parser.psi.RamlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.mule.lang.raml.parser.psi.*;

public class RamlAlphadigitImpl extends ASTWrapperPsiElement implements RamlAlphadigit {

  public RamlAlphadigitImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitAlphadigit(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RamlAlpha getAlpha() {
    return findChildByClass(RamlAlpha.class);
  }

  @Override
  @Nullable
  public RamlDigit getDigit() {
    return findChildByClass(RamlDigit.class);
  }

}
