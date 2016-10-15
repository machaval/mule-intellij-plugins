package org.mule.tooling.esb.soapkit.ui;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import org.mule.tooling.esb.launcher.configuration.project.MuleDeployProperties;

import javax.swing.*;
import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.xml.namespace.QName;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by eberman on 10/14/16.
 */
public class SoapKitDialog extends DialogWrapper {
    private JPanel root;
    private JComboBox port;
    private JComboBox configFile;
    private JComboBox service;

    Definition wsdlDefinition;

    public static String NEW_FILE = "New configuration file...";

    public SoapKitDialog(Definition wsdlDefinition, List<String> configFiles) {
        super(true);
        super.init();
        setTitle("Generate Flows from WSDL");
        createCenterPanel();
        setModal(true);

        this.wsdlDefinition = wsdlDefinition;

        Iterator<Map.Entry> serviceEntries = wsdlDefinition.getAllServices().entrySet().iterator();
        while (serviceEntries.hasNext()) {
            Map.Entry nextServiceEntry = serviceEntries.next();
            Service nextService = (Service) nextServiceEntry.getValue();
            service.addItem(nextService.getQName().getLocalPart());
        }

        service.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                port.removeAllItems();
                QName selectedService = new QName(wsdlDefinition.getTargetNamespace(), service.getSelectedItem().toString());
                Iterator<Map.Entry> portEntries = wsdlDefinition.getService(selectedService).getPorts().entrySet().iterator();
                while (portEntries.hasNext()) {
                    Map.Entry nextPortEntry = portEntries.next();
                    Port nextPort = (Port) nextPortEntry.getValue();
                    port.addItem(nextPort.getName());
                }

            }
        });

        service.setSelectedIndex(0);

        for (String nextName : configFiles) {
            configFile.addItem(nextName);
        }
        configFile.addItem(NEW_FILE);
    }

    public JPanel getRoot() {
        return root;
    }

    public void setRoot(JPanel root) {
        this.root = root;
    }

    public JComboBox getPort() {
        return port;
    }

    public void setPort(JComboBox port) {
        this.port = port;
    }

    public JComboBox getConfigFile() {
        return configFile;
    }

    public void setConfigFile(JComboBox configFile) {
        this.configFile = configFile;
    }

    public JComboBox getService() {
        return service;
    }

    public void setService(JComboBox service) {
        this.service = service;
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return getRoot();
    }
}
