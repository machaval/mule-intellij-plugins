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

public class MelMethodCallExpressionImpl extends MelExpressionImpl implements MelMethodCallExpression {

  public MelMethodCallExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MelVisitor visitor) {
    visitor.visitMethodCallExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MelVisitor) accept((MelVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MelExpression getExpression() {
    return findNotNullChildByClass(MelExpression.class);
  }

  @Override
  @NotNull
  public MelParameterList getParameterList() {
    return findNotNullChildByClass(MelParameterList.class);
  }

}
