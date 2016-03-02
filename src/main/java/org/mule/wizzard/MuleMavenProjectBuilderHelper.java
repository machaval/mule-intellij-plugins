package org.mule.wizzard;

import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.ide.util.EditorHelper;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.model.MavenConstants;
import org.jetbrains.idea.maven.model.MavenId;
import org.jetbrains.idea.maven.utils.MavenUtil;
import org.mule.templates.MuleFileTemplateDescriptorManager;

import java.io.IOException;
import java.util.Properties;

public class MuleMavenProjectBuilderHelper {

    public void configure(final Project project, final MavenId projectId, final String muleVersion, final VirtualFile root) {
        try {
            //Create mule folders.
            final VirtualFile appDirectory = VfsUtil.createDirectories(root.getPath() + "/src/main/app");
            final VirtualFile resources = VfsUtil.createDirectories(root.getPath() + "/src/main/resources");
            createLog4J(project, projectId, resources);
            final VirtualFile muleConfigFile = createMuleConfigFile(project, projectId, appDirectory);
            createMuleDeployPropertiesFile(project, projectId, appDirectory);
            createMuleAppPropertiesFiles(project, appDirectory);
            VfsUtil.createDirectories(root.getPath() + "/src/main/api");
            //MUnit support
            VfsUtil.createDirectories(root.getPath() + "/src/test/munit");
            VfsUtil.createDirectories(root.getPath() + "/src/test/resources");

            createPomFile(project, projectId, muleVersion, root);
            // execute when current dialog is closed (e.g. Project Structure)
            MavenUtil.invokeLater(project, ModalityState.NON_MODAL, new Runnable() {
                public void run() {
                    EditorHelper.openInEditor(getPsiFile(project, muleConfigFile));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createMuleAppPropertiesFiles(final Project project, final VirtualFile appDirectory) {
        new WriteCommandAction<VirtualFile>(project, "Create Mule Config File", PsiFile.EMPTY_ARRAY) {
            @Override
            protected void run(@NotNull Result<VirtualFile> result) throws Throwable {
                appDirectory.createChildData(this, "mule-app.properties");
            }
        }.execute();
    }

    private static PsiFile getPsiFile(Project project, VirtualFile pom) {
        return PsiManager.getInstance(project).findFile(pom);
    }

    private VirtualFile createMuleConfigFile(final Project project, final MavenId projectId, final VirtualFile appDirectory) {
        return new WriteCommandAction<VirtualFile>(project, "Create Mule Config File", PsiFile.EMPTY_ARRAY) {
            @Override
            protected void run(@NotNull Result<VirtualFile> result) throws Throwable {

                try {
                    VirtualFile configFile = appDirectory.findOrCreateChildData(this, projectId.getArtifactId() + ".xml");
                    final Properties templateProps = new Properties();
                    templateProps.setProperty("NAME", projectId.getArtifactId());
                    final FileTemplateManager manager = FileTemplateManager.getInstance(project);
                    final FileTemplate template = manager.getInternalTemplate(MuleFileTemplateDescriptorManager.MULE_CONFIGURATION_FILE);
                    final Properties defaultProperties = manager.getDefaultProperties();
                    defaultProperties.putAll(templateProps);
                    final String text = template.getText(defaultProperties);
                    VfsUtil.saveText(configFile, text);
                    result.setResult(configFile);
                } catch (IOException e) {
                    showError(project, e);
                }
            }
        }.execute().getResultObject();
    }

    private VirtualFile createLog4J(final Project project, final MavenId projectId, final VirtualFile appDirectory) {
        return new WriteCommandAction<VirtualFile>(project, "Create Mule Deploy Properties File", PsiFile.EMPTY_ARRAY) {
            @Override
            protected void run(@NotNull Result<VirtualFile> result) throws Throwable {

                try {
                    VirtualFile configFile = appDirectory.findOrCreateChildData(this, "log4j2.xml");
                    final Properties templateProps = new Properties();
                    templateProps.setProperty("FILE_NAME", "${sys:mule.home}${sys:file.separator}logs${sys:file.separator}" + projectId.getArtifactId().toLowerCase() + ".log");
                    templateProps.setProperty("FILE_PATTERN", "${sys:mule.home}${sys:file.separator}logs${sys:file.separator}" + projectId.getArtifactId().toLowerCase() + "-%i.log");
                    final FileTemplateManager manager = FileTemplateManager.getInstance(project);
                    final FileTemplate template = manager.getInternalTemplate(MuleFileTemplateDescriptorManager.LOG4J2);
                    final Properties defaultProperties = manager.getDefaultProperties();
                    defaultProperties.putAll(templateProps);
                    final String text = template.getText(defaultProperties);
                    VfsUtil.saveText(configFile, text);
                    result.setResult(configFile);
                } catch (IOException e) {
                    showError(project, e);
                }
            }
        }.execute().getResultObject();
    }

    private VirtualFile createMuleDeployPropertiesFile(final Project project, final MavenId projectId, final VirtualFile appDirectory) {
        return new WriteCommandAction<VirtualFile>(project, "Create Mule Deploy Properties File", PsiFile.EMPTY_ARRAY) {
            @Override
            protected void run(@NotNull Result<VirtualFile> result) throws Throwable {

                try {
                    VirtualFile configFile = appDirectory.findOrCreateChildData(this, "mule-deploy.properties");
                    final Properties templateProps = new Properties();
                    templateProps.setProperty("NAME", projectId.getArtifactId());
                    final FileTemplateManager manager = FileTemplateManager.getInstance(project);
                    final FileTemplate template = manager.getInternalTemplate(MuleFileTemplateDescriptorManager.MULE_DEPLOY_PROPERTIES);
                    final Properties defaultProperties = manager.getDefaultProperties();
                    defaultProperties.putAll(templateProps);
                    final String text = template.getText(defaultProperties);
                    VfsUtil.saveText(configFile, text);
                    result.setResult(configFile);
                } catch (IOException e) {
                    showError(project, e);
                }
            }
        }.execute().getResultObject();
    }

    private static void showError(Project project, Throwable e) {
        MavenUtil.showError(project, "Failed to create a Mule project", e);
    }

    private VirtualFile createPomFile(final Project project, final MavenId projectId, final String muleVersion, final VirtualFile root) {
        return new WriteCommandAction<VirtualFile>(project, "Create Mule Project", PsiFile.EMPTY_ARRAY) {
            @Override
            protected void run(@NotNull Result<VirtualFile> result) throws Throwable {

                try {
                    VirtualFile pomFile = root.findOrCreateChildData(this, MavenConstants.POM_XML);
                    final Properties templateProps = new Properties();
                    templateProps.setProperty("GROUP_ID", projectId.getGroupId());
                    templateProps.setProperty("ARTIFACT_ID", projectId.getArtifactId());
                    templateProps.setProperty("VERSION", projectId.getVersion());
                    templateProps.setProperty("MULE_VERSION", muleVersion);
                    final FileTemplateManager manager = FileTemplateManager.getInstance(project);
                    final FileTemplate template = manager.getInternalTemplate(MuleFileTemplateDescriptorManager.MULE_MAVEN_PROJECT);
                    final Properties defaultProperties = manager.getDefaultProperties();
                    defaultProperties.putAll(templateProps);
                    final String text = template.getText(defaultProperties);
                    VfsUtil.saveText(pomFile, text);
                    result.setResult(pomFile);
                } catch (IOException e) {
                    showError(project, e);
                }
            }
        }.execute().getResultObject();
    }
}
