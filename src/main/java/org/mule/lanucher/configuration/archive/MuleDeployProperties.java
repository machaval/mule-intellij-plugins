package org.mule.lanucher.configuration.archive;

import com.intellij.openapi.diagnostic.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by eberman on 3/2/16.
 */
public class MuleDeployProperties {

    private static final String MULE_DEPLOY_PROPERTIES = "src/main/app/mule-deploy.properties";

    Logger log = Logger.getInstance(MuleDeployProperties.class);

    Properties deployProperties = new Properties();
    String deployPropertiesFilePath;
    List<String> configFiles = new ArrayList<String>();

    public MuleDeployProperties(String baseDir) {
        deployPropertiesFilePath = baseDir + "/" + MULE_DEPLOY_PROPERTIES;
        try {
            deployProperties.load(new FileInputStream(deployPropertiesFilePath));
            String cfg = deployProperties.getProperty("config.resources");
            if (cfg != null && !"".equals(cfg.trim())) {
                String[] configs = cfg.trim().split(",");
                configFiles.addAll(Arrays.asList(configs));
            }
        } catch (IOException e) {
            log.warn("Deployment properties file not found: " + deployPropertiesFilePath);
            createNewDeployProperties(deployPropertiesFilePath);
        }
    }

    public void addConfigFile(String configFile) {
        configFiles.add(configFile);
        updatePropertiesFile();
    }

    public void deleteConfigFile(String configFile) {
        configFiles.remove(configFile);
        updatePropertiesFile();
    }

    private void createNewDeployProperties(String deployPropertiesFile) {
        log.info("Creating new deployment properties file: " + deployPropertiesFile);
        try {
            PrintWriter writer = new PrintWriter(deployPropertiesFile);
            writer.println("redeployment.enabled=true");
            writer.println("encoding=UTF-8");
            writer.println("domain=default");
            writer.println("config.resources=");
            writer.close();
        } catch (Exception e) {
            log.warn("Unable to create new deployment properties file: ", e );
        }
    }

    private void updatePropertiesFile() {
        try {
            String configResourcesProperty = String.join(",", configFiles);
            deployProperties.setProperty("config.resources", configResourcesProperty);
            FileOutputStream out = new FileOutputStream(deployPropertiesFilePath);
            deployProperties.store(out, "Deployment properties are managed by the IntelliJ IDEA Mule Plugin; do not modify!");
        } catch (Exception e) {
            log.warn("Unable to update properties: ", e);
        }
    }
}
