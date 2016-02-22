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

public class WeaveOutputDirectiveImpl extends WeaveDirectiveImpl implements WeaveOutputDirective {

  public WeaveOutputDirectiveImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WeaveVisitor) ((WeaveVisitor)visitor).visitOutputDirective(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WeaveDataType getDataType() {
    return findChildByClass(WeaveDataType.class);
  }

  @Override
  @Nullable
  public WeaveOptions getOptions() {
    return findChildByClass(WeaveOptions.class);
  }

}
