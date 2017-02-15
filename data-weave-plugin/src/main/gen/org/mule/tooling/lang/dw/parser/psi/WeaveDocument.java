// This is a generated file. Not intended for manual editing.
package org.mule.tooling.lang.dw.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.navigation.ItemPresentation;

public interface WeaveDocument extends NavigatablePsiElement {

  @Nullable
  WeaveBody getBody();

  @Nullable
  WeaveHeader getHeader();

  ItemPresentation getPresentation();

}
