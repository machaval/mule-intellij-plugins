package org.mule.tooling.esb.framework;

import com.intellij.facet.*;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.impl.libraries.LibraryEx;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.ui.configuration.libraries.CustomLibraryDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.framework.facet.MuleFacet;
import org.mule.tooling.esb.framework.facet.MuleFacetConfiguration;
import org.mule.tooling.esb.framework.facet.MuleFacetType;
import org.mule.tooling.esb.sdk.MuleSdkManager;
import org.mule.tooling.esb.util.MuleConfigUtils;

import javax.swing.*;

public class MuleFrameworkConfigurable extends FrameworkSupportInModuleConfigurable {
    @Nullable
    @Override
    public JComponent createComponent() {
        return null;
    }

    @Nullable
    @Override
    public CustomLibraryDescription createLibraryDescription() {
        return new MuleLibraryDescription();
    }

    @Override
    public boolean isOnlyLibraryAdded() {
        return true;
    }

    @Override
    public void addSupport(@NotNull Module module, @NotNull ModifiableRootModel modifiableRootModel, @NotNull ModifiableModelsProvider modifiableModelsProvider) {

        String muleHome = null;

        Library[] libs = modifiableModelsProvider.getLibraryTableModifiableModel().getLibraries();
        for (Library nextLib : libs) {
            LibraryEx libraryEx = (LibraryEx)nextLib;
            if (muleHome == null && MuleLibraryKind.MULE_LIBRARY_KIND.equals(libraryEx.getKind())) {
                MuleLibraryProperties properties = (MuleLibraryProperties)libraryEx.getProperties();
                muleHome = properties.getState().getMuleHome();
                break;
            }
        }

        Project myProject = module.getProject();
        if (!MuleConfigUtils.isMuleProject(myProject)) {
            MuleFacetType type = (MuleFacetType) FacetTypeRegistry.getInstance().findFacetType(MuleFacet.ID);
            MuleFacetConfiguration configuration = type.createDefaultConfiguration();
            if (muleHome != null)
                configuration.setPathToSdk(muleHome);
            Facet facet = type.createFacet(module, "Mule", configuration, null);
            ModifiableFacetModel model = FacetManager.getInstance(module).createModifiableModel();
            model.addFacet(facet);
            model.commit();
        }
    }
}
