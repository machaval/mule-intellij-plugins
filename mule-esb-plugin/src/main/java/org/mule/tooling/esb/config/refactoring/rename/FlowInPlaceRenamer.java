package org.mule.tooling.esb.config.refactoring.rename;

import com.intellij.codeInsight.daemon.impl.quickfix.EmptyExpression;
import com.intellij.codeInsight.highlighting.HighlightManager;
import com.intellij.codeInsight.template.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColors;
import com.intellij.openapi.editor.colors.EditorColorsManager;
import com.intellij.openapi.editor.markup.RangeHighlighter;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.searches.ReferencesSearch;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlAttributeValue;
import com.intellij.psi.xml.XmlChildRole;
import com.intellij.psi.xml.XmlTag;
import com.intellij.refactoring.RefactoringBundle;
import com.intellij.refactoring.util.CommonRefactoringUtil;
import com.intellij.util.Query;
import com.intellij.util.containers.Stack;
import com.intellij.xml.refactoring.XmlTagInplaceRenamer;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.config.MuleConfigConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
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

        XmlAttribute flowName = flowTag.getAttribute(MuleConfigConstants.NAME_ATTRIBUTE);
        renamer.rename(flowName);

        final Project project = flowTag.getProject();
        Collection<VirtualFile> vFiles = FilenameIndex.getAllFilesByExt(project, "xml");

        System.out.println(vFiles);
        /*TODO TEST ONLY ************************
        XmlAttributeValue flowNameValue = flowName.getValueElement();
        PsiReference[] refs = flowNameValue.getReferences();
        System.out.println(refs);

        Query<PsiReference> q = ReferencesSearch.search(flowNameValue, GlobalSearchScope.allScope(flowTag.getProject()));
        Collection<PsiReference> refsc = q.findAll();
        System.out.println(refsc);
        //TODO TEST ONLY *************************/

    }

    private void rename(@NotNull XmlAttribute nameAttr) {
        Project project = this.myEditor.getProject();
        if (project != null) {
            //TODO - find all flow refs in this file and highlight
//            List<TextRange> highlightRanges = new ArrayList();
//            highlightRanges.add(nameAttr.getTextRange());
//            this.myHighlighters = new ArrayList();
            CommandProcessor.getInstance().executeCommand(project, () -> {
                ApplicationManager.getApplication().runWriteAction(() -> {
                    int offset = this.myEditor.getCaretModel().getOffset();
                    this.myEditor.getCaretModel().moveToOffset(nameAttr.getTextOffset());
                    Template t = buildTemplate(nameAttr);
                    TemplateManager.getInstance(project).startTemplate(this.myEditor, t, new TemplateEditingAdapter() {
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
                    //addHighlights(highlightRanges, this.myEditor, this.myHighlighters);
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

    private static Template buildTemplate(@NotNull XmlAttribute attr) {
        TemplateBuilderImpl builder = new TemplateBuilderImpl(attr);

        builder.replaceElement(attr.getValueElement().getFirstChild().getNextSibling(), "PrimaryVariable", new EmptyExpression() {
            public Result calculateQuickResult(ExpressionContext context) {
                return new TextResult(attr.getValue());
            }

            public Result calculateResult(ExpressionContext context) {
                return new TextResult(attr.getValue());
            }
        }, true);

        return builder.buildInlineTemplate();
    }

    private static void addHighlights(List<TextRange> ranges, Editor editor, ArrayList<RangeHighlighter> highlighters) {
        EditorColorsManager colorsManager = EditorColorsManager.getInstance();
        TextAttributes attributes = colorsManager.getGlobalScheme().getAttributes(EditorColors.WRITE_SEARCH_RESULT_ATTRIBUTES);
        HighlightManager highlightManager = HighlightManager.getInstance(editor.getProject());
        Iterator iterator = ranges.iterator();

        while (iterator.hasNext()) {
            TextRange range = (TextRange) iterator.next();
            highlightManager.addOccurrenceHighlight(editor, range.getStartOffset() + 1, range.getEndOffset() - 1, attributes, 0, highlighters, (Color) null);
        }

        iterator = highlighters.iterator();

        while (iterator.hasNext()) {
            RangeHighlighter highlighter = (RangeHighlighter) iterator.next();
            highlighter.setGreedyToLeft(true);
            highlighter.setGreedyToRight(true);
        }

    }

}
