package org.mule.lang.dw.launcher.configuration.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.JavaCommandLineState;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.mule.lang.dw.launcher.configuration.WeaveConfiguration;
import org.mule.lang.dw.launcher.configuration.ui.WeaveInput;
import org.mule.lang.dw.util.WeaveSdk;

import java.io.File;
import java.util.List;

public class WeaveRunnerCommandLine extends JavaCommandLineState
{

    //Mule Main Class
    public static final String MAIN_CLASS = "com.mulesoft.weave.WeaveRunner";

    private final boolean isDebug;
    private WeaveConfiguration model;

    public WeaveRunnerCommandLine(@NotNull ExecutionEnvironment environment, WeaveConfiguration model)
    {
        super(environment);
        this.isDebug = DefaultDebugExecutor.EXECUTOR_ID.equals(environment.getExecutor().getId());
        this.model = model;
    }

    @Override
    protected JavaParameters createJavaParameters() throws ExecutionException
    {
        final JavaParameters javaParams = new JavaParameters();
        // Use the same JDK as the project
        final Project project = this.model.getProject();
        final ProjectRootManager manager = ProjectRootManager.getInstance(project);
        javaParams.setJdk(manager.getProjectSdk());
        // All modules to use the same things
        final Module[] modules = ModuleManager.getInstance(project).getModules();
        if (modules.length > 0)
        {
            for (Module module : modules)
            {
                javaParams.configureByModule(module, JavaParameters.JDK_AND_CLASSES);
            }
        }
        final String weaveHome = model.getWeaveHome();
        final List<File> urLs = WeaveSdk.getJars(weaveHome);
        for (File jar : urLs)
        {
            javaParams.getClassPath().add(jar);
        }
        //Mule main class
        javaParams.setMainClass(MAIN_CLASS);

        //Add default vm parameters
        javaParams.getVMParametersList().add("-Xms1024m");
        javaParams.getVMParametersList().add("-Xmx1024m");
        javaParams.getVMParametersList().add("-XX:PermSize=256m");
        javaParams.getVMParametersList().add("-XX:MaxPermSize=256m");
        javaParams.getVMParametersList().add("-XX:+HeapDumpOnOutOfMemoryError");
        javaParams.getVMParametersList().add("-XX:+AlwaysPreTouch");
        javaParams.getVMParametersList().add("-XX:NewSize=512m");
        javaParams.getVMParametersList().add("-XX:MaxNewSize=512m");
        javaParams.getVMParametersList().add("-XX:MaxTenuringThreshold=8");

        final List<WeaveInput> weaveInputs = model.getWeaveInputs();
        for (WeaveInput weaveInput : weaveInputs)
        {
            javaParams.getProgramParametersList().add("-input");
            javaParams.getProgramParametersList().add(weaveInput.getName());
            javaParams.getProgramParametersList().add(weaveInput.getPath());
        }

        if (isDebug)
        {
            javaParams.getVMParametersList().add("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005");
            javaParams.getProgramParametersList().add("-debug");
        }

        if (!StringUtils.isBlank(model.getWeaveOutput()))
        {
            javaParams.getProgramParametersList().add("-output", model.getWeaveOutput());
        }

        javaParams.getProgramParametersList().add(model.getWeaveFile());

        // All done, run it
        return javaParams;
    }

    public WeaveConfiguration getModel()
    {
        return model;
    }
}
