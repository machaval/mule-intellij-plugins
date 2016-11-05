package org.mule.tooling.lang.dw.editor;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.fileEditor.impl.text.TextEditorImpl;
import com.intellij.ui.tabs.JBTabs;
import com.intellij.ui.tabs.impl.JBTabsImpl;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eberman on 11/3/16.
 */
public class WeaveEditorUI {

    private JPanel rootPanel;

    private JPanel sourcePanel;
    private JPanel editorPanel;
    private JPanel outputPanel;

    final static Logger logger = Logger.getInstance(WeaveEditorUI.class);

    public WeaveEditorUI(TextEditorImpl textEditor) {
        editorPanel.add(textEditor.getComponent(), BorderLayout.CENTER);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JPanel getSourcePanel() {
        return sourcePanel;
    }

    public void setSourcePanel(JPanel sourcePanel) {
        this.sourcePanel = sourcePanel;
    }

    public JPanel getEditorPanel() {
        return editorPanel;
    }

    public void setEditorPanel(JPanel editorPanel) {
        this.editorPanel = editorPanel;
    }

    public JPanel getOutputPanel() {
        return outputPanel;
    }

    public void setOutputPanel(JPanel outputPanel) {
        this.outputPanel = outputPanel;
    }

}
