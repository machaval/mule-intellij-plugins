package org.mule.tooling.esb.toolwindow;

import com.intellij.facet.FacetManager;
import com.intellij.facet.ProjectFacetManager;
import com.intellij.framework.detection.DetectedFrameworkDescription;
import com.intellij.framework.detection.impl.FrameworkDetectionManager;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportProvider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.Condition;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.framework.MuleFrameworkSupportProvider;
import org.mule.tooling.esb.framework.facet.MuleFacet;
import org.mule.tooling.esb.framework.facet.MuleFacetType;
import org.mule.tooling.esb.sdk.MuleSdk;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.util.List;

/**
 * Created by eberman on 3/26/17.
 */
public class GlobalConfigsToolWindowFactory implements ToolWindowFactory, Condition<Project> {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

    }

    @Override
    public void init(ToolWindow window) {

    }

    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return MuleConfigUtils.isMuleProject(project);
    }

    @Override
    public boolean isDoNotActivateOnStart() {
        return false;
    }

    @Override
    public boolean value(Project project) {
        return shouldBeAvailable(project);
    }
}
