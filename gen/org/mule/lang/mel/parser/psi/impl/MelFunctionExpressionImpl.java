// This is a generated file. Not intended for manual editing.
package org.mule.lang.mel.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.lang.mel.parser.psi.MelTypes.*;
import org.mule.lang.mel.parser.psi.*;

public class MelFunctionExpressionImpl extends MelExpressionImpl implements MelFunctionExpression {

  public MelFunctionExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MelVisitor) ((MelVisitor)visitor).visitFunctionExpression(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MelBlockExpression getBlockExpression() {
    return findChildByClass(MelBlockExpression.class);
  }

  @Override
  @Nullable
  public MelParameterList getParameterList() {
    return findChildByClass(MelParameterList.class);
  }

}
