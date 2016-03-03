package org.mule.lanucher.configuration.archive;


import com.intellij.execution.ExecutionException;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.project.MavenProjectsManager;

import java.io.File;

public class MuleAppManager extends AbstractProjectComponent {

    private MuleDeployProperties deployProperties;
    Logger log = Logger.getInstance(MuleAppManager.class);

    protected MuleAppManager(Project project) {
        super(project);
        deployProperties = new MuleDeployProperties(project.getBasePath());
    }

    @NotNull
    public File getMuleApp(Module module) throws ExecutionException {
        final MavenProjectsManager instance = MavenProjectsManager.getInstance(module.getProject());
        if (instance.hasProjects()) {
            return new MuleAppMavenHandler().getMuleApp(module);
        }
        throw new ExecutionException("Unable to find application builder");
    }

    public MuleDeployProperties getDeployProperties() {
        return deployProperties;
    }

    public static MuleAppManager getInstance(Project p) {
        return p.getComponent(MuleAppManager.class);
    }
}
