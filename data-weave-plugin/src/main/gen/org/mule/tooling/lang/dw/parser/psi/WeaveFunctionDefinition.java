// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WeaveFunctionDefinition extends WeaveNamedElement {

  @Nullable
  WeaveExpression getExpression();

  @NotNull
  List<WeaveFunctionParameter> getFunctionParameterList();

  @NotNull
  WeaveIdentifier getIdentifier();

  @Nullable
  WeaveType getType();

  @NotNull
  List<WeaveTypeParameter> getTypeParameterList();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
