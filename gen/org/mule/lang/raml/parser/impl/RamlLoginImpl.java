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

public class RamlLoginImpl extends ASTWrapperPsiElement implements RamlLogin {

  public RamlLoginImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitLogin(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RamlHostport getHostport() {
    return findNotNullChildByClass(RamlHostport.class);
  }

  @Override
  @Nullable
  public RamlPassword getPassword() {
    return findChildByClass(RamlPassword.class);
  }

  @Override
  @Nullable
  public RamlUser getUser() {
    return findChildByClass(RamlUser.class);
  }

}
