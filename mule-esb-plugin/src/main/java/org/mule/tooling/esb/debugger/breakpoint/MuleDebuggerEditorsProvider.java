package org.mule.tooling.esb.debugger.breakpoint;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.PlainTextFileType;
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


public class MuleDebuggerEditorsProvider extends XDebuggerEditorsProvider
{
    @NotNull
    @Override
    public FileType getFileType()
    {
        return PlainTextFileType.INSTANCE;
    }

    @NotNull
    @Override
    public Document createDocument(@NotNull Project project, @NotNull String text, @Nullable XSourcePosition xSourcePosition, @NotNull EvaluationMode evaluationMode)
    {

        final PsiFile psiFile = PsiFileFactory.getInstance(project)
                                              .createFileFromText("muleExpr." + getFileType().getDefaultExtension(), getFileType(), text, LocalTimeCounter.currentTime(), true);
        return PsiDocumentManager.getInstance(project).getDocument(psiFile);
    }
}
