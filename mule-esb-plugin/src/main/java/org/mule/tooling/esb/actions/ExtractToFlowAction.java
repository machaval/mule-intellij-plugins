package org.mule.tooling.esb.actions;

import com.intellij.codeInsight.template.*;
import com.intellij.codeInsight.template.impl.TemplateSettings;
import com.intellij.codeInsight.template.impl.TemplateState;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.codeStyle.CodeEditUtil;
import com.intellij.psi.impl.source.resolve.reference.impl.manipulators.XmlTagManipulator;
import com.intellij.psi.impl.source.xml.XmlTextImpl;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.xml.*;
import com.intellij.util.xml.DomManager;
import org.mule.tooling.esb.config.model.Flow;
import org.mule.tooling.esb.config.model.Mule;
import org.mule.tooling.esb.util.MuleConfigUtils;
import org.mule.tooling.lang.raml.file.RamlFileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eberman on 3/2/17.
 */
public class ExtractToFlowAction extends AnAction {
    final static Logger logger = Logger.getInstance(EncryptPropertyAction.class);


    public ExtractToFlowAction()
    {
        super("Flow", "Extract code to a separate flow", null);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        final PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);
        final Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
        final Project project = anActionEvent.getProject();

        if (psiFile == null)
            return;

        if (!(editor.getSelectionModel().hasSelection()))
            return;

        PsiElement startPsi = psiFile.findElementAt(editor.getSelectionModel().getSelectionStart());
        PsiElement endPsi = psiFile.findElementAt(editor.getSelectionModel().getSelectionEnd());

        final PsiElement startPsiElement = _findParent(startPsi);
        final PsiElement endPsiElement = _findParent(endPsi);

        PsiElement parentTag = PsiTreeUtil.findCommonParent(startPsiElement, endPsiElement);

        if (startPsiElement.equals(endPsiElement) && startPsiElement.equals(parentTag)) //This is odd, findCommonParent for one tag returns the same tag
            parentTag = parentTag.getParent();

        List<PsiElement> children = Arrays.asList(parentTag.getChildren());

        int indexOfStart = children.indexOf(startPsiElement);
        int indexOfEnd = children.indexOf(endPsiElement) + 1;

        List<PsiElement> selectionChildren = children.subList(indexOfStart, indexOfEnd);

        DomManager domManager = DomManager.getDomManager(project);
        Mule mule = domManager.getFileElement((XmlFile)psiFile, Mule.class).getRootElement();

        final List<Flow> newFlows = new ArrayList<>();

        new WriteCommandAction.Simple(project, psiFile) {
            @Override
            protected void run() throws Throwable {
                Flow newFlow = mule.addFlow();
                newFlows.add(newFlow);
                XmlTag newFlowTag = newFlow.getXmlTag();

                for (PsiElement nextElement : selectionChildren) {
                    newFlowTag.add(nextElement.copy());
                }

                PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());
            }
        }.execute();

        PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(editor.getDocument());

        new WriteCommandAction.Simple(project, psiFile) {
            @Override
            protected void run() throws Throwable {
                for (PsiElement nextElement : selectionChildren) {
                    try {
                        if (nextElement.getParent() != null)
                            nextElement.delete();
                    } catch (Throwable e) {
                        ;
                    }
                }
                PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());
            }
        }.execute();

        PsiDocumentManager.getInstance(project).doPostponedOperationsAndUnblockDocument(editor.getDocument());

        new WriteCommandAction.Simple(project, psiFile) {
            @Override
            protected void run() throws Throwable {
                Template flowRefTemplate = TemplateSettings.getInstance().getTemplateById("mule-flow-ref");
                TemplateManager.getInstance(project).startTemplate(editor, flowRefTemplate, new TemplateEditingAdapter() {
                    @Override
                    public void currentVariableChanged(TemplateState templateState, Template template, int oldIndex, int newIndex) {
                        super.currentVariableChanged(templateState, template, oldIndex, newIndex);
                        String flowName = editor.getDocument().getText(templateState.getVariableRange("NAME"));
                        Flow newFlow = newFlows.get(0);
                        ApplicationManager.getApplication().runWriteAction(new Runnable() {
                            @Override
                            public void run() {
                                newFlow.getXmlTag().setAttribute("name", flowName);
                            }
                        });
                    }
                });
            }
        }.execute();
    }

    @Override
    public void update(AnActionEvent anActionEvent)
    {
        //final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);
        final Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);

        boolean inMuleFlow = false;

        if (psiFile != null)
        {
            PsiElement muleFlowTagElement = null;
            XmlTag muleFlowTag = null;

            if (editor != null && editor.getSelectionModel() != null && editor.getSelectionModel().hasSelection()) {
                PsiElement startPsi = psiFile.findElementAt(editor.getSelectionModel().getSelectionStart());
                PsiElement endPsi = psiFile.findElementAt(editor.getSelectionModel().getSelectionEnd());

                muleFlowTagElement = PsiTreeUtil.findCommonParent(startPsi, endPsi);
            } else {//Just find element under the caret
                muleFlowTagElement = anActionEvent.getData(LangDataKeys.PSI_ELEMENT);
            }

            if (muleFlowTagElement != null && muleFlowTagElement instanceof XmlTag) {
                muleFlowTag = (XmlTag)muleFlowTagElement;
            } else {
                muleFlowTag = PsiTreeUtil.getParentOfType(muleFlowTagElement, XmlTag.class);
            }

            inMuleFlow = MuleConfigUtils.isInTopLevelTag(muleFlowTag);
        }

        anActionEvent.getPresentation().setEnabled(inMuleFlow);
        anActionEvent.getPresentation().setVisible(inMuleFlow);
    }

    private PsiElement _findParent(PsiElement element) {
        PsiElement psiElement = element;

        while (psiElement != null &&
                !(psiElement instanceof XmlTag) &&
                !(psiElement instanceof XmlComment) &&
                !(psiElement instanceof XmlText))
            psiElement = psiElement.getParent();

        return psiElement;
    }
}
