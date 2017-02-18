package org.mule.tooling.esb.launcher;


import com.intellij.execution.BeforeRunTaskProvider;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import com.intellij.util.concurrency.Semaphore;
import com.intellij.util.execution.ParametersListUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.maven.execution.MavenRunner;
import org.jetbrains.idea.maven.execution.MavenRunnerParameters;
import org.jetbrains.idea.maven.model.MavenExplicitProfiles;
import org.jetbrains.idea.maven.project.MavenProject;
import org.jetbrains.idea.maven.project.MavenProjectsManager;
import org.jetbrains.idea.maven.tasks.MavenBeforeRunTask;
import org.jetbrains.idea.maven.tasks.TasksBundle;
import org.mule.tooling.esb.launcher.configuration.MuleConfiguration;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public class MuleBeforeRunTasksProvider extends BeforeRunTaskProvider<MuleBeforeRunTask>
{
    public static final Key<MavenBeforeRunTask> ID = Key.create("Mule.BeforeRunTask");

    @Override
    public Key getId()
    {
        return ID;
    }

    @Override
    public Icon getIcon()
    {
        return MuleIcons.MuleIcon;
    }

    @Override
    public Icon getTaskIcon(MuleBeforeRunTask task) {
        return MuleIcons.MuleIcon;
    }

    @Override
    public String getName()
    {
        return "MuleApp Builder";
    }

    @Override
    public String getDescription(MuleBeforeRunTask beforeRunTask)
    {
        return "Build the Mule Application";
    }

    @Override
    public boolean isConfigurable()
    {
        return false;
    }

    @Nullable
    @Override
    public MuleBeforeRunTask createTask(RunConfiguration runConfiguration)
    {
        final MuleBeforeRunTask muleBeforeRunTask = new MuleBeforeRunTask(getId());
        muleBeforeRunTask.setEnabled(runConfiguration instanceof MuleConfiguration);
        return muleBeforeRunTask;
    }

    @Override
    public boolean configureTask(RunConfiguration runConfiguration, MuleBeforeRunTask beforeRunTask)
    {
        return runConfiguration instanceof MuleConfiguration;
    }

    @Override
    public boolean canExecuteTask(RunConfiguration runConfiguration, MuleBeforeRunTask beforeRunTask)
    {
        return runConfiguration instanceof MuleConfiguration;
    }

    @Override
    public boolean executeTask(DataContext dataContext, RunConfiguration runConfiguration, ExecutionEnvironment executionEnvironment, MuleBeforeRunTask muleBeforeRunTask)
    {
        final Semaphore targetDone = new Semaphore();
        final boolean[] result = new boolean[] {true};
        final Project project = executionEnvironment.getProject();
        final MavenProject mavenProject = getMavenProject(runConfiguration, project);
        try
        {
            ApplicationManager.getApplication().invokeAndWait(new Runnable()
            {
                public void run()
                {
                    if (!project.isDisposed() && mavenProject != null)
                    {
                        FileDocumentManager.getInstance().saveAllDocuments();
                        final MavenExplicitProfiles explicitProfiles = MavenProjectsManager.getInstance(project).getExplicitProfiles();
                        final MavenRunner mavenRunner = MavenRunner.getInstance(project);
                        targetDone.down();
                        (new Task.Backgroundable(project, TasksBundle.message("maven.tasks.executing"), true)
                        {
                            public void run(@NotNull ProgressIndicator indicator)
                            {
                                try
                                {
                                    MavenRunnerParameters params =
                                            new MavenRunnerParameters(true, mavenProject.getDirectory(), ParametersListUtil.parse("package"), explicitProfiles.getEnabledProfiles(),
                                                    explicitProfiles.getDisabledProfiles());
                                    result[0] = mavenRunner.runBatch(Collections.singletonList(params), null, null, TasksBundle.message("maven.tasks.executing"), indicator);
                                }
                                finally
                                {
                                    targetDone.up();
                                }
                            }

                            public boolean shouldStartInBackground()
                            {
                                return MavenRunner.getInstance(project).getSettings().isRunMavenInBackground();
                            }

                            public void processSentToBackground()
                            {
                                MavenRunner.getInstance(project).getSettings().setRunMavenInBackground(true);
                            }
                        }).queue();
                    }
                }
            }, ModalityState.NON_MODAL);
        }
        catch (Exception exeception)
        {
            return false;
        }
        targetDone.waitFor();
        return result[0];
    }

    private MavenProject getMavenProject(RunConfiguration runConfiguration, Project project)
    {
        final MavenProjectsManager instance = MavenProjectsManager.getInstance(project);
        final List<MavenProject> projects = instance.getProjects();
        MavenProject muleMavenProject = null;

        if (runConfiguration instanceof MuleConfiguration)
        {
            final String moduleName = ((MuleConfiguration) runConfiguration).getModuleName();
            if (moduleName != null)
            {
                for (MavenProject mavenProj : projects)
                {
                    if (moduleName.equals(mavenProj.getName()))
                    {
                        muleMavenProject = mavenProj;
                    }
                }
            }
        }
        if (muleMavenProject == null)
        {
            muleMavenProject = instance.getRootProjects().get(0);
        }
        return muleMavenProject;
    }


}
