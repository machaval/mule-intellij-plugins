package org.mule.tooling.esb.config.refactoring.rename;

import com.intellij.featureStatistics.FeatureUsageTracker;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiUtilCore;
import com.intellij.psi.xml.XmlFile;
import com.intellij.psi.xml.XmlTag;
import com.intellij.refactoring.actions.BaseRefactoringAction;
import com.intellij.xml.XmlElementDescriptor;
import com.intellij.xml.impl.schema.AnyXmlElementDescriptor;
import com.intellij.xml.refactoring.XmlTagRenameHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.util.MuleConfigUtils;

/**
 * Created by eberman on 3/7/17.
 */
public class FlowRenameHandler extends XmlTagRenameHandler {
    private static final Logger LOG = Logger.getInstance("#org.mule.tooling.esb.config.refactoring.rename.FlowRenameHandler");
    @Override
    public boolean isAvailableOnDataContext(final DataContext dataContext) {
        PsiElement element = getElement(dataContext);

        if (element == null)
            element = CommonDataKeys.PSI_ELEMENT.getData(dataContext);

        final XmlTag flowTag = MuleConfigUtils.findParentXmlTag(element);

//        return (flowTag != null && MuleConfigUtils.isFlowTag(flowTag) && isDeclarationOutOfProjectOrAbsent(element.getProject(), dataContext));
        return (flowTag != null && MuleConfigUtils.isFlowTag(flowTag));
    }

    @Override
    public String getActionTitle() {
        return "Rename Mule Flow";
    }

    @Override
    public void invoke(@NotNull final Project project, final Editor editor, final PsiFile file, @Nullable final DataContext dataContext) {
        final PsiElement element = getElement(dataContext);
        final XmlTag flowTag = MuleConfigUtils.findParentXmlTag(element);
        invoke(editor, flowTag, dataContext);
    }

    @Override
    public void invoke(@NotNull final Project project, @NotNull final PsiElement[] elements, @Nullable final DataContext dataContext) {
        PsiElement element = elements.length == 1 ? elements[0] : null;
        if (element == null) {
            element = getElement(dataContext);
        }

        LOG.assertTrue(element != null);
        invoke(CommonDataKeys.EDITOR.getData(dataContext), element, dataContext);
    }

    private void invoke(@Nullable final Editor editor, @NotNull final PsiElement element, @Nullable final DataContext context) {
        if (!isRenaming(context)) {
            return;
        }

        FeatureUsageTracker.getInstance().triggerFeatureUsed("refactoring.rename");

        if (isInplaceRenameAvailable(editor)) {
            FlowInPlaceRenamer.rename(editor, (XmlTag)element);
        }
        else {
            FlowRenameDialog.renameFlowTag(editor, element, (XmlTag)element);
        }
    }

    @Nullable
    private PsiElement getElement(@Nullable final DataContext context) {
        if (context != null) {
            final Editor editor = CommonDataKeys.EDITOR.getData(context);
            if (editor != null) {
                final int offset = editor.getCaretModel().getOffset();
                final PsiFile file = CommonDataKeys.PSI_FILE.getData(context);
                if (file instanceof XmlFile && MuleConfigUtils.isMuleFile(file)) {
                    return file.getViewProvider().findElementAt(offset);
                }
                if (file != null) {
                    final Language language = PsiUtilCore.getLanguageAtOffset(file, offset);
                    if (language != file.getLanguage()) {
                        final PsiFile psiAtOffset = file.getViewProvider().getPsi(language);
                        if (psiAtOffset instanceof XmlFile && MuleConfigUtils.isMuleFile(psiAtOffset)) {
                            return psiAtOffset.findElementAt(offset);
                        }
                    }
                }
            }
        }

        return null;
    }

    private boolean isDeclarationOutOfProjectOrAbsent(@NotNull Project project, DataContext context) {
        PsiElement[] elements = BaseRefactoringAction.getPsiElementArray(context);
        return elements.length == 0 || elements.length == 1 && shouldBeRenamedInplace(project, elements);
    }

    private boolean shouldBeRenamedInplace(Project project, PsiElement[] elements) {
        boolean inProject = PsiManager.getInstance(project).isInProject(elements[0]);
        if(inProject && elements[0] instanceof XmlTag) {
            XmlElementDescriptor descriptor = ((XmlTag)elements[0]).getDescriptor();
            return descriptor instanceof AnyXmlElementDescriptor;
        } else {
            return !inProject;
        }
    }

    private boolean isInplaceRenameAvailable(final Editor editor) {
        return editor != null && editor.getSettings().isVariableInplaceRenameEnabled();
    }

}
