package org.mule.launcher.configuration.project;

import com.intellij.openapi.diagnostic.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by eberman on 3/2/16.
 */
public class MuleDeployProperties {

    public static final String MULE_DEPLOY_PROPERTIES_FILE_NAME = "mule-deploy.properties";
    public static final String MULE_DEPLOY_PROPERTIES_DIR = "src/main/app";

    static Logger logger = Logger.getInstance(MuleDeployProperties.class);

    public static void addConfigFile(String appPath, String configFile) {
        String deployPropertiesFilePath = appPath + "/" + MULE_DEPLOY_PROPERTIES_FILE_NAME;
        List<String> configFiles = new ArrayList<String>();
        try {
            Properties deployProperties = new Properties();
            deployProperties.load(new FileInputStream(deployPropertiesFilePath));
            String cfg = deployProperties.getProperty("config.resources");
            if (cfg != null && !"".equals(cfg.trim())) {
                String[] configs = cfg.trim().split(",");
                configFiles.addAll(Arrays.asList(configs));
            }
            if (!configFiles.contains(configFile)) {//Avoid duplicates
                configFiles.add(configFile);
                String configResourcesProperty = String.join(",", configFiles);
                deployProperties.setProperty("config.resources", configResourcesProperty);
                FileOutputStream out = new FileOutputStream(deployPropertiesFilePath);
                deployProperties.store(out, "Deployment properties are managed by the IntelliJ IDEA Mule Plugin; do not modify!");
            }
        } catch (IOException e) {
            logger.error("Unable to add config resource to deployment properties: ", e);
        }
    }

    public static void deleteConfigFile(String appPath, String configFile) {
        String deployPropertiesFilePath = appPath + "/" + MULE_DEPLOY_PROPERTIES_FILE_NAME;
        List<String> configFiles = new ArrayList<String>();
        try {
            Properties deployProperties = new Properties();
            deployProperties.load(new FileInputStream(deployPropertiesFilePath));
            String cfg = deployProperties.getProperty("config.resources");
            if (cfg != null && !"".equals(cfg.trim())) {
                String[] configs = cfg.trim().split(",");
                configFiles.addAll(Arrays.asList(configs));
            }
            configFiles.remove(configFile);
            String configResourcesProperty = String.join(",", configFiles);
            deployProperties.setProperty("config.resources", configResourcesProperty);
            FileOutputStream out = new FileOutputStream(deployPropertiesFilePath);
            deployProperties.store(out, "Deployment properties are managed by the IntelliJ IDEA Mule Plugin; do not modify!");
        } catch (IOException e) {
            logger.error("Unable to remove config resource from deployment properties: ", e);
        }
    }

}
