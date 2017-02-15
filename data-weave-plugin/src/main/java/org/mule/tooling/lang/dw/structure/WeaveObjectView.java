package org.mule.tooling.lang.dw.structure;


import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.parser.psi.WeaveKeyValuePair;
import org.mule.tooling.lang.dw.parser.psi.WeaveMultipleKeyValuePairObj;
import org.mule.tooling.lang.dw.parser.psi.WeaveObjectExpression;
import org.mule.tooling.lang.dw.parser.psi.WeaveSingleKeyValuePairObj;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WeaveObjectView extends PsiTreeElementBase<WeaveObjectExpression> {
  protected WeaveObjectView(WeaveObjectExpression psiElement) {
    super(psiElement);
  }

  @NotNull
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    List<StructureViewTreeElement> result = new ArrayList<>();
    final WeaveObjectExpression weaveObjectExpression = getElement();
    final WeaveMultipleKeyValuePairObj keyValuePairObj = weaveObjectExpression.getMultipleKeyValuePairObj();
    if (keyValuePairObj != null) {
      final List<WeaveKeyValuePair> valuePairList = keyValuePairObj.getKeyValuePairList();
      for (WeaveKeyValuePair weaveKeyValuePair : valuePairList) {
        addKeyValuePair(result, weaveKeyValuePair);
      }
    }
    final WeaveSingleKeyValuePairObj singleKeyValuePairObj = weaveObjectExpression.getSingleKeyValuePairObj();
    if (singleKeyValuePairObj != null) {
      final WeaveKeyValuePair keyValuePair = singleKeyValuePairObj.getKeyValuePair();
      addKeyValuePair(result, keyValuePair);
    }
    return result;
  }

  private void addKeyValuePair(List<StructureViewTreeElement> result, WeaveKeyValuePair weaveKeyValuePair) {
    if (weaveKeyValuePair.getSimpleKeyValuePair() != null) {
      result.add(new WeavePropertyView(weaveKeyValuePair.getSimpleKeyValuePair()));
    }
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
