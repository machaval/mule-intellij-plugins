package org.mule.tooling.esb.wizard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.sdk.ui.MuleSdkComboSelection;
import org.mule.tooling.esb.sdk.MuleSdk;
import org.mule.tooling.esb.sdk.MuleSdkManagerImpl;

import javax.swing.*;

public class MuleVersionConfiguration extends ModuleWizardStep implements Disposable
{

    private JPanel mainPanel;
    private MuleSdkComboSelection muleSdkCombo;
    private MuleModuleBuilder moduleBuilder;

    public MuleVersionConfiguration(MuleModuleBuilder moduleBuilder, String muleVersion)
    {
        this.moduleBuilder = moduleBuilder;
        muleSdkCombo.setSelectedSdk(MuleSdkManagerImpl.getInstance().findFromVersion(muleVersion));
    }

    @Override
    public JComponent getComponent()
    {
        return mainPanel;
    }

    @Override
    public void updateDataModel()
    {
        moduleBuilder.setMuleVersion(getMuleVersion());
    }

    @Override
    public boolean validate() throws ConfigurationException
    {
        return super.validate() && StringUtil.isNotEmpty(getMuleVersion());
    }

    @Nullable
    public String getMuleVersion()
    {
        final MuleSdk selectedSdk = muleSdkCombo.getSelectedSdk();
        if (selectedSdk != null)
        {
            return selectedSdk.getVersion();
        }
        else
        {
            return null;
        }
    }


    @Override
    public void dispose()
    {

    }
}
