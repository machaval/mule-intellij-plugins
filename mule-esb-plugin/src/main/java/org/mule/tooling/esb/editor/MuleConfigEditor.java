package org.mule.tooling.esb.editor;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.icons.AllIcons;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.editor.highlighter.EditorHighlighterFactory;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorImpl;
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.FileTypes;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiTreeChangeAdapter;
import com.intellij.psi.PsiTreeChangeEvent;
import com.intellij.ui.JBTabsPaneImpl;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;
import com.intellij.util.FileContentUtilCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.WeaveFile;
import org.mule.tooling.lang.dw.WeaveFileType;
import org.mule.tooling.lang.dw.parser.psi.WeaveDataFormat;
import org.mule.tooling.lang.dw.parser.psi.WeaveDirective;
import org.mule.tooling.lang.dw.parser.psi.WeaveDocument;
import org.mule.tooling.lang.dw.parser.psi.WeaveHeader;
import org.mule.tooling.lang.dw.parser.psi.WeaveIdentifier;
import org.mule.tooling.lang.dw.parser.psi.WeaveInputDirective;
import org.mule.tooling.lang.dw.parser.psi.WeaveOutputDirective;
import org.mule.tooling.lang.dw.util.WeaveUtils;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MuleConfigEditor implements FileEditor {

  private Project project;
  private PsiAwareTextEditorImpl textEditor;

  private Map<String, Editor> editors = new HashMap<String, Editor>();
  private Map<String, String> contentTypes = new HashMap<String, String>();
  private Map<String, VirtualFile> inputOutputFiles = new HashMap<String, VirtualFile>();

  private JBTabsPaneImpl inputTabs;
  private JBTabsPaneImpl outputTabs;

//  private WeaveEditorUI gui;

  final static Logger logger = Logger.getInstance(MuleConfigEditor.class);

  final static Key<String> newFileDataTypeKey = new Key<String>("NEW_FILE_TYPE");

  public MuleConfigEditor(@NotNull Project project, @NotNull VirtualFile virtualFile, final TextEditorProvider provider) {
    this.project = project;
    this.textEditor = new PsiAwareTextEditorImpl(project, virtualFile, provider);

//    gui = new WeaveEditorUI(textEditor);
//
//    inputTabs = new JBTabsPaneImpl(project, SwingConstants.TOP, this);
//    ((JBTabsImpl) inputTabs.getTabs()).setSideComponentVertical(true);
//    gui.getSourcePanel().add(inputTabs.getComponent(), BorderLayout.CENTER);
//
//    outputTabs = new JBTabsPaneImpl(project, SwingConstants.TOP, this);
//    ((JBTabsImpl) outputTabs.getTabs()).setSideComponentVertical(true);
//    gui.getOutputPanel().add(outputTabs.getComponent(), BorderLayout.CENTER);
//    gui.getOutputPanel().setSize(1000, 1000);
//
//    PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
//

  }

  @NotNull
  @Override
  public JComponent getComponent() {
    return textEditor.getComponent();
  }

  @Nullable
  @Override
  public JComponent getPreferredFocusedComponent() {
    return textEditor.getPreferredFocusedComponent();
  }

  @NotNull
  @Override
  public String getName() {
    return "DataWeave Editor";
  }

  @Override
  public void setState(@NotNull FileEditorState fileEditorState) {
    textEditor.setState(fileEditorState);
  }

  @Override
  public FileEditorState getState(@NotNull FileEditorStateLevel level) {
    return textEditor.getState(level);
  }

  @Override
  public boolean isModified() {
    return textEditor.isModified();
  }

  @Override
  public boolean isValid() {
    return textEditor.isValid();
  }

  @Override
  public void selectNotify() {

  }

  @Override
  public void deselectNotify() {

  }

  @Override
  public void addPropertyChangeListener(@NotNull PropertyChangeListener propertyChangeListener) {

  }

  @Override
  public void removePropertyChangeListener(@NotNull PropertyChangeListener propertyChangeListener) {

  }

  @Nullable
  @Override
  public BackgroundEditorHighlighter getBackgroundHighlighter() {
    return null;
  }

  @Nullable
  @Override
  public FileEditorLocation getCurrentLocation() {
    return null;
  }

  @Override
  public void dispose() {
    for (Editor editor : editors.values()) {
      EditorFactory.getInstance().releaseEditor(editor);
    }
    Disposer.dispose(textEditor);
    Disposer.dispose(this);
  }

  @Nullable
  @Override
  public <T> T getUserData(@NotNull Key<T> key) {
    return null;
  }

  @Override
  public <T> void putUserData(@NotNull Key<T> key, @Nullable T t) {

  }

//  private int getTabIndex(@NotNull JBTabsPaneImpl tabsPane, @NotNull String tabName) {
//    int count = tabsPane.getTabCount();
//    for (int index = 0; index < count; index++) {
//      if (tabName.equalsIgnoreCase(tabsPane.getTitleAt(index))) {
//        return index;
//      }
//    }
//    return -1;
//  }
//
//  private void addTab(@NotNull JBTabsPaneImpl tabsPane, WeaveIdentifier identifier, @NotNull WeaveDataFormat dataType) {
//    Icon icon = iconsMap.containsKey(dataType.getText()) ? iconsMap.get(dataType.getText()) : AllIcons.FileTypes.Any_type;
//
//    Language language = getLanguage(dataType.getText());
//
//    String title = identifier == null ? "output" : identifier.getName();
//
//    PsiFile f = PsiFileFactory.getInstance(getProject()).createFileFromText(language, "");
//    inputOutputFiles.put(title, f.getVirtualFile());
//
//    if (identifier != null) {
//      f.getViewProvider().getDocument().addDocumentListener(new DocumentAdapter() {
//        @Override
//        public void documentChanged(DocumentEvent e) {
//          runPreview();
//        }
//      });
//    }
//
//    f.getVirtualFile().putUserData(newFileDataTypeKey, dataType.getText());
//
//    Editor editor = EditorFactory.getInstance().createEditor(f.getViewProvider().getDocument(), getProject(), language.getAssociatedFileType(), (identifier == null));
//    editors.put(title, editor);
//
//    contentTypes.put(title, dataType.getText());
//
//    TabInfo tabInfo = new TabInfo(editor.getComponent());
//    tabInfo.setText(title);
//    tabInfo.setIcon(icon);
//
//    DefaultActionGroup actionGroup = new DefaultActionGroup();
//    //TODO: Removed OpenSchemaAction for now...
//    //actionGroup.add(new OpenSchemaAction());
//    if (identifier != null) { //For input tabs only
//      actionGroup.add(new OpenSampleAction(editor.getDocument()));
//    }
//    tabInfo.setActions(actionGroup, "SchemaOrSample");
//
//    tabsPane.getTabs().addTab(tabInfo);
//  }





  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }


}
