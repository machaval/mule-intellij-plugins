// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.navigation.ItemPresentation;

public interface WeaveArrayExpression extends WeaveExpression, NavigatablePsiElement {

  @NotNull
  List<WeaveExpression> getExpressionList();

  ItemPresentation getPresentation();

}
