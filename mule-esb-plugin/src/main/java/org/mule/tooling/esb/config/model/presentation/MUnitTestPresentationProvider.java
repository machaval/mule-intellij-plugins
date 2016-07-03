package org.mule.tooling.esb.config.model.presentation;

import com.intellij.ide.presentation.PresentationProvider;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.config.model.MUnitTest;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;


public class MUnitTestPresentationProvider extends PresentationProvider<MUnitTest> {

    @Nullable
    @Override
    public String getName(MUnitTest test) {
        return test.getName().getValue() != null ? "Test : " + test.getName().getValue() : "Test";
    }

    @Nullable
    @Override
    public String getTypeName(MUnitTest mUnitTest) {
        return "MUnitTest";
    }

    @Nullable
    @Override
    public Icon getIcon(MUnitTest test) {
        return MuleIcons.MUnitTest;
    }
}
