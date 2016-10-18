package org.mule.tooling.esb.sdk.ui;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.util.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SdkVersionSelectionDialog<T> extends DialogWrapper
{
    private JLabel versionLabel;
    private JComboBox versionComboBox;
    private TextFieldWithBrowseButton destination;
    private JLabel destinationLabel;

    private JPanel centerPanel;

    public SdkVersionSelectionDialog(JComponent parent, String title, String name, List<String> scalaVersions)
    {
        super(parent, false);
        setTitle(title);
        //Create and populate the panel.
        centerPanel = new JPanel(new SpringLayout());

        versionLabel = new JLabel(name, JLabel.TRAILING);
        versionComboBox = new ComboBox(new DefaultComboBoxModel<>(scalaVersions.toArray()));
        versionLabel.setLabelFor(versionComboBox);

        centerPanel.add(versionLabel);
        centerPanel.add(versionComboBox);

        destination = new TextFieldWithBrowseButton();
        destination.addBrowseFolderListener("Select new Mule distribution destination", null, null, FileChooserDescriptorFactory.createSingleFolderDescriptor());
        destinationLabel = new JLabel("Destination:", JLabel.TRAILING);
        destinationLabel.setLabelFor(destination);

        centerPanel.add(destinationLabel);
        centerPanel.add(destination);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(centerPanel,
                2, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

        init();
    }

    protected JComponent createCenterPanel()
    {
        return centerPanel;
    }

    @Nullable
    @Override
    public JComponent getPreferredFocusedComponent()
    {
        return versionComboBox;
    }

    public T getSelectedValue()
    {
        return (T) versionComboBox.getSelectedItem();
    }

    public String getDestinationText() {
        return destination.getText();
    }
}
