package org.mule.lang.dw.refactor;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.refactoring.RefactoringActionHandler;
import org.jetbrains.annotations.NotNull;


public class IntroduceConstantHandler implements RefactoringActionHandler {
    @Override
    public void invoke(@NotNull Project project, Editor editor, PsiFile psiFile, DataContext dataContext) {
        final int selectionStart = editor.getSelectionModel().getSelectionStart();
        final int selectionEnd = editor.getSelectionModel().getSelectionEnd();
    }

    @Override
    public void invoke(@NotNull Project project, @NotNull PsiElement[] psiElements, DataContext dataContext) {

    }
}
