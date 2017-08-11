package org.mule.tooling.esb.launcher.configuration.ui;


import com.intellij.ui.table.JBTable;
import org.mule.tooling.esb.launcher.configuration.MuleRemoteConfiguration;
import org.mule.tooling.esb.util.MuleConfigUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MuleRemoteDebuggerConfPanel {
    private JTextField hostTextField;
    private JFormattedTextField portTextField;
    private JTextField mulePropertiesTextField;
    private JPanel mainPanel;
    private JCheckBox customizeDeployedApps;
    private JTable appsMap;
    private JFormattedTextField jvmPortTextField;

    public MuleRemoteDebuggerConfPanel() {

        updatePropertiesValue();
        portTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePropertiesValue();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePropertiesValue();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePropertiesValue();
            }
        });

        customizeDeployedApps.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                appsMap.setEnabled(customizeDeployedApps.isSelected());
            }
        });
    }

    public void updateFromConfig(MuleRemoteConfiguration configuration) {
        hostTextField.setText(configuration.getHost());
        portTextField.setText(String.valueOf(configuration.getPort()));
        jvmPortTextField.setText(String.valueOf(configuration.getJvmPort()));
        customizeDeployedApps.setSelected(configuration.isCustomAppsMap());

        //if (configuration.isCustomAppsMap()) {
        TableModel model = appsMap.getModel();

        Map<String, String> modulesToApps = configuration.getModulesToAppsMap();
        List<List<String>> modelData = new ArrayList<>();

        int ctr = 0;
        for (String moduleName : modulesToApps.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(moduleName);
            row.add(modulesToApps.get(moduleName));
            modelData.add(row);
        }

        ((ModulesTableModel) model).setData(modelData);
        ((ModulesTableModel) model).fireTableDataChanged();

        //}
        updatePropertiesValue();
    }

    private void updatePropertiesValue() {
        mulePropertiesTextField.setText("-debug -M-Dmule.debug.enable=true -M-Dmule.debug.port=" + portTextField.getText());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getHostText() {
        return hostTextField.getText();
    }

    public int getPortNumber() {
        try {
            return Integer.parseInt(portTextField.getText());
        } catch (Exception e) {
            return 6666;
        }
    }

    public int getJvmPortNumber() {
        try {
            return Integer.parseInt(jvmPortTextField.getText());
        } catch (Exception e) {
            return 5005;
        }
    }

    public boolean isCustomAppsMapping() {
        return customizeDeployedApps.isSelected();
    }

    public Map<String, String> getModuleToAppsMap() {
        Map<String, String> modulesToApps = new HashMap<>();
        List<List<String>> data = ((ModulesTableModel) appsMap.getModel()).getData();
        for (List<String> row : data) {
            modulesToApps.put(row.get(0), row.get(1));
        }
        return modulesToApps;
    }

    private void createUIComponents() {
        NumberFormat format = NumberFormat.getInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMaximum(65535);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        portTextField = new JFormattedTextField(formatter);
        jvmPortTextField = new JFormattedTextField(formatter);

        appsMap = new JBTable(new ModulesTableModel());

    }

    class ModulesTableModel extends AbstractTableModel {
        private String[] columnNames = {"Module", "Remote Application"};
        private List<List<String>> data = new ArrayList<>();

        public ModulesTableModel() {

        }

        public List<List<String>> getData() {
            return data;
        }

        public void setData(List<List<String>> data) {
            this.data = data;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data.get(row).get(col);
        }

        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            if (col < 1) { //Module names are not editable
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            //data[row][col] = value;
            data.get(row).set(col, value.toString());
            fireTableCellUpdated(row, col);
        }
    }

}
