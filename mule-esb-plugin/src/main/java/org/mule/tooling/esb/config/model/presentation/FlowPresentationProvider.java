package org.mule.tooling.esb.config.model.presentation;

import com.intellij.ide.presentation.PresentationProvider;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.config.model.Flow;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;


public class FlowPresentationProvider extends PresentationProvider<Flow> {

    @Nullable
    @Override
    public String getName(Flow flow) {
        return flow.getName().getValue() != null ? "Flow : " + flow.getName().getValue() : "Flow";
    }

    @Nullable
    @Override
    public Icon getIcon(Flow flow) {
        return MuleIcons.MuleFlow;
    }
}
