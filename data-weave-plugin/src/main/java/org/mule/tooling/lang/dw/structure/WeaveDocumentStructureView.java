package org.mule.tooling.lang.dw.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.WeaveFile;
import org.mule.tooling.lang.dw.parser.psi.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class WeaveDocumentStructureView extends PsiTreeElementBase<WeaveFile> {


    protected WeaveDocumentStructureView(@NotNull WeaveFile psiElement) {
        super(psiElement);
    }

    @NotNull
    @Override
    public Collection<StructureViewTreeElement> getChildrenBase() {
        final WeaveDocument element = getElement().getDocument();
        final List<StructureViewTreeElement> result = new ArrayList<>();
        if (element != null) {
            final WeaveHeader header = element.getHeader();
            if (header != null) {
                final List<WeaveDirective> weaveDirectives = header.getDirectiveList();
                for (WeaveDirective weaveDirective : weaveDirectives) {
                    if (weaveDirective instanceof WeaveVariableDirective) {
                        result.add(new WeaveVariableDirectiveView((WeaveVariableDirective) weaveDirective));
                    }
                    if (weaveDirective instanceof WeaveFunctionDirective) {
                        result.add(new WeaveFunctionDirectiveView((WeaveFunctionDirective) weaveDirective));
                    }
                }
            }
            final WeaveBody body = element.getBody();
            final StructureViewTreeElement treeElement = WeaveStructureElementFactory.create(body.getExpression());
            if (treeElement != null) {
                result.add(treeElement);
            }
        }

        return result;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return "";
    }
}
