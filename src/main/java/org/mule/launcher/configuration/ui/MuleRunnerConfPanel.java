package org.mule.launcher.configuration.ui;

import com.intellij.application.options.ModulesComboBox;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;

import javax.swing.*;

public class MuleRunnerConfPanel {

    private JTextField vmArgsField;
    private TextFieldWithBrowseButton muleHome;
    private JPanel mainPanel;
    private ModulesComboBox moduleCombo;

    public MuleRunnerConfPanel(final Project project) {
        FileChooserDescriptor descriptor = new FileChooserDescriptor(false, true, false, false, false, false);
        muleHome.addBrowseFolderListener(null, "Select Mule Home", null, descriptor);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getVmArgsField() {
        return vmArgsField;
    }

    public TextFieldWithBrowseButton getMuleHome() {
        return muleHome;
    }

    public ModulesComboBox getModuleCombo() {
        return moduleCombo;
    }
}
