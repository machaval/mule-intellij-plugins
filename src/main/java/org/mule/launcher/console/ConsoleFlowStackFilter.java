package org.mule.launcher.console;

import com.intellij.execution.filters.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.Nullable;

/**
 * Created by eberman on 5/31/16.
 */
public class ConsoleFlowStackFilter implements Filter {

    //Matches strings like :
    // Element               : /TestCustomType/processors/3 @ JdbcCustomType:jdbc-customtype.xml:53
    private final String ELEMENT_REGEX = "^Element.*\\@ .*\\:.*\\.xml\\:.*";
    private final Project myProject;

    static final Logger logger = Logger.getInstance(ConsoleFlowStackFilter.class);

    public ConsoleFlowStackFilter(Project myProject) {
        this.myProject = myProject;
    }

    @Nullable
    @Override
    public Result applyFilter(String textLine, int endPoint) {

        logger.debug("In filter textLine is " + textLine);
        logger.debug("Regex match : " + textLine.matches(ELEMENT_REGEX));

        if (textLine != null && textLine.matches(ELEMENT_REGEX)) {
            String[] elements = textLine.split(":");
            String lineNumber = elements[elements.length - 1];
            String fileName = elements[elements.length - 2];

            final PsiFile[] psiFiles = FilenameIndex.getFilesByName(myProject, fileName, GlobalSearchScope.allScope(myProject));

            if (psiFiles.length == 0) {
                logger.debug("File: " + fileName + " not found in project: " + myProject.getName());
                return null;
            }

            HyperlinkInfo info = new OpenFileHyperlinkInfo(myProject, psiFiles[0].getVirtualFile(), Integer.parseInt(lineNumber), 0);
            return new Result(0, endPoint, info);
        }

        return null;
    }
}
