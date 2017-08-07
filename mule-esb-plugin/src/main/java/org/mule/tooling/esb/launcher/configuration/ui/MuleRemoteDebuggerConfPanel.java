package org.mule.tooling.esb.launcher.configuration.ui;


import org.mule.tooling.esb.launcher.configuration.MuleRemoteConfiguration;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class MuleRemoteDebuggerConfPanel {
    private JTextField hostTextField;
    private JFormattedTextField portTextField;
    private JTextField mulePropertiesTextField;
    private JPanel mainPanel;

    public MuleRemoteDebuggerConfPanel() {

        updatePropertiesValue();
        portTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePropertiesValue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePropertiesValue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePropertiesValue();
            }
        });
    }

    public void updateFromConfig(MuleRemoteConfiguration configuration) {
        hostTextField.setText(configuration.getHost());
        portTextField.setText(String.valueOf(configuration.getPort()));
        updatePropertiesValue();
    }

    private void updatePropertiesValue() {
        mulePropertiesTextField.setText("-debug -M-Dmule.debug.enable=true -M-Dmule.debug.port=" + portTextField.getText());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getHostText() {
        return hostTextField.getText();
    }

    public int getPortNumber() {
        try {
            return Integer.parseInt(portTextField.getText());
        } catch (Exception e) {
            return 6666;
        }
    }

    private void createUIComponents() {
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMaximum(65535);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        portTextField = new JFormattedTextField(formatter);
    }
}
