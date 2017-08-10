package org.mule.tooling.esb.launcher.configuration;


import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.RunConfigurationWithSuppressedDefaultRunAction;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.ModuleListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizerUtil;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.launcher.configuration.runner.MuleRemoteDebuggerState;
import org.mule.tooling.esb.launcher.configuration.ui.MuleRemoteRunnerEditor;
import org.mule.tooling.esb.util.MuleConfigUtils;

import java.util.*;

public class MuleRemoteConfiguration extends LocatableConfigurationBase implements RunConfigurationWithSuppressedDefaultRunAction, RemoteRunProfile {

    public static final String PORT_PROP_NAME = "mule.remote.port";
    public static final String HOST_PROP_NAME = "mule.remote.host";
    public static final String ISCUSTOMMAP_PROP_NAME = "mule.is.custom.map";
    public static final String MODULE_NAME_PREFIX = "mule.module.";

    private int port = 6666;
    private String host = "localhost";
    private boolean isCustomAppsMap = false;

    private Map<String, String> modulesToAppsMap = new HashMap<>();

    protected MuleRemoteConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
        return new MuleRemoteDebuggerState(host, port);
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException {
        super.readExternal(element);
        try {
            this.port = Integer.parseInt(JDOMExternalizerUtil.readField(element, PORT_PROP_NAME, "6666"));
        } catch (Exception e) {
            //Ignore bad ports
        }
        this.host = JDOMExternalizerUtil.readField(element, HOST_PROP_NAME, "localhost");
        this.isCustomAppsMap = Boolean.parseBoolean(JDOMExternalizerUtil.readField(element, ISCUSTOMMAP_PROP_NAME, "false"));

        this.modulesToAppsMap = new HashMap<>();
        for (Module module : MuleConfigUtils.getMuleModules(this.getProject(), false)) {
            String appName = JDOMExternalizerUtil.readField(element, MODULE_NAME_PREFIX + module.getName(), "");
            this.modulesToAppsMap.put(module.getName(), appName);
        }

    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException {
        super.writeExternal(element);
        // Stores the values of this class into the parent
        JDOMExternalizerUtil.writeField(element, HOST_PROP_NAME, this.host);
        JDOMExternalizerUtil.writeField(element, PORT_PROP_NAME, String.valueOf(this.port));
        JDOMExternalizerUtil.writeField(element, ISCUSTOMMAP_PROP_NAME, String.valueOf(isCustomAppsMap));

        if (modulesToAppsMap != null) {
            for (String moduleName : modulesToAppsMap.keySet()) {
                JDOMExternalizerUtil.writeField(element, MODULE_NAME_PREFIX + moduleName, modulesToAppsMap.get(moduleName));
            }
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isCustomAppsMap() {
        return isCustomAppsMap;
    }

    public void setCustomAppsMap(boolean customAppsMap) {
        isCustomAppsMap = customAppsMap;
    }

    public Map<String, String> getModulesToAppsMap() {
        List<Module> modules = MuleConfigUtils.getMuleModules(this.getProject(), false);
        List<String> moduleNames = new ArrayList<>();
        for (Module m : modules) {
            String nextName = m.getName();
            moduleNames.add(nextName);
            if (!modulesToAppsMap.containsKey(nextName))
                modulesToAppsMap.put(nextName, "");
        }
        List<String> modulesToRemove = new ArrayList<>();
        for (String moduleName : modulesToAppsMap.keySet()) {
            if (!moduleNames.contains(moduleName))
                modulesToRemove.add(moduleName);
        }
        for (String moduleName : modulesToRemove) {
            modulesToAppsMap.remove(moduleName);
        }
        return modulesToAppsMap;
    }

    public void setModulesToAppsMap(Map<String, String> modulesToAppsMap) {
        this.modulesToAppsMap = modulesToAppsMap;
    }

    @Nullable
    @Override
    public String suggestedName() {
        return "Remote Mule Debugger Configuration";
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new MuleRemoteRunnerEditor();
    }

}
