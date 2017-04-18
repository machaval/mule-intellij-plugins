package org.mule.tooling.esb.framework.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowManager;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by eberman on 3/26/17.
 */
public class MuleFacetConfigurationTab extends FacetEditorTab {
    private JPanel top;
    public JTextField myPath;

    MuleFacetConfiguration muleFacetConfiguration;

    public MuleFacetConfigurationTab(MuleFacetConfiguration configuration) {
        muleFacetConfiguration = configuration;
    }

    @NotNull
    @Override
    public JComponent createComponent() {
        return top;
    }

    @Override
    public boolean isModified() {
        return !myPath.getText().equals(muleFacetConfiguration.getPathToSdk());
    }

    @Override
    public void reset() {
        myPath.setText(muleFacetConfiguration.getPathToSdk());
    }

    public void apply() throws ConfigurationException {
        muleFacetConfiguration.setPathToSdk(myPath.getText());
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Mule SDK";
    }

//    public void onFacetInitialized(@NotNull Facet facet) {
//        ToolWindowManager.getInstance(facet.getModule().getProject()).registerToolWindow("Global Configs", true, ToolWindowAnchor.LEFT, false);
//    }


}
