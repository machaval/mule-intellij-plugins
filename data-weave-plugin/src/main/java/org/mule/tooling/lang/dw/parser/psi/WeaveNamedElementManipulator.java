package org.mule.tooling.lang.dw.parser.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;


public class WeaveNamedElementManipulator extends AbstractElementManipulator<WeaveNamedElement> {
  @Override
  public WeaveNamedElement handleContentChange(@NotNull WeaveNamedElement weaveVariableReference, @NotNull TextRange textRange, String newName) throws IncorrectOperationException {
    return (WeaveNamedElement) weaveVariableReference.setName(newName);
  }
}
