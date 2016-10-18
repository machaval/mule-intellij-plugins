package org.mule.tooling.esb.sdk.ui;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SdkVersionSelectionDialog<T> extends DialogWrapper
{
    private JLabel myLabel;
    private JComboBox myComboBox;
    private TextFieldWithBrowseButton destination;
    private JLabel destinationLabel;

    public SdkVersionSelectionDialog(JComponent parent, String title, String name, List<String> scalaVersions)
    {
        super(parent, false);
        setTitle(title);
        myLabel = new JLabel(name);
        myComboBox = new ComboBox(new DefaultComboBoxModel<>(scalaVersions.toArray()));
        myLabel.setLabelFor(myComboBox);

        destination = new TextFieldWithBrowseButton();

        destination.addBrowseFolderListener("Select new Mule distribution destination", null, null, FileChooserDescriptorFactory.createSingleFolderDescriptor());
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setLabelFor(destination);

        init();
    }

    protected JComponent createCenterPanel()
    {
        JPanel panel = new JPanel(new GridLayout());
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(myLabel);
        panel1.add(myComboBox);
        panel.add(panel1);
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(destinationLabel);
        panel2.add(destination);
        panel.add(panel2);
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

    public String getDestinationText() {
        return destination.getText();
    }
}
