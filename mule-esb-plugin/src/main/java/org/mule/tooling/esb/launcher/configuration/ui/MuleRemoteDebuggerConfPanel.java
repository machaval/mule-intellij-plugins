package org.mule.tooling.esb.launcher.configuration.ui;


import org.mule.tooling.esb.launcher.configuration.MuleRemoteConfiguration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class MuleRemoteDebuggerConfPanel {
  private JTextField hostTextField;
  private JTextField portTextField;
  private JTextField mulePropertiesTextField;
  private JPanel mainPanel;

  public MuleRemoteDebuggerConfPanel() {

    updatePropertiesValue();
    portTextField.addInputMethodListener(new InputMethodListener() {
      @Override
      public void inputMethodTextChanged(InputMethodEvent event) {
        updatePropertiesValue();
      }

      @Override
      public void caretPositionChanged(InputMethodEvent event) {

      }
    });

    portTextField.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
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
}
