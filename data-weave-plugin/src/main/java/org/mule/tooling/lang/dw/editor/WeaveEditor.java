package org.mule.tooling.lang.dw.editor;

import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.icons.AllIcons;
import com.intellij.ide.scratch.RootType;
import com.intellij.ide.scratch.ScratchFileService;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageUtil;
import com.intellij.openapi.actionSystem.*;
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
import com.intellij.openapi.fileTypes.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.psi.*;
import com.intellij.psi.util.FileTypeUtils;
import com.intellij.ui.JBTabsPaneImpl;
import com.intellij.ui.tabs.TabInfo;
import com.intellij.ui.tabs.impl.JBTabsImpl;
import com.intellij.util.FileContentUtilCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.lang.dw.WeaveFile;
import org.mule.tooling.lang.dw.WeaveFileType;
import org.mule.tooling.lang.dw.parser.psi.*;
import org.mule.tooling.lang.dw.util.WeaveUtils;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.List;

/**
 * Created by eberman on 11/3/16.
 */
public class WeaveEditor implements FileEditor {

    private Project project;
    private PsiAwareTextEditorImpl textEditor;

    private Map<String, Editor> editors = new HashMap<String, Editor>();
    private Map<String, String> contentTypes = new HashMap<String, String>();
    private Map<String, VirtualFile> inputOutputFiles = new HashMap<String, VirtualFile>();

    private JBTabsPaneImpl inputTabs;
    private JBTabsPaneImpl outputTabs;

    private WeaveEditorUI gui;

    final static Logger logger = Logger.getInstance(WeaveEditor.class);

    final static Key<String> newFileDataTypeKey = new Key<String>("NEW_FILE_TYPE");

    public WeaveEditor(@NotNull Project project, @NotNull VirtualFile virtualFile, final TextEditorProvider provider) {
        this.project = project;
        this.textEditor = new PsiAwareTextEditorImpl(project, virtualFile, provider);

        gui = new WeaveEditorUI(textEditor);

        inputTabs = new JBTabsPaneImpl(project, SwingConstants.TOP, this);
        ((JBTabsImpl)inputTabs.getTabs()).setSideComponentVertical(true);
        gui.getSourcePanel().add(inputTabs.getComponent(), BorderLayout.CENTER);

        outputTabs = new JBTabsPaneImpl(project, SwingConstants.TOP, this);
        ((JBTabsImpl)outputTabs.getTabs()).setSideComponentVertical(true);
        gui.getOutputPanel().add(outputTabs.getComponent(), BorderLayout.CENTER);
        gui.getOutputPanel().setSize(1000, 1000);

        PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
        if (psiFile != null && psiFile.getFileType() == WeaveFileType.getInstance()) {
            final WeaveFile weaveFile = (WeaveFile)psiFile;

            PsiManager.getInstance(project).addPsiTreeChangeListener(new PsiTreeChangeAdapter() {
                @Override
                public void childReplaced(@NotNull PsiTreeChangeEvent event) {
                    super.childReplaced(event);

                    if (event.getFile() != psiFile && !(event.getFile() instanceof WeaveFile))
                        return;
                    WeaveDocument weaveDocument = weaveFile.getDocument();
                    if (weaveDocument == null)
                        return;
                    WeaveHeader weaveHeader = weaveDocument.getHeader();
                    if (weaveHeader == null)
                        return;
                    //Iterate over input directives
                    List<WeaveInputDirective> inputDirectives = WeaveUtils.getInputDirectiveList(weaveHeader);
                    List<String> identifierNames = new ArrayList<String>();

                    for (WeaveInputDirective directive : inputDirectives) {
                        final WeaveIdentifier identifier = directive.getIdentifier();
                        final WeaveDataType dataType = directive.getDataType();
//
//                        logger.debug("Directive is " + directive.getText());
//                        logger.debug("identifier is " + identifier == null ? "NULL" : identifier.getName());
//                        logger.debug("dataType is " + dataType);

                        if (identifier != null) {
                            identifierNames.add(identifier.getName());
                            if (dataType != null) {
                                //If is not in list of tabs - add it
                                int tabIndex = getTabIndex(inputTabs, identifier.getName());
                                if (tabIndex == -1) {
                                    addTab(inputTabs, identifier, dataType);
                                } else {//If in the list of tabs - check type and replace as needed
                                    updateTab(inputTabs, tabIndex, identifier, dataType);
                                }
                            }
                        }

                    }
                    //Remove all tabs that are not in the input
                    List<TabInfo> itemsToRemove = new ArrayList<TabInfo>();
                    int count = inputTabs.getTabCount();
                    for (int index = 0; index < count; index++) {
                        String title = inputTabs.getTitleAt(index);
                        if (!identifierNames.contains(title)) {
                            itemsToRemove.add(inputTabs.getTabs().getTabAt(index));
                            editors.remove(title);
                            contentTypes.remove(title);
                            inputOutputFiles.remove(title);
                        }
                    }
                    if (!itemsToRemove.isEmpty()) {
                        for (TabInfo info : itemsToRemove) {
                            inputTabs.getTabs().removeTab(info);
                        }
                    }

                    //Update output directive
                    List<WeaveOutputDirective> outputDirectives = WeaveUtils.getOutputDirectiveList(weaveFile.getDocument().getHeader());
                    if (outputDirectives.isEmpty()) {
                        outputTabs.removeAll();
                    } else {
                        WeaveOutputDirective directive = outputDirectives.get(0);
                        final WeaveDataType dataType = directive.getDataType();
                        if (dataType != null) {
                            int tabIndex = getTabIndex(outputTabs, "output");
                            if (tabIndex == -1) {
                                addTab(outputTabs, null, dataType);
                            } else {//If in the list of tabs - check type and replace as needed
                                updateTab(outputTabs, tabIndex, null, dataType);
                            }
                        }
                    }

                    textEditor.getPreferredFocusedComponent().grabFocus();

                    runPreview();
                }
            });

            initTabs(weaveFile);
        }

    }

