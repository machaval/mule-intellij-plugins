package org.mule.tooling.lang.raml.annotator;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.raml.util.RamlUtils;
import org.raml.v2.internal.framework.nodes.ErrorNode;
import org.raml.v2.internal.framework.nodes.Node;
import org.raml.v2.internal.impl.RamlBuilder;

import java.io.File;
import java.util.List;

public class RamlAnnotator extends ExternalAnnotator<PsiFile, RamlAnnotator.RamlValidationResult>
{

    @Nullable
    @Override
    public PsiFile collectInformation(@NotNull PsiFile file)
    {
        if (RamlUtils.isRamlFile(file))
        {
            return file;
        }
        else
        {
            return null;
        }
    }

    @Nullable @Override public RamlValidationResult doAnnotate(PsiFile file)
    {
        final Node build = new RamlBuilder().build(file.getText(), file.getVirtualFile().getPath());
        final List<ErrorNode> descendantsWith = build.findDescendantsWith(ErrorNode.class);
        return new RamlValidationResult(descendantsWith, file);
    }

    @Override
    public void apply(@NotNull PsiFile file, RamlValidationResult annotationResult, @NotNull AnnotationHolder holder)
    {
        final List<ErrorNode> errorNodes = annotationResult.getErrorNodes();
        for (ErrorNode errorNode : errorNodes)
        {
            if (file.getVirtualFile().getPath().endsWith(errorNode.getStartPosition().getPath()))
            {
                holder.createAnnotation(HighlightSeverity.ERROR, new TextRange(errorNode.getStartPosition().getIndex(), errorNode.getEndPosition().getIndex()), errorNode.getErrorMessage());
            }
        }

    }


    public static class RamlValidationResult
    {

        private List<ErrorNode> errorNodes;
        private PsiFile ramlFile;

        public RamlValidationResult(List<ErrorNode> errorNodes, PsiFile ramlFile)
        {
            this.errorNodes = errorNodes;
            this.ramlFile = ramlFile;
        }

        public List<ErrorNode> getErrorNodes()
        {
            return errorNodes;
        }

        public PsiFile getRamlFile()
        {
            return ramlFile;
        }
    }
}
