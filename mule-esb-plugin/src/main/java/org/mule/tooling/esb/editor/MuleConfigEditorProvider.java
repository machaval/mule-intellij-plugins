package org.mule.tooling.esb.editor;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.util.MuleConfigUtils;


public class MuleConfigEditorProvider extends TextEditorProvider { //implements FileEditorProvider {
  @Override
  public boolean accept(@NotNull Project project, @NotNull VirtualFile virtualFile) {
    return MuleConfigUtils.isMuleFile(PsiManager.getInstance(project).findFile(virtualFile)) ;
  }

  @NotNull
  @Override
  public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
    return new MuleConfigEditor(project, virtualFile, this);
  }

  @NotNull
  @Override
  public String getEditorTypeId() {
    return "MuleConfig-Editor";
  }

  @NotNull
  @Override
  public FileEditorPolicy getPolicy() {
    return FileEditorPolicy.PLACE_BEFORE_DEFAULT_EDITOR;
  }

}
