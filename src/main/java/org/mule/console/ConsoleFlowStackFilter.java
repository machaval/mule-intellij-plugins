package org.mule.console;

import com.intellij.execution.filters.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConsoleFlowStackFilter implements Filter
{

    private final Pattern ELEMENT_REGEX = Pattern.compile("^(Element[ ]*:[ ]*)([\\\\\\/:A-z0-9-_#$%^]+)[ ]*@[ ]*([A-z0-9-_#$%:^]+):([A-z0-9-_#$%:^.]+):([0-9]+)");
    private final Project myProject;

    static final Logger logger = Logger.getInstance(ConsoleFlowStackFilter.class);

    public ConsoleFlowStackFilter(Project myProject)
    {
        this.myProject = myProject;
    }

    @Nullable
    @Override
    public Result applyFilter(String textLine, int endPoint)
    {
        final Matcher matcher = ELEMENT_REGEX.matcher(textLine);
        if (matcher.find())
        {
            final String element = matcher.group(1);
            final String fileName = matcher.group(4);
            final String lineNumber = matcher.group(5);
            final PsiFile[] psiFiles = FilenameIndex.getFilesByName(myProject, fileName, GlobalSearchScope.allScope(myProject));
            if (psiFiles.length == 0)
            {
                logger.debug("File: " + fileName + " not found in project: " + myProject.getName());
                return null;
            }
            else
            {
                HyperlinkInfo info = new OpenFileHyperlinkInfo(myProject, psiFiles[0].getVirtualFile(), Integer.parseInt(lineNumber) - 1);
                return new Result(endPoint - (textLine.length() - element.length()), endPoint, info);
            }
        }
        return null;
    }
}