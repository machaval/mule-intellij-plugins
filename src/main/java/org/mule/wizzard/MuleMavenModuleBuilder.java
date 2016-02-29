package org.mule.wizzard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.SourcePathsBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.ide.wizard.StepAdapter;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.DumbAwareRunnable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.maven.utils.MavenUtil;
import org.jetbrains.idea.maven.wizards.MavenArchetypesStep;
import org.jetbrains.idea.maven.wizards.MavenModuleBuilder;
import org.mule.util.MuleIcons;

import javax.swing.*;
import java.io.File;

public class MuleMavenModuleBuilder extends MavenModuleBuilder implements SourcePathsBuilder {


    @Override
    public void setupRootModel(ModifiableRootModel rootModel) throws ConfigurationException {
        super.setupRootModel(rootModel);

        final Project project = rootModel.getProject();
        final VirtualFile root = createAndGetContentEntry();
        rootModel.addContentEntry(root);
        MavenUtil.runWhenInitialized(project, new DumbAwareRunnable() {
            public void run() {
                new MuleMavenProjectBuilderHelper().configure(project, getProjectId(), "3.8.0-SNAPSHOT", root);
            }
        });
    }

    private VirtualFile createAndGetContentEntry() {
        String path = FileUtil.toSystemIndependentName(this.getContentEntryPath());
        (new File(path)).mkdirs();
        return LocalFileSystem.getInstance().refreshAndFindFileByPath(path);
    }

    @Override
    public String getName() {
        return "Mule Maven";
    }

    @Override
    public String getBuilderId() {
        return getClass().getName();
    }


    @Override
    public String getPresentableName() {
        return "Mule Maven";
    }

    @Override
    public Icon getNodeIcon() {
        return MuleIcons.MuleIcon;
    }

    @Override
    public String getDescription() {
        return "Create a Mule ESB Maven Based Project. Maven modules are used for developing <b>JVM-based</b> applications with dependencies managed by <b>Maven</b>. ";
    }
}
