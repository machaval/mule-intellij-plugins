package org.mule.tooling.esb.sdk.ui;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SdkVersionSelectionDialog<T> extends DialogWrapper
{
    private JLabel myLabel;
    private JComboBox myComboBox;

    public SdkVersionSelectionDialog(JComponent parent, String title, String name, List<String> scalaVersions)
    {
        super(parent, false);
        setTitle(title);
        myLabel = new JLabel(name);
        myComboBox = new ComboBox(new DefaultComboBoxModel<>(scalaVersions.toArray()));
        myLabel.setLabelFor(myComboBox);
        init();
    }

    protected JComponent createCenterPanel()
    {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(myLabel);
        panel.add(myComboBox);
        return panel;
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent()
    {
        return myComboBox;
    }

    public T getSelectedValue()
    {
        return (T) myComboBox.getSelectedItem();
    }
}