    @NotNull
    @Override
    public JComponent getComponent() {
        return gui.getRootPanel();
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

    private int getTabIndex(@NotNull JBTabsPaneImpl tabsPane, @NotNull String tabName) {
        int count = tabsPane.getTabCount();
        for (int index = 0; index < count; index++) {
            if (tabName.equalsIgnoreCase(tabsPane.getTitleAt(index))) {
                return index;
            }
        }
        return -1;
    }
    private void addTab(@NotNull JBTabsPaneImpl tabsPane, WeaveIdentifier identifier, @NotNull WeaveDataType dataType) {
        Icon icon = iconsMap.containsKey(dataType.getText()) ? iconsMap.get(dataType.getText()) : AllIcons.FileTypes.Any_type;

        Language language = getLanguage(dataType.getText());

        String title = identifier == null ? "output" : identifier.getName();

        PsiFile f = PsiFileFactory.getInstance(getProject()).createFileFromText(language,"");
        inputOutputFiles.put(title, f.getVirtualFile());

        if (identifier != null) {
            f.getViewProvider().getDocument().addDocumentListener(new DocumentAdapter() {
                @Override
                public void documentChanged(DocumentEvent e) {
                    runPreview();
                }
            });
        }

        f.getVirtualFile().putUserData(newFileDataTypeKey, dataType.getText());

        Editor editor = EditorFactory.getInstance().createEditor(f.getViewProvider().getDocument(), getProject(), language.getAssociatedFileType(), (identifier == null));
        editors.put(title, editor);

        contentTypes.put(title, dataType.getText());

        TabInfo tabInfo = new TabInfo(editor.getComponent());
        tabInfo.setText(title);
        tabInfo.setIcon(icon);

        DefaultActionGroup actionGroup = new DefaultActionGroup();
        //TODO: Removed OpenSchemaAction for now...
        //actionGroup.add(new OpenSchemaAction());
        if (identifier != null) { //For input tabs only
            actionGroup.add(new OpenSampleAction(editor.getDocument()));
        } else { //Add Refresh to OutputTab
            actionGroup.add(new RefreshAction(this));
        }
        tabInfo.setActions(actionGroup, "SchemaOrSample");

        tabsPane.getTabs().addTab(tabInfo);
    }

    private void updateTab(@NotNull JBTabsPaneImpl tabsPane, int index, WeaveIdentifier identifier, @NotNull WeaveDataType dataType) {
        Icon icon = iconsMap.containsKey(dataType.getText()) ? iconsMap.get(dataType.getText()) : AllIcons.FileTypes.Any_type;

        String title = (identifier == null ? "output" : identifier.getName());

        tabsPane.setTitleAt(index, title);
        tabsPane.setIconAt(index, icon);
        contentTypes.put(title, dataType.getText());

        VirtualFile vfile = inputOutputFiles.get(title);
        vfile.putUserData(newFileDataTypeKey, dataType.getText());
        FileContentUtilCore.reparseFiles(vfile);

        Editor oldEditor = editors.get(title);
        FileType newType = fileTypes.containsKey(dataType.getText()) ? fileTypes.get(dataType.getText()) : FileTypes.UNKNOWN;
        ((EditorEx)oldEditor).setHighlighter(EditorHighlighterFactory.getInstance().createEditorHighlighter(project, newType));
    }

    private void initTabs(WeaveFile weaveFile) {
        WeaveDocument document = weaveFile.getDocument();
        if (document != null) {

            final WeaveHeader header = document.getHeader();

            if (header != null) {

                final List<WeaveDirective> directiveList = header.getDirectiveList();

                for (WeaveDirective weaveDirective : directiveList) {

                    if (weaveDirective instanceof WeaveInputDirective) {
                        final WeaveInputDirective inputDirective = (WeaveInputDirective) weaveDirective;

                        final WeaveIdentifier identifier = inputDirective.getIdentifier();
                        final WeaveDataType dataType = inputDirective.getDataType();

                        if (identifier != null && dataType != null) {
                            addTab(inputTabs, identifier, dataType);
                        }
                    } else if (weaveDirective instanceof WeaveOutputDirective) {
                        final WeaveOutputDirective outputDirective = (WeaveOutputDirective) weaveDirective;
                        final WeaveDataType dataType = outputDirective.getDataType();
                        if (dataType != null) {
                            addTab(outputTabs, null, dataType);
                        }
                    }
                }
            }
        }
    }

    protected void runPreview() {
        Map <String, Object> payload = new HashMap<String, Object>();
        Map<String, Map<String, Object>> flowVars = new HashMap<String, Map<String, Object>>();


        /*
        1. Get input from tabs - if payload exists, use payload, otherwise put in the Map
        2. Get text from DW
        3. Run preview, put the output to the output tab
         */

        int count = inputTabs.getTabCount();
        for (int index = 0; index < count; index++) {
            String title = inputTabs.getTitleAt(index);
            Editor editor = editors.get(title);
            Document document = editor.getDocument();
            String text = document.getText();
            String contentType = contentTypes.get(title);
            Map<String, Object> content = WeavePreview.createContent(contentType, text);
            if ("payload".equalsIgnoreCase(title)) {
                payload = content;
            } else {
                flowVars.put(title, content);
            }
        }

        String dwScript = this.textEditor.getEditor().getDocument().getText();
        String output = WeavePreview.runPreview(dwScript, payload, flowVars, flowVars, flowVars, flowVars, flowVars, new ArrayList<>());
        editors.get("output").getDocument().setText(output);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    private static Language getLanguage(String mimeType) {
        Language language = null;
        Collection<Language> langs = Language.findInstancesByMimeType(mimeType);
        if (langs.isEmpty()) {
            language = PlainTextLanguage.INSTANCE;
        } else {
            language = langs.iterator().next();//Pick first one
        }

        return language;
    }

    private static Map<String, Icon> iconsMap = new HashMap<String, Icon>() {{
        put("application/json", AllIcons.FileTypes.Json);
        put("application/xml", AllIcons.FileTypes.Xml);
        put("application/csv", AllIcons.FileTypes.Text);
        put("text/csv", AllIcons.FileTypes.Text);
        put("text/xml", AllIcons.FileTypes.Xml);
        put("application/java", AllIcons.FileTypes.Java);
    }};
    private static Map<String, FileType> fileTypes = new HashMap<String, FileType>() {{
        put("application/json", FileTypeManager.getInstance().findFileTypeByName("JSON"));
        put("application/xml", StdFileTypes.XML);
        put("application/csv", FileTypes.UNKNOWN);
        put("text/csv", FileTypes.UNKNOWN);
        put("text/xml", StdFileTypes.XML);
        put("application/java", StdFileTypes.JAVA);
    }};

    public static class WeaveIOSubstitutor extends LanguageSubstitutor {
        @Nullable
        @Override
        public Language getLanguage(@NotNull VirtualFile file, @NotNull Project project) {
            return substituteLanguage(project, file);
        }

        @Nullable
        public static Language substituteLanguage(@NotNull Project project, @NotNull VirtualFile file) {
            Language language = null;

            if (file != null) {
                //logger.debug("*** VFile is " + file);
                String newDataType = file.getUserData(WeaveEditor.newFileDataTypeKey);
                //logger.debug("*** newDataType is " + newDataType);
                if (newDataType != null) {
                    language = WeaveEditor.getLanguage(newDataType);
                    //logger.debug("*** Resolved Language is " + language);
                }
            }

            return language;
        }
    }
}
