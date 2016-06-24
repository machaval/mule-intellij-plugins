package org.mule.sdk.ui;

import com.intellij.ui.ListCellRendererWrapper;
import org.jetbrains.annotations.Nullable;
import org.mule.sdk.MuleSdk;
import org.mule.sdk.MuleSdkManager;
import org.mule.sdk.MuleSdkManagerImpl;

import javax.swing.*;
import java.util.Set;

public class MuleSdkComboSelection
{

    private JPanel container;
    private JComboBox muleVersions;
    private JButton newButton;


    public MuleSdkComboSelection()
    {
        final MuleSdkComboBoxModel muleSdkComboBoxModel = new MuleSdkComboBoxModel();
        muleVersions.setModel(muleSdkComboBoxModel);
        muleVersions.setRenderer(new ListCellRendererWrapper<MuleSdk>()
        {

            @Override
            public void customize(JList jList, MuleSdk muleSdk, int i, boolean b, boolean b1)
            {
                if (muleSdk == null)
                {
                    this.setText("");
                }
                else
                {
                    this.setText(muleSdk.getVersion());
                }
            }
        });
        newButton.addActionListener(e -> {
            final MuleSdk muleSdk = new MuleSdkSelectionDialog(container).open();
            if (muleSdk != null)
            {
                MuleSdkManager.getInstance().addSdk(muleSdk);
                muleSdkComboBoxModel.addElement(muleSdk);
                muleVersions.setSelectedItem(muleSdk);
            }
        });
    }

    public void setSelectedSdk(@Nullable MuleSdk sdk)
    {
        if (sdk != null)
        {
            muleVersions.setSelectedItem(sdk);
        }
    }

    @Nullable
    public MuleSdk getSelectedSdk()
    {
        return (MuleSdk) muleVersions.getSelectedItem();
    }


    private static class MuleSdkComboBoxModel extends DefaultComboBoxModel<MuleSdk>
    {

        public MuleSdkComboBoxModel()
        {
            final MuleSdkManager instance = MuleSdkManagerImpl.getInstance();
            final Set<MuleSdk> muleSdks = instance.getSdks();
            for (MuleSdk muleSdk : muleSdks)
            {
                addElement(muleSdk);
            }
        }


    }

    public JPanel getContainer()
    {
        return container;
    }

    public JComboBox getMuleSdk()
    {
        return muleVersions;
    }
}
