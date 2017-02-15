// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WeaveVariableDefinition extends WeaveVariable {

  @NotNull
  WeaveExpression getExpression();

  @NotNull
  WeaveIdentifier getIdentifier();

  @Nullable
  WeaveType getType();

  @Nullable
  String getVariableName();

  @Nullable
  WeaveExpression getVariableValue();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
