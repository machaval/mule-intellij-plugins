// This is a generated file. Not intended for manual editing.
package org.mule.lang.dw.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.lang.dw.parser.psi.WeaveTypes.*;
import org.mule.lang.dw.parser.psi.*;

public class WeaveKeyExpressionImpl extends WeaveExpressionImpl implements WeaveKeyExpression {

  public WeaveKeyExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) ((WeaveVisitor)visitor).visitKeyExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WeaveDeclaredNamespace getDeclaredNamespace() {
    return findChildByClass(WeaveDeclaredNamespace.class);
  }

  @Override
  @Nullable
  public WeaveExpression getExpression() {
    return findChildByClass(WeaveExpression.class);
  }

  @Override
  @Nullable
  public WeaveIdentifier getIdentifier() {
    return findChildByClass(WeaveIdentifier.class);
  }

}
