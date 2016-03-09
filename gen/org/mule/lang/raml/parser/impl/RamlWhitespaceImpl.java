// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.raml.parser.psi.RamlDigit;
import org.mule.lang.raml.parser.psi.RamlVisitor;
import org.mule.lang.raml.parser.psi.RamlWhitespace;

public class RamlWhitespaceImpl extends ASTWrapperPsiElement implements RamlWhitespace {

  public RamlWhitespaceImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RamlVisitor) ((RamlVisitor)visitor).visitWhitespace(this);
    else super.accept(visitor);
  }

}
