// This is a generated file. Not intended for manual editing.
package org.mule.lang.raml.parser.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RamlRamlDirectiveTag extends PsiElement {

  @Nullable
  RamlEndOfLine getEndOfLine();

  @NotNull
  List<RamlInLineWhitespace> getInLineWhitespaceList();

  @Nullable
  RamlRamlDirectiveTag getRamlDirectiveTag();

  @Nullable
  RamlRamlTagHandle getRamlTagHandle();

  @Nullable
  RamlRamlTagPrefix getRamlTagPrefix();

}
