package org.mule.tooling.esb.editor;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.intellij.codeHighlighting.BackgroundEditorHighlighter;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorLocation;
import com.intellij.openapi.fileEditor.FileEditorState;
import com.intellij.openapi.fileEditor.FileEditorStateLevel;
import com.intellij.openapi.fileEditor.impl.text.PsiAwareTextEditorImpl;
import com.intellij.openapi.fileEditor.impl.text.TextEditorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.xml.XmlFileImpl;
import com.intellij.psi.xml.XmlTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.runtime.api.meta.model.ComponentModel;
import org.mule.runtime.api.meta.model.ExtensionModel;
import org.mule.runtime.api.meta.model.operation.OperationModel;
import org.mule.runtime.api.meta.model.source.SourceModel;
import org.mule.runtime.api.meta.model.util.IdempotentExtensionWalker;
import org.mule.runtime.api.util.Reference;
import org.mule.tooling.esb.loader.ExtensionModelService;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;


public class MuleConfigEditor implements FileEditor {

    private Project project;
    private PsiAwareTextEditorImpl textEditor;
    private Map<String, Editor> editors = new HashMap<>();

    public MuleConfigEditor(@NotNull Project project, @NotNull VirtualFile virtualFile, final TextEditorProvider provider) {
        this.project = project;
        this.textEditor = new PsiAwareTextEditorImpl(project, virtualFile, provider);

        Multimap<String, MuleXMLComponent> flowsDescriptor = getMuleConfigFlowsDescriptor(project, virtualFile);
        final ExtensionModelService modelService = ExtensionModelService.getInstance();
        flowsDescriptor.entries().forEach(entry -> {
            final ExtensionModel extensionModel = modelService.get(entry.getValue().getNamespace());
            System.out.println(extensionModel);
        });



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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Parses the XML and returns a brief description of each flow and the components inside it
     */
    private Multimap<String, MuleXMLComponent> getMuleConfigFlowsDescriptor(@NotNull Project project, @NotNull VirtualFile virtualFile) {
        final ExtensionModelService modelService = ExtensionModelService.getInstance();
        PsiFile file = PsiManager.getInstance(project).findFile(virtualFile);
        XmlTag[] flows = ((XmlFileImpl) file).getRootTag().findSubTags("flow");
        Multimap<String, MuleXMLComponent> map = ArrayListMultimap.create();

        Stream
          .of(flows)
          .forEach(flow ->
                     Stream
                       .of(flow.getSubTags())
                       .forEach(componentTag -> {
                         final ExtensionModel extensionModel = modelService.get(componentTag.getNamespace());
                         final String componentName = componentTag.getLocalName();
                         MuleXMLComponent component = new MuleXMLComponent(componentName, componentTag.getNamespace(),
                                                              getComponentModel(componentName, extensionModel));

                         Stream
                           .of(componentTag.getAttributes())
                           .forEach(xmlAttribute -> component.addParameter(xmlAttribute.getName(), xmlAttribute.getValue()));

                         map.put(flow.getAttribute("name").getValue(), component);
        }));

        return map;
    }

    private ComponentModel getComponentModel(String componentName, ExtensionModel extensionModel) {
        final Reference<ComponentModel> reference = new Reference<>();
        final IdempotentExtensionWalker idempotentExtensionWalker = new IdempotentExtensionWalker() {

            @Override
            protected void onSource(SourceModel model) {
                if(model.getName().equals(componentName)){
                    reference.set(model);
                }
                stop();
            }

            @Override
            protected void onOperation(OperationModel model) {
                if(model.getName().equals(componentName)){
                    reference.set(model);
                }
                stop();
            }
        };
        idempotentExtensionWalker.walk(extensionModel);

        final ComponentModel componentModel = reference.get();
        if (componentModel == null){
            throw new RuntimeException(String.format("The component name [%s] cannot be found in the ExtensionModel [%s]", componentName, extensionModel.getName()));
        }
        return componentModel;
    }

}
