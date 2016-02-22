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
import com.intellij.navigation.ItemPresentation;

public class WeaveObjectExpressionImpl extends WeaveExpressionImpl implements WeaveObjectExpression {

  public WeaveObjectExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) ((WeaveVisitor)visitor).visitObjectExpression(this);
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
