package org.mule.tooling.lang.dw.debug.breakpoint;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.xdebugger.XSourcePosition;
import com.intellij.xdebugger.breakpoints.XBreakpointProperties;
import com.intellij.xdebugger.breakpoints.XLineBreakpoint;
import com.intellij.xdebugger.breakpoints.XLineBreakpointType;
import com.intellij.xdebugger.evaluation.XDebuggerEditorsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.WeaveFileType;
import org.mule.tooling.lang.dw.parser.psi.WeavePsiUtils;

public class WeaveBreakpointType extends XLineBreakpointType<XBreakpointProperties>
{
    protected WeaveBreakpointType()
    {
        super("weave-breakpoint", "Weave Breakpoint");
    }


    @Override
    public boolean canPutAt(@NotNull VirtualFile file, int line, @NotNull Project project)
    {
        final Document document = FileDocumentManager.getInstance().getDocument(file);
        if (document != null)
        {
            final PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
            if (psiFile != null)
            {
                final FileType fileType = psiFile.getFileType();
                if (fileType.equals(WeaveFileType.getInstance()))
                {
                    return WeavePsiUtils.getFirstWeaveElement(project, document, line) != null;
                }
            }
        }
        return false;
    }


    @Override
    public XDebuggerEditorsProvider getEditorsProvider(@NotNull XLineBreakpoint<XBreakpointProperties> breakpoint, @NotNull Project project)
    {
        final XSourcePosition position = breakpoint.getSourcePosition();
        if (position == null)
        {
            return null;
        }

        final PsiFile file = PsiManager.getInstance(project).findFile(position.getFile());
        if (file == null)
        {
            return null;
        }

        return new WeaveDebuggerEditorsProvider();
    }

    @Nullable
    @Override
    public XBreakpointProperties createBreakpointProperties(@NotNull VirtualFile virtualFile, int i)
    {
        return null;
    }
}
