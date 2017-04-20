package org.mule.tooling.lang.dw.views;


import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.JBTabsPaneImpl;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class DataWeaveInputView implements ToolWindowFactory {
  private ToolWindow myToolWindow;

  private JBTabsPaneImpl inputTabs;

  @Override
  public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
    this.inputTabs = new JBTabsPaneImpl(project, 1, toolWindow.getContentManager());
    ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
    Content content = contentFactory.createContent(inputTabs.getComponent(), "", false);
    toolWindow.getContentManager().addContent(content);
    Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();


  }

  @Override
  public void init(ToolWindow window) {
    myToolWindow = window;
  }

}
