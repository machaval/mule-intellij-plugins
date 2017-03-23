// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WeaveLambdaType extends WeaveType {

  @NotNull
  List<WeaveLambdaTypeParameter> getLambdaTypeParameterList();

  @Nullable
  WeaveType getType();

}
