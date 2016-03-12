// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RamlRamlDirectiveRaml extends PsiElement {

  @Nullable
  RamlEndOfLine getEndOfLine();

  @Nullable
  RamlInLineWhitespace getInLineWhitespace();

  @NotNull
  List<RamlIntegerNumber> getIntegerNumberList();

}
