package org.mule.tooling.esb.launcher.configuration.ui;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ProjectRootManager;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

@SuppressWarnings("serial")
public class MuleModulesCheckBoxList extends JList<JCheckBox> {

    protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

    public MuleModulesCheckBoxList() {
        this(new DefaultListModel<JCheckBox>());
    }

    public MuleModulesCheckBoxList(ListModel<JCheckBox> model) {
        setCellRenderer(new CellRenderer());
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index != -1) {
                    JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
                    checkbox.setSelected(!checkbox.isSelected());
                    repaint();
                }
            }
        });
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setModel(model);
    }

    public void setModules(Collection<Module> modules) {
        DefaultListModel<JCheckBox> myModel = (DefaultListModel<JCheckBox>)getModel();
        for (Module module : modules) {
            if (!containsModule(module.getName())) {
                JCheckBox cb = new JCheckBox(module.getName());
                myModel.addElement(cb);
            }
        }
    }

    private boolean containsModule(String moduleName) {
        return (findCheckBox(moduleName) != null);
    }

    private JCheckBox findCheckBox(String text) {
        DefaultListModel<JCheckBox> myModel = (DefaultListModel<JCheckBox>)getModel();
        Enumeration<JCheckBox> elements = myModel.elements();
        while (elements.hasMoreElements()) {
            JCheckBox nextElement = elements.nextElement();
            if (nextElement.getText().equals(text)) {
                return nextElement;
            }
        }
        return null;
    }

    public void selectModule(Module m, boolean selected) {
        DefaultListModel<JCheckBox> myModel = (DefaultListModel<JCheckBox>)getModel();
        if (m != null) {
            JCheckBox element = findCheckBox(m.getName());
            element.setSelected(selected);
        }
    }

    public Module[] getSelectedModules(Project p) {
        List<Module> selectedModules = new ArrayList<>();
        DefaultListModel<JCheckBox> myModel = (DefaultListModel<JCheckBox>)getModel();
        Enumeration<JCheckBox> elements = myModel.elements();
        while (elements.hasMoreElements()) {
            JCheckBox nextElement = elements.nextElement();
            if (nextElement.isSelected()) {
                String name = nextElement.getText();
                Module m = ModuleManager.getInstance(p).findModuleByName(name);
                selectedModules.add(m);
            }
        }

        return selectedModules.toArray(new Module[] {});
    }

    protected class CellRenderer implements ListCellRenderer<JCheckBox> {
        public Component getListCellRendererComponent(
                JList<? extends JCheckBox> list, JCheckBox value, int index,
                boolean isSelected, boolean cellHasFocus) {
            JCheckBox checkbox = value;

            //Drawing checkbox, change the appearance here
/*
            checkbox.setBackground(isSelected ? getSelectionBackground()
                    : getBackground());
            checkbox.setForeground(isSelected ? getSelectionForeground()
                    : getForeground());
*/
            checkbox.setEnabled(isEnabled());
            checkbox.setFont(getFont());
            checkbox.setFocusPainted(false);
            checkbox.setBorderPainted(true);
            checkbox.setBorder(isSelected ? UIManager
                    .getBorder("List.focusCellHighlightBorder") : noFocusBorder);
            return checkbox;
        }
    }
}
