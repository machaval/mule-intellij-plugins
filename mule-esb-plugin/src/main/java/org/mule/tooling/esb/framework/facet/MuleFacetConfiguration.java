package org.mule.tooling.esb.framework.facet;

import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.mule.util.StringUtils;

public class MuleFacetConfiguration implements FacetConfiguration {
    public static final String MULE_FACET_TAG_NAME = "MuleFacet";
    public static final String PATH_TO_SDK_ATTR_NAME = "pathToSdk";

    private String myPathToSdk = "";

    MuleFacetConfigurationTab tab;

    @Override
    public FacetEditorTab[] createEditorTabs(FacetEditorContext context, FacetValidatorsManager manager) {
        return new FacetEditorTab[] { getConfigurationTab() };
    }

    public void setPathToSdk(String path) {
        myPathToSdk = path;
        getConfigurationTab().myPath.setText(path);
    }

    public String getPathToSdk() {
        return myPathToSdk;
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException {
        Element facet = element.getChild(MULE_FACET_TAG_NAME);
        if (facet != null) {
            myPathToSdk = facet.getAttributeValue(PATH_TO_SDK_ATTR_NAME, "");
            getConfigurationTab().myPath.setText(myPathToSdk);
        }
    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException {
        Element facet = new Element(MULE_FACET_TAG_NAME);
        facet.setAttribute(PATH_TO_SDK_ATTR_NAME, StringUtils.isEmpty(myPathToSdk) ? getConfigurationTab().myPath.getText() : myPathToSdk);
        element.addContent(facet);
    }

    private MuleFacetConfigurationTab getConfigurationTab() {
        if (tab == null)
            tab = new MuleFacetConfigurationTab(this);
        return tab;
    }
}
