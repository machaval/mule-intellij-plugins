package org.mule.tooling.lang.dw.structure;


import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.parser.psi.WeaveArrayExpression;
import org.mule.tooling.lang.dw.parser.psi.WeaveExpression;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeaveArrayView extends PsiTreeElementBase<WeaveArrayExpression> {
  protected WeaveArrayView(WeaveArrayExpression psiElement) {
    super(psiElement);
  }

  @NotNull
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    List<StructureViewTreeElement> result = new ArrayList<>();
    final List<WeaveExpression> arrayElementList = getElement().getExpressionList();
    for (WeaveExpression expression : arrayElementList) {
      final StructureViewTreeElement structureViewTreeElement = WeaveStructureElementFactory.create(expression);
      if (structureViewTreeElement != null) {
        result.add(structureViewTreeElement);
      }
    }
    return result;
  }

  @Nullable
  @Override
  public String getPresentableText() {
    return "";
  }

  @Override
  public Icon getIcon(boolean open) {
    return getElement().getPresentation().getIcon(open);
  }
}
