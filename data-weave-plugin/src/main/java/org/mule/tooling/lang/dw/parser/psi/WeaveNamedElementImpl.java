package org.mule.tooling.lang.dw.parser.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public abstract class WeaveNamedElementImpl extends ASTWrapperPsiElement implements WeaveNamedElement {

  public WeaveNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public String getName() {
    return getIdentifier().getName();
  }

  public PsiElement setName(String newName) {
    ASTNode keyNode = getIdentifier().getNode();
    if (keyNode != null) {
      WeaveFqnIdentifier property = WeaveElementFactory.createIdentifier(getProject(), newName);
      getNode().replaceChild(keyNode, property.getNode());
    }
    return this;
  }

  public PsiElement getNameIdentifier() {
    ASTNode keyNode = getIdentifier().getNode();
    if (keyNode != null) {
      return keyNode.getPsi();
    } else {
      return null;
    }
  }

  public abstract WeaveIdentifier getIdentifier();
}
