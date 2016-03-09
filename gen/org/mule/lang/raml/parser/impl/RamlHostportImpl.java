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

public class RamlHostportImpl extends ASTWrapperPsiElement implements RamlHostport {

  public RamlHostportImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitHostport(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RamlHost getHost() {
    return findNotNullChildByClass(RamlHost.class);
  }

  @Override
  @Nullable
  public RamlPort getPort() {
    return findChildByClass(RamlPort.class);
  }

}
