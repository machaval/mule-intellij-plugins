package org.mule.framework;

import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import org.jetbrains.annotations.NotNull;
import org.mule.util.MuleIcons;

import javax.swing.*;

public class MuleFrameworkType extends FrameworkTypeEx {

    public static final String MULE_FRAMEWORK_NAME = "Mule";
    public static final String MULE_FRAMEWORK_ID = "Mule";

    public MuleFrameworkType() {
        super(MULE_FRAMEWORK_ID);
    }

    @NotNull
    @Override
    public FrameworkSupportInModuleProvider createProvider() {
        return new MuleFrameworkSupportProvider();
    }

    @NotNull
    @Override
    public String getPresentableName() {
        return MULE_FRAMEWORK_NAME;
    }

    @NotNull
    @Override
    public Icon getIcon() {
        return MuleIcons.MuleIcon;
    }



}
