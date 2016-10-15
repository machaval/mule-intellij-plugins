package org.mule.tooling.esb.actions;

import com.intellij.icons.AllIcons;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.io.IOUtils;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.mule.soapkit.common.utils.WsdlUtils;
import org.mule.soapkit.xml.generator.Scaffolder;
import org.mule.soapkit.xml.generator.model.buildables.SoapkitApiConfig;
import org.mule.soapkit.xml.generator.parsers.SoapkitMuleConfigParser;
import org.mule.tooling.esb.launcher.configuration.project.MuleDeployProperties;
import org.mule.tooling.esb.soapkit.ui.SoapKitDialog;

import javax.wsdl.Definition;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;

public class SOAPKitScaffoldingAction extends AnAction
{
    private static final Scaffolder SCAFFOLDER = Scaffolder.getInstance();

    final static Logger logger = Logger.getInstance(SOAPKitScaffoldingAction.class);

    public SOAPKitScaffoldingAction()
    {
        super("Generate Flows", "Generate APIKit for SOAP scaffolding from the WSDL definition", AllIcons.FileTypes.WsdlFile);
        //logger.setLevel(Level.DEBUG);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {

        final VirtualFile selectedWsdlFile = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final Project project = anActionEvent.getProject();

        final VirtualFile moduleContentRoot = ProjectRootManager.getInstance(project).getFileIndex().getContentRootForFile(selectedWsdlFile);
        String appPath = moduleContentRoot.getPath() + "/src/main/app";

        logger.debug("*** APP PATH IS " + appPath);

        String wsdlPath = selectedWsdlFile.getPath();

        logger.debug("*** WSDL PATH IS " + wsdlPath);

        Definition wsdlDefinition = WsdlUtils.parseWSDL(wsdlPath);

        String service = "";
        String port = "";
        String muleXml = null;

        List<String> configFiles = MuleDeployProperties.getConfigFileNames(appPath);

        final SoapKitDialog form = new SoapKitDialog(wsdlDefinition, configFiles);
        form.show();
        boolean isOk = form.getExitCode() == DialogWrapper.OK_EXIT_CODE;

        if (!isOk)
            return;

        service = form.getService().getSelectedItem().toString();
        port = form.getPort().getSelectedItem().toString();
        muleXml = form.getConfigFile().getSelectedItem().toString();

        System.out.println("*** SERVICE " + service);
        System.out.println("*** PORT " + port);
        System.out.println("*** muleXml " + muleXml);
        System.out.println("*** wsdlPath " + wsdlPath);

        File muleXmlFile = null;
        if (SoapKitDialog.NEW_FILE.equals(muleXml)) {
            int i = 0;

            do {
                muleXml = selectedWsdlFile.getNameWithoutExtension() + (i > 0 ? "-" + i : "") + ".xml";
                muleXmlFile = new File(appPath, muleXml);
                i++;
            } while (muleXmlFile.exists());
        } else {
            muleXmlFile = new File(appPath, muleXml);
        }

        logger.debug("Mule XML file absolute path is " + muleXmlFile.getAbsolutePath());

        SoapkitApiConfig soapkitConfig = findSoapkitConfig(muleXmlFile);

        Element resultElement = null;
        if (soapkitConfig == null || !(service.equals(soapkitConfig.getService()) && port.equals(soapkitConfig.getPort()))) {
            //TODO: The second wsdlPath / wsdlLocationAttribute - what is it?
            //TODO - Domains are not supported yet!
            resultElement = SCAFFOLDER.scaffold(wsdlPath, wsdlPath, service, port, "");
        } else {
            resultElement = SCAFFOLDER.scaffold(muleXmlFile, wsdlPath, soapkitConfig, "");
        }
        writeMuleXmlFile(resultElement, muleXmlFile);

        moduleContentRoot.refresh(false, true);
    }

    @Override
    public void update(AnActionEvent anActionEvent)
    {
        final VirtualFile file = CommonDataKeys.VIRTUAL_FILE.getData(anActionEvent.getDataContext());
        final boolean isWSDL;
        if (file != null)
        {
            isWSDL = "wsdl".equalsIgnoreCase(file.getExtension());
            anActionEvent.getPresentation().setEnabled(isWSDL);
            anActionEvent.getPresentation().setVisible(isWSDL);
        }

    }

    private SoapkitApiConfig findSoapkitConfig(File muleConfig) {
        SoapkitApiConfig soapkitApiConfig = null;
        if (muleConfig.exists()) {
            try (InputStream contents = new FileInputStream(muleConfig)) {
                List<SoapkitApiConfig> soapkitConfigs = new SoapkitMuleConfigParser(contents).soapkitConfigs();
                if (!soapkitConfigs.isEmpty()) {
                    soapkitApiConfig = soapkitConfigs.get(0);
                }
            } catch (Exception e) {
                logger.error("Problem parsing config file: " + muleConfig.getAbsolutePath(), e);
            }
        }
        return soapkitApiConfig;
    }

    private static void writeMuleXmlFile(Element element, File muleConfig) {
        XMLOutputter xout = new XMLOutputter(Format.getPrettyFormat());
        InputStream inputStream = null;
        try {
            String outputString = xout.outputString(element);
            System.out.println("*** OUTPUT STRING IS " + outputString);
            FileWriter writer = new FileWriter(muleConfig, false);
            writer.write(outputString);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            logger.error("Unable to write file: " + e);
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

}
