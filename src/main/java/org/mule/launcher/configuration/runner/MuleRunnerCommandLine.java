package org.mule.launcher.configuration.runner;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.JavaCommandLineState;
import com.intellij.execution.configurations.JavaParameters;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.util.io.FileUtil;
import org.codehaus.plexus.util.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.mule.launcher.configuration.MuleConfiguration;
import org.mule.launcher.configuration.archive.MuleAppManager;
import org.mule.sdk.MuleClassPath;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MuleRunnerCommandLine extends JavaCommandLineState implements MuleRunner {

    //Mule Main Class
    public static final String MAIN_CLASS = "org.mule.module.launcher.MuleContainer";

    private MuleConfiguration model;

    private final boolean isDebug;

    public MuleRunnerCommandLine(@NotNull ExecutionEnvironment environment, @NotNull MuleConfiguration model) {
        super(environment);
        this.model = model;
        this.isDebug = DefaultDebugExecutor.EXECUTOR_ID.equals(environment.getExecutor().getId());
    }

    @Override
    public JavaParameters createJavaParameters() throws ExecutionException {
        JavaParameters javaParams = new JavaParameters();
        // Use the same JDK as the project
        Project project = this.model.getProject();
        ProjectRootManager manager = ProjectRootManager.getInstance(project);
        javaParams.setJdk(manager.getProjectSdk());
        // All modules to use the same things
        Module[] modules = ModuleManager.getInstance(project).getModules();
        if (modules.length > 0) {
            for (Module module : modules) {
                javaParams.configureByModule(module, JavaParameters.JDK_AND_CLASSES);
            }
        }

        final String muleHome = model.getMuleHome();
        final MuleClassPath muleClassPath = new MuleClassPath(new File(muleHome));
        final List<File> urLs = muleClassPath.getJars();
        for (File jar : urLs) {
            javaParams.getClassPath().add(jar);
        }
        //EE license location 
        javaParams.getClassPath().add(muleHome + "/conf");
        
        //Mule main class
        javaParams.setMainClass(MAIN_CLASS);

        //Add default vm parameters
        javaParams.getVMParametersList().add("-Dmule.home=" + muleHome);
        javaParams.getVMParametersList().add("-Dmule.base=" + muleHome);
        javaParams.getVMParametersList().add("-Djava.net.preferIPv4Stack=TRUE ");
        javaParams.getVMParametersList().add("-Dmvel2.disable.jit=TRUE");
        javaParams.getVMParametersList().add("-Dorg.glassfish.grizzly.nio.transport.TCPNIOTransport.max-receive-buffer-size=1048576");
        javaParams.getVMParametersList().add("-Dorg.glassfish.grizzly.nio.transport.TCPNIOTransport.max-send-buffer-size=1048576");
        javaParams.getVMParametersList().add("-Djava.endorsed.dirs=" + muleHome + "/lib/endorsed ");
        javaParams.getVMParametersList().add("-Djava.util.logging.manager=org.apache.logging.log4j.jul.LogManager");
        javaParams.getVMParametersList().add("-Dmule.forceConsoleLog=true");

        if (isDebug) {
            javaParams.getVMParametersList().add("-Dmule.debug.enable=true");
            javaParams.getVMParametersList().add("-Dmule.debug.suspend=true");
        }

        javaParams.getVMParametersList().add("-Xms1024m");
        javaParams.getVMParametersList().add("-Xmx1024m");
        javaParams.getVMParametersList().add("-XX:PermSize=256m");
        javaParams.getVMParametersList().add("-XX:MaxPermSize=256m");
        javaParams.getVMParametersList().add("-XX:+HeapDumpOnOutOfMemoryError");
        javaParams.getVMParametersList().add("-XX:+AlwaysPreTouch");
        javaParams.getVMParametersList().add("-XX:NewSize=512m");
        javaParams.getVMParametersList().add("-XX:MaxNewSize=512m");
        javaParams.getVMParametersList().add("-XX:MaxTenuringThreshold=8");


        // VM Args
        String vmArgs = this.getVmArgs();
        if (vmArgs != null) {
            javaParams.getVMParametersList().addParametersString(vmArgs);
        }

        // All done, run it
        return javaParams;
    }

    @Override
    protected boolean ansiColoringEnabled() {
        return true;
    }

    @NotNull
    @Override
    protected OSProcessHandler startProcess() throws ExecutionException {
        deployApp();
        return super.startProcess();
    }

    private void deployApp() throws ExecutionException {
        //Get the zip and deploy it
        final File file = MuleAppManager.getInstance(model.getProject()).getMuleApp(model.getModule());
        final String muleHome = model.getMuleHome();
        final File apps = new File(muleHome, "apps");
        try {
            FileUtils.cleanDirectory(apps);
            FileUtil.copy(file, new File(apps, model.getProject().getName() + ".zip"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the "VM Args" parameter
     *
     * @return String
     */
    protected String getVmArgs() {
        String vmArgs = model.getVmArgs();
        return vmArgs != null && !vmArgs.isEmpty() ? vmArgs : null;
    }


    @Override
    public String getHost() {
        return "localhost";
    }

    @Override
    public int getPort() {
        return 6666;
    }
}
