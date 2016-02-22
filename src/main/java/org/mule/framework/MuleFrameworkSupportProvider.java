package org.mule.framework;

import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ui.configuration.FacetsProvider;
import org.jetbrains.annotations.NotNull;
import org.mule.sdk.MuleSdk;

public class MuleFrameworkSupportProvider extends FrameworkSupportInModuleProvider {
    @NotNull
    @Override
    public FrameworkTypeEx getFrameworkType() {
        return FrameworkTypeEx.EP_NAME.findExtension(MuleFrameworkType.class);
    }

    @NotNull
    @Override
    public FrameworkSupportInModuleConfigurable createConfigurable(@NotNull FrameworkSupportModel frameworkSupportModel) {
        return new MuleFrameworkConfigurable();
    }

    @Override
    public boolean isSupportAlreadyAdded(@NotNull Module module, @NotNull FacetsProvider facetsProvider) {
        return MuleSdk.getFrom(module) != null;
    }

    @Override
    public boolean isEnabledForModuleType(@NotNull ModuleType moduleType) {
        return MuleFrameworkUtil.isAcceptableModuleType(moduleType);
    }
}
