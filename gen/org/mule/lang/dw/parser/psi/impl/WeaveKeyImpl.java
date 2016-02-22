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

public class WeaveKeyImpl extends ASTWrapperPsiElement implements WeaveKey {

  public WeaveKeyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) ((WeaveVisitor)visitor).visitKey(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WeaveAttributes getAttributes() {
    return findChildByClass(WeaveAttributes.class);
  }

  @Override
  @NotNull
  public WeaveExpression getExpression() {
    return findNotNullChildByClass(WeaveExpression.class);
  }

}
