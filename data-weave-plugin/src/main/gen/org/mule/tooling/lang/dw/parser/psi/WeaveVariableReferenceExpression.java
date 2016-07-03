// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface WeaveVariableReferenceExpression extends WeaveExpression, WeaveNamedElement {

  @NotNull
  WeaveIdentifier getIdentifier();

  String getVariableName();

  PsiReference getReference();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
