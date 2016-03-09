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

public class RamlRamlContentImpl extends ASTWrapperPsiElement implements RamlRamlContent {

  public RamlRamlContentImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitRamlContent(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RamlRamlBaseUri getRamlBaseUri() {
    return findChildByClass(RamlRamlBaseUri.class);
  }

  @Override
  @Nullable
  public RamlRamlMediaType getRamlMediaType() {
    return findChildByClass(RamlRamlMediaType.class);
  }

  @Override
  @Nullable
  public RamlRamlResourceTypes getRamlResourceTypes() {
    return findChildByClass(RamlRamlResourceTypes.class);
  }

  @Override
  @Nullable
  public RamlRamlSchemas getRamlSchemas() {
    return findChildByClass(RamlRamlSchemas.class);
  }

  @Override
  @Nullable
  public RamlRamlSecuredBy getRamlSecuredBy() {
    return findChildByClass(RamlRamlSecuredBy.class);
  }

  @Override
  @Nullable
  public RamlRamlSecuritySchemes getRamlSecuritySchemes() {
    return findChildByClass(RamlRamlSecuritySchemes.class);
  }

  @Override
  @Nullable
  public RamlRamlTitle getRamlTitle() {
    return findChildByClass(RamlRamlTitle.class);
  }

  @Override
  @Nullable
  public RamlRamlTraits getRamlTraits() {
    return findChildByClass(RamlRamlTraits.class);
  }

  @Override
  @Nullable
  public RamlRamlVersion getRamlVersion() {
    return findChildByClass(RamlRamlVersion.class);
  }

}
