package org.mule.config.model.presentation;

import com.intellij.ide.presentation.PresentationProvider;
import org.jetbrains.annotations.Nullable;
import org.mule.config.model.Flow;
import org.mule.config.model.MUnitTest;
import org.mule.util.MuleIcons;

import javax.swing.*;


public class MUnitTestPresentationProvider extends PresentationProvider<MUnitTest> {

    @Nullable
    @Override
    public String getName(MUnitTest test) {
        return test.getName().getValue() != null ? "Test : " + test.getName().getValue() : "Test";
    }

    @Nullable
    @Override
    public Icon getIcon(MUnitTest test) {
        return MuleIcons.MUnitTest;
    }
}
