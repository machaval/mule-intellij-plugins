// This is a generated file. Not intended for manual editing.
package org.mule.lang.dw.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.lang.dw.parser.psi.WeaveTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.mule.lang.dw.parser.psi.*;

public class WeaveArrayElementImpl extends ASTWrapperPsiElement implements WeaveArrayElement {

  public WeaveArrayElementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WeaveVisitor visitor) {
    visitor.visitArrayElement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) accept((WeaveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WeaveConditionalArrayElement getConditionalArrayElement() {
    return findChildByClass(WeaveConditionalArrayElement.class);
  }

  @Override
  @Nullable
  public WeaveSimpleArrayElement getSimpleArrayElement() {
    return findChildByClass(WeaveSimpleArrayElement.class);
  }

}
