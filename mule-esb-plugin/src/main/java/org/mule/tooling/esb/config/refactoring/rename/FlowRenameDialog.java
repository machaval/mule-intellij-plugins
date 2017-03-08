package org.mule.tooling.esb.config.refactoring.rename;

import com.intellij.codeInsight.completion.TagNameReferenceCompletionProvider;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupManager;
import com.intellij.lang.findUsages.DescriptiveNameUtil;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.help.HelpManager;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.xml.TagNameReference;
import com.intellij.psi.xml.XmlTag;
import com.intellij.refactoring.RefactoringBundle;
import com.intellij.refactoring.ui.NameSuggestionsField;
import com.intellij.refactoring.ui.RefactoringDialog;
import com.intellij.usageView.UsageViewUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.xml.XmlBundle;
import com.intellij.xml.refactoring.XmlTagRenameDialog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by eberman on 3/7/17.
 */
public class FlowRenameDialog extends RefactoringDialog {
    private static final Logger LOG = Logger.getInstance("#com.intellij.xml.refactoring.XmlTagRenameDialog");
    private static final String REFACTORING_NAME = RefactoringBundle.message("rename.title");
    private final PsiElement myElement;
    private final Editor myEditor;
    private JLabel myTitleLabel;
    private NameSuggestionsField myNameSuggestionsField;
    private String myHelpID;
    private final XmlTag myTag;
    private NameSuggestionsField.DataChanged myNameChangedListener;

    public FlowRenameDialog(@Nullable Editor editor, @NotNull PsiElement element, @NotNull XmlTag tag) {
        super(element.getProject(), true);
        this.myEditor = editor;
        this.myElement = element;
        this.myTag = tag;
        this.setTitle(REFACTORING_NAME);
        this.createNewNameComponent();
        this.init();
        this.myTitleLabel.setText("Rename Mule flow '" + tag.getAttributeValue("name") + "' and its usages to:");
        this.validateButtons();
    }

    protected void dispose() {
        this.myNameSuggestionsField.removeDataChangedListener(this.myNameChangedListener);
        super.dispose();
    }

    protected boolean hasHelpAction() {
        return false;
    }

    private static String getFullName(@NotNull XmlTag tag) {
        String name = DescriptiveNameUtil.getDescriptiveName(tag.getAttribute("name"));
        return (UsageViewUtil.getType(tag) + " " + name).trim();
    }

    public static void renameFlowTag(Editor editor, @NotNull PsiElement element, @NotNull XmlTag tag) {
        FlowRenameDialog dialog = new FlowRenameDialog(editor, element, tag);
        dialog.show();
    }

    private void createNewNameComponent() {
        String flowName = this.myTag.getAttribute("name").getValue();
        this.myNameSuggestionsField = new NameSuggestionsField(new String[]{ flowName }, this.myProject, FileTypes.PLAIN_TEXT, this.myEditor);
        this.myNameChangedListener = new NameSuggestionsField.DataChanged() {
            public void dataChanged() {
                FlowRenameDialog.this.validateButtons();
            }
        };
        this.myNameSuggestionsField.addDataChangedListener(this.myNameChangedListener);
        this.myNameSuggestionsField.getComponent().registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FlowRenameDialog.this.completeVariable(FlowRenameDialog.this.myNameSuggestionsField.getEditor());
            }
        }, KeyStroke.getKeyStroke(32, 2), 2);
    }

    private void completeVariable(Editor editor) {
        String prefix = this.myNameSuggestionsField.getEnteredName();
        PsiReference reference = this.myTag.getReference();
        if(reference instanceof TagNameReference) {
            LookupElement[] lookupItems = TagNameReferenceCompletionProvider.getTagNameVariants(this.myTag, this.myTag.getNamespacePrefix());
            editor.getCaretModel().moveToOffset(prefix.length());
            editor.getSelectionModel().removeSelection();
            LookupManager.getInstance(this.getProject()).showLookup(editor, lookupItems, prefix);
        }

    }

    protected void doAction() {
        LOG.assertTrue(this.myElement.isValid());
        CommandProcessor.getInstance().executeCommand(this.myProject, () -> {
            ApplicationManager.getApplication().runWriteAction(() -> {
                try {
                    this.myTag.getAttribute("name").setValue(this.getNewName());
                } catch (IncorrectOperationException var2) {
                    LOG.error(var2);
                }

            });
        }, RefactoringBundle.message("rename.title"), (Object)null);
        this.close(0);
    }

    @Nullable
    protected JComponent createCenterPanel() {
        return null;
    }

    public JComponent getPreferredFocusedComponent() {
        return this.myNameSuggestionsField.getFocusableComponent();
    }

    protected JComponent createNorthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        this.myTitleLabel = new JLabel();
        panel.add(this.myTitleLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(this.myNameSuggestionsField.getComponent());
        return panel;
    }

    protected void doHelpAction() {
        HelpManager.getInstance().invokeHelp(this.myHelpID);
    }

    public String getNewName() {
        return this.myNameSuggestionsField.getEnteredName().trim();
    }

    protected void validateButtons() {
        super.validateButtons();
        this.getPreviewAction().setEnabled(false);
    }

    protected boolean areButtonsValid() {
        String newName = this.getNewName();
        return !StringUtil.containsAnyChar(newName, "\t ;*'\"\\/,()^&<>={}");
    }
}
