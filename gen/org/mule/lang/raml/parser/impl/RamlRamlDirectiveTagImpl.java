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

public class RamlRamlDirectiveTagImpl extends ASTWrapperPsiElement implements RamlRamlDirectiveTag {

  public RamlRamlDirectiveTagImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitRamlDirectiveTag(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RamlEndOfLine getEndOfLine() {
    return findChildByClass(RamlEndOfLine.class);
  }

  @Override
  @NotNull
  public List<RamlInLineWhitespace> getInLineWhitespaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RamlInLineWhitespace.class);
  }

  @Override
  @Nullable
  public RamlRamlDirectiveTag getRamlDirectiveTag() {
    return findChildByClass(RamlRamlDirectiveTag.class);
  }

  @Override
  @Nullable
  public RamlRamlTagHandle getRamlTagHandle() {
    return findChildByClass(RamlRamlTagHandle.class);
  }

  @Override
  @Nullable
  public RamlRamlTagPrefix getRamlTagPrefix() {
    return findChildByClass(RamlRamlTagPrefix.class);
  }

}
