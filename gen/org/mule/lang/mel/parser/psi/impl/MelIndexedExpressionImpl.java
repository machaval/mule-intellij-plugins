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

public class MelIndexedExpressionImpl extends MelExpressionImpl implements MelIndexedExpression {

  public MelIndexedExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MelVisitor) ((MelVisitor)visitor).visitIndexedExpression(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MelExpression getReferenceQualifier() {
    List<MelExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, MelExpression.class);
    return p1.get(0);
  }

  @Override
  @Nullable
  public MelExpression getIndexExpression() {
    List<MelExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, MelExpression.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

}
