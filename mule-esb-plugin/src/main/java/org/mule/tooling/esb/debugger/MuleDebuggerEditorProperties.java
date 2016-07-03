package org.mule.tooling.esb.debugger;


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
import org.mule.tooling.esb.lang.mel.MelFileType;

public class MuleDebuggerEditorProperties extends XDebuggerEditorsProvider {
    @NotNull
    @Override
    public FileType getFileType() {
        return MelFileType.getInstance();
    }

    @NotNull
    @Override
    public Document createDocument(@NotNull Project project, @NotNull String text, @Nullable XSourcePosition sourcePosition, @NotNull EvaluationMode evaluationMode) {
        final PsiFile psiFile = PsiFileFactory.getInstance(project)
                .createFileFromText("MelExpr." + getFileType().getDefaultExtension(), getFileType(), text, LocalTimeCounter.currentTime(), true);
        final Document document = PsiDocumentManager.getInstance(project).getDocument(psiFile);
        assert document != null;
        return document;
    }


}
