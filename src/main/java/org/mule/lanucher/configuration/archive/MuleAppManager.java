package org.mule.lanucher.configuration.archive;


import com.intellij.execution.ExecutionException;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.project.MavenProjectsManager;

import java.io.File;

public class MuleAppManager extends AbstractProjectComponent {

    protected MuleAppManager(Project project) {
        super(project);
    }

    @NotNull
    public File getMuleApp(Module module) throws ExecutionException {
        final MavenProjectsManager instance = MavenProjectsManager.getInstance(module.getProject());
        if (instance.hasProjects()) {
            return new MuleAppMavenHandler().getMuleApp(module);
        }
        throw new ExecutionException("Unable to find application builder");
    }


    public static MuleAppManager getInstance(Project p) {
        return p.getComponent(MuleAppManager.class);
    }
}
