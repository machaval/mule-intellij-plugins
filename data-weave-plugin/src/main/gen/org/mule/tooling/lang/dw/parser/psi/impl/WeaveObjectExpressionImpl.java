// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.tooling.lang.dw.parser.psi.WeaveTypes.*;
import org.mule.tooling.lang.dw.parser.psi.*;
import com.intellij.navigation.ItemPresentation;

public class WeaveObjectExpressionImpl extends WeaveExpressionImpl implements WeaveObjectExpression {

  public WeaveObjectExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WeaveVisitor visitor) {
    visitor.visitObjectExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) accept((WeaveVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WeaveMultipleKeyValuePairObj getMultipleKeyValuePairObj() {
    return findChildByClass(WeaveMultipleKeyValuePairObj.class);
  }

  @Override
  @Nullable
  public WeaveSingleKeyValuePairObj getSingleKeyValuePairObj() {
    return findChildByClass(WeaveSingleKeyValuePairObj.class);
  }

  public ItemPresentation getPresentation() {
    return WeavePsiImplUtils.getPresentation(this);
  }

}
