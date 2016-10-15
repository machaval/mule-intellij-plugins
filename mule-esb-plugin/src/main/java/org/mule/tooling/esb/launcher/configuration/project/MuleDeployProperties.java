package org.mule.tooling.esb.launcher.configuration.project;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.text.StringUtil;

import java.io.*;
import java.util.*;


public class MuleDeployProperties
{

    public static final String MULE_DEPLOY_PROPERTIES_FILE_NAME = "mule-deploy.properties";
    public static final String MULE_DEPLOY_PROPERTIES_DIR = "src/main/app";

    static Logger logger = Logger.getInstance(MuleDeployProperties.class);

    public static void addConfigFile(String appPath, String configFile)
    {
        final String deployPropertiesFilePath = appPath + "/" + MULE_DEPLOY_PROPERTIES_FILE_NAME;
        final List<String> configFiles = new ArrayList<String>();
        try
        {
            if (new File(deployPropertiesFilePath).exists())
            {
                final Properties deployProperties = new Properties();
                deployProperties.load(new FileInputStream(deployPropertiesFilePath));
                String cfg = deployProperties.getProperty("config.resources");
                if (cfg != null && !"".equals(cfg.trim()))
                {
                    String[] configs = cfg.trim().split(",");
                    configFiles.addAll(Arrays.asList(configs));
                }
                if (!configFiles.contains(configFile))
                {//Avoid duplicates
                    configFiles.add(configFile);
                    final String configResourcesProperty = StringUtil.join(configFiles, ",");
                    deployProperties.setProperty("config.resources", configResourcesProperty);
                    final FileOutputStream out = new FileOutputStream(deployPropertiesFilePath);
                    deployProperties.store(out, "Deployment properties are managed by the IntelliJ IDEA Mule Plugin; do not modify!");
                }
            }
        }
        catch (IOException e)
        {
            logger.error("Unable to add config resource to deployment properties: ", e);
        }
    }

    public static List<String> getConfigFileNames(String appPath) {
        List<String> configFileNames = new ArrayList<String>();

        final String deployPropertiesFilePath = appPath + "/" + MULE_DEPLOY_PROPERTIES_FILE_NAME;

        logger.debug("*** DEPLOY PROPS PATH " + deployPropertiesFilePath);

        try {
            if (new File(deployPropertiesFilePath).exists()) {
                final Properties deployProperties = new Properties();
                deployProperties.load(new FileInputStream(deployPropertiesFilePath));
                String cfg = deployProperties.getProperty("config.resources");

                logger.debug("*** GOT CONFIG RESOURCES " + cfg);

                if (cfg != null && !"".equals(cfg.trim())) {
                    String[] configs = cfg.trim().split(",");
                    configFileNames.addAll(Arrays.asList(configs));
                }
            }
        } catch (IOException e) {
            logger.error("Unable to get config names", e);
        }
        return configFileNames;
    }

    public static void deleteConfigFile(String appPath, String configFile)
    {
        final String deployPropertiesFilePath = appPath + "/" + MULE_DEPLOY_PROPERTIES_FILE_NAME;
        final List<String> configFiles = new ArrayList<String>();
        try
        {
            final Properties deployProperties = new Properties();
            deployProperties.load(new FileInputStream(deployPropertiesFilePath));
            final String cfg = deployProperties.getProperty("config.resources");

            if (cfg != null && !"".equals(cfg.trim()))
            {
                String[] configs = cfg.trim().split(",");
                configFiles.addAll(Arrays.asList(configs));
            }
            configFiles.remove(configFile);
            final String configResourcesProperty = StringUtil.join(configFiles, ",");
            deployProperties.setProperty("config.resources", configResourcesProperty);
            final FileOutputStream out = new FileOutputStream(deployPropertiesFilePath);
            deployProperties.store(out, "Deployment properties are managed by the IntelliJ IDEA Mule Plugin; do not modify!");
        }
        catch (IOException e)
        {
            logger.error("Unable to remove config resource from deployment properties: ", e);
        }
    }

}
