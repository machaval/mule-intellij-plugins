// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.mel.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.tooling.lang.mel.parser.psi.MelTypes.*;
import org.mule.tooling.lang.mel.parser.psi.*;
import org.mule.tooling.esb.lang.mel.parser.psi.MelPsiImplUtils;

public class MelFunctionDefinitionExpressionImpl extends MelExpressionImpl implements MelFunctionDefinitionExpression {

  public MelFunctionDefinitionExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MelVisitor visitor) {
    visitor.visitFunctionDefinitionExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MelVisitor) accept((MelVisitor)visitor);
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
