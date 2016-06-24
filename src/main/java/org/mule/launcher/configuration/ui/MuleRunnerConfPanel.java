package org.mule.launcher.configuration.ui;

import com.intellij.application.options.ModulesComboBox;
import org.mule.sdk.ui.MuleSdkComboSelection;

import javax.swing.*;

public class MuleRunnerConfPanel
{
    private JTextField vmArgsField;
    private JPanel mainPanel;
    private ModulesComboBox moduleCombo;
    private MuleSdkComboSelection muleSdkSelector;


    public MuleRunnerConfPanel()
    {

    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    public JTextField getVmArgsField()
    {
        return vmArgsField;
    }

    public JComboBox getMuleHome()
    {
        return muleSdkSelector.getMuleSdk();
    }

    public ModulesComboBox getModuleCombo()
    {
        return moduleCombo;
    }
}
