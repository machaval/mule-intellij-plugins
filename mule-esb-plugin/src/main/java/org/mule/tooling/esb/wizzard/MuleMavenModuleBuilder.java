package org.mule.tooling.esb.wizzard;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.SourcePathsBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;
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
import org.jetbrains.idea.maven.model.MavenId;
import org.jetbrains.idea.maven.utils.MavenUtil;
import org.jetbrains.idea.maven.wizards.MavenModuleBuilder;
import org.mule.tooling.esb.util.MuleIcons;

import javax.swing.*;
import java.io.File;

public class MuleMavenModuleBuilder extends MavenModuleBuilder implements SourcePathsBuilder {

    public static final String DEFAULT_MULE_VERSION = "3.8.0";
    private String muleVersion = DEFAULT_MULE_VERSION;

    public MuleMavenModuleBuilder() {
        setProjectId(new MavenId("org.mule.app", "my-app", "1.0.0-SNAPSHOT"));
    }

    @Override
    public void setupRootModel(ModifiableRootModel rootModel) throws ConfigurationException {
        super.setupRootModel(rootModel);
        final Project project = rootModel.getProject();
        final VirtualFile root = createAndGetContentEntry();
        rootModel.addContentEntry(root);
        MavenUtil.runWhenInitialized(project, (DumbAwareRunnable) () -> new MuleMavenProjectBuilderHelper().configure(project, getProjectId(), muleVersion, root));
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

    @Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        MuleVersionConfiguration step = new MuleVersionConfiguration(this, muleVersion);
        Disposer.register(parentDisposable, step);
        return step;
    }

    public void setMuleVersion(String muleVersion) {
        this.muleVersion = muleVersion;
    }

}
