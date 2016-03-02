package org.mule.wizzard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.openapi.Disposable;

import javax.swing.*;

public class MuleVersionConfiguration  extends ModuleWizardStep implements Disposable {
    private JTextField versionField;
    private JPanel mainPanel;
    private MuleMavenModuleBuilder moduleBuilder;

    public MuleVersionConfiguration(MuleMavenModuleBuilder moduleBuilder,String muleVersion) {
        this.moduleBuilder = moduleBuilder;
        versionField.setText(muleVersion);
    }

    @Override
    public JComponent getComponent() {
        return mainPanel;
    }

    @Override
    public void updateDataModel() {
        moduleBuilder.setMuleVersion(getMuleVersion());
    }

    public String getMuleVersion() {
        return versionField.getText();
    }


    @Override
    public void dispose() {

    }
}
