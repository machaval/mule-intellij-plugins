package org.mule.tooling.lang.dw.debug.breakpoint;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.LocalTimeCounter;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.evaluation.EvaluationMode;
import com.intellij.xdebugger.evaluation.XDebuggerEditorsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.WeaveFileType;


public class WeaveDebuggerEditorsProvider extends XDebuggerEditorsProvider {
    @NotNull
    @Override
    public FileType getFileType() {
        return WeaveFileType.getInstance();
    }

    @NotNull
    @Override
    public Document createDocument(@NotNull Project project, @NotNull String text, @Nullable XSourcePosition xSourcePosition, @NotNull EvaluationMode evaluationMode) {

        final PsiFile psiFile = PsiFileFactory.getInstance(project)
                .createFileFromText("muleExpr." + getFileType().getDefaultExtension(), getFileType(), text, LocalTimeCounter.currentTime(), true);
        return PsiDocumentManager.getInstance(project).getDocument(psiFile);
    }
}
