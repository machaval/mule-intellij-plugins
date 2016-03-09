// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.mule.lang.raml.parser.psi.RamlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.mule.lang.raml.parser.psi.*;

public class RamlMimetypeImpl extends ASTWrapperPsiElement implements RamlMimetype {

  public RamlMimetypeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitMimetype(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RamlParameter getParameter() {
    return findNotNullChildByClass(RamlParameter.class);
  }

  @Override
  @NotNull
  public List<RamlSubtype> getSubtypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RamlSubtype.class);
  }

  @Override
  @NotNull
  public RamlType getType() {
    return findNotNullChildByClass(RamlType.class);
  }

}
