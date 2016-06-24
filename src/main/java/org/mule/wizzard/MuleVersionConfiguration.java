package org.mule.wizzard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.Nullable;
import org.mule.sdk.MuleSdk;
import org.mule.sdk.MuleSdkManagerImpl;
import org.mule.sdk.ui.MuleSdkComboSelection;

import javax.swing.*;

public class MuleVersionConfiguration extends ModuleWizardStep implements Disposable
{

    private JPanel mainPanel;
    private MuleSdkComboSelection muleSdkCombo;
    private MuleMavenModuleBuilder moduleBuilder;

    public MuleVersionConfiguration(MuleMavenModuleBuilder moduleBuilder, String muleVersion)
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
