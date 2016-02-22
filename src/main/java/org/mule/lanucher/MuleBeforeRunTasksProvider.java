package org.mule.lanucher;


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
import org.mule.lanucher.configuration.MuleConfiguration;
import org.mule.util.MuleIcons;

import javax.swing.*;
import java.util.Collections;

public class MuleBeforeRunTasksProvider extends BeforeRunTaskProvider<MuleBeforeRunTask> {

    public static final Key<MavenBeforeRunTask> ID = Key.create("Mule.BeforeRunTask");

    @Override
    public Key getId() {
        return ID;
    }

    @Override
    public Icon getIcon() {
        return MuleIcons.MuleIcon;
    }

    @Override
    public String getName() {
        return "Mule App Archiver";
    }

    @Override
    public String getDescription(MuleBeforeRunTask beforeRunTask) {
        return "Mule App Archiver";
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Nullable
    @Override
    public MuleBeforeRunTask createTask(RunConfiguration runConfiguration) {
        return new MuleBeforeRunTask(getId());
    }

    @Override
    public boolean configureTask(RunConfiguration runConfiguration, MuleBeforeRunTask beforeRunTask) {
        return false;
    }

    @Override
    public boolean canExecuteTask(RunConfiguration runConfiguration, MuleBeforeRunTask beforeRunTask) {
        return runConfiguration instanceof MuleConfiguration;
    }

    @Override
    public boolean executeTask(DataContext dataContext, RunConfiguration runConfiguration, ExecutionEnvironment executionEnvironment, MuleBeforeRunTask muleBeforeRunTask) {
        final Semaphore targetDone = new Semaphore();
        final boolean[] result = new boolean[]{true};
        final Project project = executionEnvironment.getProject();
        final MavenProjectsManager instance = MavenProjectsManager.getInstance(project);
        final MavenProject mavenProject = instance.getProjects().get(0);

        try {
            ApplicationManager.getApplication().invokeAndWait(new Runnable() {
                public void run() {
                    if (!project.isDisposed() && mavenProject != null) {
                        FileDocumentManager.getInstance().saveAllDocuments();
                        final MavenExplicitProfiles explicitProfiles = MavenProjectsManager.getInstance(project).getExplicitProfiles();
                        final MavenRunner mavenRunner = MavenRunner.getInstance(project);
                        targetDone.down();
                        (new Task.Backgroundable(project, TasksBundle.message("maven.tasks.executing"), true) {
                            public void run(@NotNull ProgressIndicator indicator) {
                                try {
                                    MavenRunnerParameters params = new MavenRunnerParameters(true, mavenProject.getDirectory(), ParametersListUtil.parse("package"), explicitProfiles.getEnabledProfiles(), explicitProfiles.getDisabledProfiles());
                                    result[0] = mavenRunner.runBatch(Collections.singletonList(params), null, null, TasksBundle.message("maven.tasks.executing"), indicator);
                                } finally {
                                    targetDone.up();
                                }
                            }

                            public boolean shouldStartInBackground() {
                                return MavenRunner.getInstance(project).getSettings().isRunMavenInBackground();
                            }

                            public void processSentToBackground() {
                                MavenRunner.getInstance(project).getSettings().setRunMavenInBackground(true);
                            }
                        }).queue();
                    }
                }
            }, ModalityState.NON_MODAL);
        } catch (Exception exeception) {
            return false;
        }
        targetDone.waitFor();
        return result[0];
    }


}
