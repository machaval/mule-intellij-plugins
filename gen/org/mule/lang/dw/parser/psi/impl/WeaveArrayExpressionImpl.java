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

public class WeaveArrayExpressionImpl extends WeaveExpressionImpl implements WeaveArrayExpression {

  public WeaveArrayExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) ((WeaveVisitor)visitor).visitArrayExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WeaveArrayElement> getArrayElementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WeaveArrayElement.class);
  }

  public ItemPresentation getPresentation() {
    return WeavePsiImplUtils.getPresentation(this);
  }

}
