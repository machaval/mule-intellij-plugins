package org.mule.tooling.esb.config.refactoring.rename;

import com.intellij.codeInsight.highlighting.HighlightManager;
import com.intellij.codeInsight.template.*;
import com.intellij.codeInsight.template.impl.TemplateState;
import com.intellij.codeInsight.template.impl.TextExpression;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlTag;
import com.intellij.refactoring.RefactoringBundle;
import com.intellij.util.containers.Stack;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.config.MuleConfigConstants;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eberman on 3/7/17.
 */
public class FlowInPlaceRenamer {
    private final Editor myEditor;
    private static final Stack<FlowInPlaceRenamer> ourRenamersStack = new Stack();
    private ArrayList<RangeHighlighter> myHighlighters;

    private FlowInPlaceRenamer(@NotNull Editor editor) {
        this.myEditor = editor;
    }

    public static void rename(Editor editor, @NotNull XmlTag flowTag) {
        if (!ourRenamersStack.isEmpty()) {
            ((FlowInPlaceRenamer) ourRenamersStack.peek()).finish();
        }

        FlowInPlaceRenamer renamer = new FlowInPlaceRenamer(editor);
        ourRenamersStack.push(renamer);

        renamer.rename(flowTag);
    }

    private void rename(@NotNull XmlTag flowTag) {
        XmlAttribute nameAttr = flowTag.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE);

        Project project = this.myEditor.getProject();

        if (project != null) {
            final List<XmlTag> refs = MuleConfigUtils.findFlowRefsForFlow(flowTag);
            final List<XmlTag> inFileRefs = new ArrayList<>();

            List<TextRange> highlightRanges = new ArrayList();
            this.myHighlighters = new ArrayList();

            for (XmlTag ref : refs) {
                if (ref.getContainingFile().equals(flowTag.getContainingFile())) {
                    highlightRanges.add(ref.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE).getValueElement().getTextRange());
                    inFileRefs.add(ref);
                }
            }
            CommandProcessor.getInstance().executeCommand(project, () -> {
                ApplicationManager.getApplication().runWriteAction(() -> {
                    int offset = this.myEditor.getCaretModel().getOffset();
                    this.myEditor.getCaretModel().moveToOffset(nameAttr.getTextOffset());
                    Template t = buildTemplate(nameAttr, inFileRefs);
                    TemplateManager.getInstance(project).startTemplate(this.myEditor, t, new TemplateEditingAdapter() {

                        @Override
                        public void beforeTemplateFinished(final TemplateState templateState, Template template) {
                            final TextResult value = templateState.getVariableValue("PrimaryVariable");

                            //for (XmlTag ref : refs) {
                            //   ref.setAttribute(MuleConfigConstants.NAME_ATTRIBUTE, value.getText());
                            //}
                        }

                        public void templateFinished(Template template, boolean brokenOff) {
                            FlowInPlaceRenamer.this.finish();
                        }

                        public void templateCancelled(Template template) {
                            FlowInPlaceRenamer.this.finish();
                        }
                    }, (variableName, value) -> {
                        return value.length() == 0 || value.charAt(value.length() - 1) != 32;
                    });
                    //this.myEditor.getCaretModel().moveToOffset(offset);
                    addHighlights(highlightRanges, this.myEditor, this.myHighlighters);
                });
            }, RefactoringBundle.message("rename.title"), (Object) null);
        }
    }

    private void finish() {
        ourRenamersStack.pop();
        if (this.myHighlighters != null) {
            Project project = this.myEditor.getProject();
            if (project != null && !project.isDisposed()) {
                HighlightManager highlightManager = HighlightManager.getInstance(project);
                Iterator var3 = this.myHighlighters.iterator();

                while (var3.hasNext()) {
                    RangeHighlighter highlighter = (RangeHighlighter) var3.next();
                    highlightManager.removeSegmentHighlighter(this.myEditor, highlighter);
                }
            }
        }
    }

    private static Template buildTemplate(@NotNull XmlAttribute attr, List<XmlTag> refs) {
        //XmlFile containingFile = (XmlFile)attr.getContainingFile();
        PsiElement commonParent = PsiTreeUtil.findCommonParent(refs);
        TemplateBuilderImpl builder = new TemplateBuilderImpl(attr);

        XmlAttributeValue attrValue = attr.getValueElement();
        PsiElement valuePsi = attrValue.getFirstChild().getNextSibling();

        String flowNameValue = new String(attrValue.getValue());
        builder.replaceElement(valuePsi,"PrimaryVariable", new TextExpression(flowNameValue), true);
/*

        for (XmlTag ref : refs) {
            if (ref.getContainingFile().equals(attr.getContainingFile())) {
                XmlAttribute nextAttr = ref.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE);
                XmlAttributeValue nextValue = nextAttr.getValueElement();
                PsiElement nextValuePsi = nextValue.getFirstChild().getNextSibling();
                builder.replaceElement(nextValuePsi, "OtherVariable", "PrimaryVariable",false);
            }
        }
*/

        return builder.buildInlineTemplate();
    }

    private static void addHighlights(List<TextRange> ranges, Editor editor, ArrayList<RangeHighlighter> highlighters) {
        EditorColorsManager colorsManager = EditorColorsManager.getInstance();
        TextAttributes attributes = colorsManager.getGlobalScheme().getAttributes(EditorColors.WRITE_SEARCH_RESULT_ATTRIBUTES);
        HighlightManager highlightManager = HighlightManager.getInstance(editor.getProject());
        Iterator iterator = ranges.iterator();

        while (iterator.hasNext()) {
            TextRange range = (TextRange) iterator.next();
            //highlightManager.addOccurrenceHighlight(editor, range.getStartOffset() + 1, range.getEndOffset() - 1, attributes, 0, highlighters, (Color) null);
            highlightManager.addRangeHighlight(editor, range.getStartOffset() + 1, range.getEndOffset() - 1, attributes, false, highlighters);
        }

        iterator = highlighters.iterator();

        while (iterator.hasNext()) {
            RangeHighlighter highlighter = (RangeHighlighter) iterator.next();
            highlighter.setGreedyToLeft(true);
            highlighter.setGreedyToRight(true);
        }

    }
//
//    protected Collection<PsiReference> collectRefs(PsiElement elementToRename, SearchScope referencesSearchScope) {
//        Query<PsiReference> search = ReferencesSearch.search(elementToRename, referencesSearchScope, false);
//        CommonProcessors.CollectProcessor<PsiReference> processor = new CommonProcessors.CollectProcessor<PsiReference>() {
//            protected boolean accept(PsiReference reference) {
//                return true;
//            }
//        };
//        search.forEach(processor);
//        return processor.getResults();
//    }

}
