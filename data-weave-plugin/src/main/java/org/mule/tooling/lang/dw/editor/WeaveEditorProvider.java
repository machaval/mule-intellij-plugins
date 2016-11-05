package org.mule.tooling.lang.dw.editor;

import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorPolicy;
import com.intellij.openapi.fileEditor.FileEditorProvider;
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Created by eberman on 11/3/16.
 */
public class WeaveEditorProvider extends TextEditorProvider { //implements FileEditorProvider {
    @Override
    public boolean accept(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return "dw".equalsIgnoreCase(virtualFile.getExtension()) || "wev".equalsIgnoreCase(virtualFile.getExtension());
    }

    @NotNull
    @Override
    public FileEditor createEditor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        return new WeaveEditor(project, virtualFile, this);
    }

    @NotNull
    @Override
    public String getEditorTypeId() {
        return "DataWeave-Playground-Editor";
    }

    @NotNull
    @Override
    public FileEditorPolicy getPolicy() {
        return FileEditorPolicy.PLACE_BEFORE_DEFAULT_EDITOR;
    }

}
