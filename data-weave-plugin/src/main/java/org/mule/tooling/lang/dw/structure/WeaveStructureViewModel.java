package org.mule.tooling.lang.dw.structure;

import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class WeaveStructureViewModel extends StructureViewModelBase {

  public WeaveStructureViewModel(@NotNull PsiFile psiFile, @Nullable Editor editor, @NotNull StructureViewTreeElement root) {
    super(psiFile, editor, root);
  }

}
