package org.mule.tooling.esb.sdk.ui;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.table.TableView;
import com.intellij.util.SystemProperties;
import com.intellij.util.ui.ListTableModel;
import org.jetbrains.annotations.NotNull;
import org.mule.tooling.esb.sdk.MuleSdk;
import org.mule.tooling.esb.sdk.MuleSdkManager;
import org.mule.tooling.esb.sdk.MuleSdkManagerImpl;
import org.mule.tooling.esb.sdk.MuleUrl;
import org.mule.tooling.esb.util.MuleUIUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class MuleSdkSelectionDialog extends JDialog
{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel listPanel;
    private TableView<MuleSdk> myInputsTable;
    private final JComponent myParent;
    private final ListTableModel<MuleSdk> myTableModel = getSdkTableModel();
    private MuleSdk mySelectedSdk;

    public MuleSdkSelectionDialog(JComponent parent)
    {
        super((Window) parent.getTopLevelAncestor());
        setTitle(format("Select Folder for the new %s SDK", getLanguageName()));
        myParent = parent;
        this.myInputsTable = new TableView<>();
        this.myInputsTable.getEmptyText().setText("No Sdk Defined.");
        myInputsTable.setColumnSelectionAllowed(false);
        myInputsTable.setShowGrid(false);
        myInputsTable.setDragEnabled(false);
        myInputsTable.setShowHorizontalLines(false);
        myInputsTable.setShowVerticalLines(false);
        myInputsTable.setIntercellSpacing(new Dimension(0, 0));

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        listPanel.add(ToolbarDecorator.createDecorator(myInputsTable)
                                      .setAddAction(anActionButton -> onBrowse())
                                      .setRemoveAction(anActionButton -> removeSelected())
                                      .addExtraAction(new AnActionButton("Download a version", AllIcons.ToolbarDecorator.Import)
                                      {
                                          @Override
                                          public void actionPerformed(AnActionEvent anActionEvent)
                                          {
                                              onDownload();
                                          }
                                      }).createPanel(), BorderLayout.CENTER);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        myInputsTable.getSelectionModel().addListSelectionListener(new SdkSelectionListener());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        updateTable();
    }

    protected ListTableModel<MuleSdk> getSdkTableModel()
    {
        return new SdkTableModel();
    }

    private void removeSelected()
    {
        final MuleSdk selectedObject = myInputsTable.getSelectedObject();
        if (selectedObject != null)
        {
            final int selectedRow = myInputsTable.getSelectedRow();
            myTableModel.removeRow(selectedRow);
            MuleSdkManager.getInstance().removeSdk(selectedObject);
        }
    }

    private void updateTable()
    {
        final List<MuleSdk> sdks = new ArrayList<>(MuleSdkManager.getInstance().getSdks());
        myTableModel.setItems(sdks);
        myInputsTable.setModelAndUpdateColumns(myTableModel);
        if (!sdks.isEmpty())
        {
            myInputsTable.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    protected String getLanguageName()
    {
        return "Mule";
    }

    private void onDownload()
    {
        String languageName = getLanguageName();
        List<String> versions = MuleUrl.VERSIONS.stream().map(MuleUrl::getName).collect(Collectors.toList());
        final SdkVersionSelectionDialog<String> dialog = new SdkVersionSelectionDialog<>(contentPane, "Download ", format("%s version:", languageName), versions);
        if (dialog.showAndGet())
        {
            downloadVersionWithProgress(dialog.getSelectedValue());
        }

    }

    private void downloadVersionWithProgress(String version)
    {

        Messages.showInfoMessage(contentPane, "Mule Distribution download", "Download is going to take some time.");
        final Optional<MuleUrl> first = MuleUrl.VERSIONS.stream().filter((url) -> url.getName().equals(version)).findFirst();
        final MuleUrl muleUrl = first.get();
        try
        {
            final ProgressManager instance = ProgressManager.getInstance();
            final File distro = instance.runProcessWithProgressSynchronously(() -> {
                URL website = new URL(muleUrl.getUrl());
                ReadableByteChannel rbc = Channels.newChannel(website.openStream());
                final File sourceFile = FileUtil.createTempFile("mule" + version, ".targz");
                FileOutputStream fos = new FileOutputStream(sourceFile);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                final File destDir = new File(getUserHome(), "mule-distro");
                destDir.mkdirs();
                final ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.command("tar", "xvf", sourceFile.getAbsolutePath(), "-C", destDir.getAbsolutePath()).inheritIO().start().waitFor();
                return new File(destDir, muleUrl.getFolderName());
            }, "Downloading Mule Distribution " + muleUrl.getName(), false, null);
            final MuleSdk muleSdk = new MuleSdk(distro.getAbsolutePath());
            MuleSdkManagerImpl.getInstance().addSdk(muleSdk);
            myTableModel.addRow(muleSdk);
            final int rowIndex = myTableModel.getRowCount() - 1;
            myInputsTable.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
            onOK();
        }
        catch (Exception e)
        {
            Messages.showErrorDialog("An error occurred while trying to download " + version + ".\n" + e.getMessage(),
                    "Mule SDK Download Error");
        }

    }

    @NotNull
    private File getUserHome()
    {
        return new File(SystemProperties.getUserHome());
    }


    private void onBrowse()
    {
        final MuleSdk muleSdk = MuleUIUtils.selectSdk(contentPane);
        if (muleSdk != null)
        {
            MuleSdkManagerImpl.getInstance().addSdk(muleSdk);
            myTableModel.addRow(muleSdk);
            final int rowIndex = myTableModel.getRowCount() - 1;
            myInputsTable.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
            onOK();
        }
    }


    private void onOK()
    {
        if (myInputsTable.getSelectedRowCount() > 0)
        {
            mySelectedSdk = myTableModel.getItems().get(myInputsTable.getSelectedRow());
        }
        dispose();
    }

    private void onCancel()
    {
        mySelectedSdk = null;
        dispose();
    }

    public MuleSdk open()
    {
        pack();
        setLocationRelativeTo(myParent.getTopLevelAncestor());
        setVisible(true);
        return mySelectedSdk;
    }


    private class SdkSelectionListener implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            buttonOK.setEnabled(myInputsTable.getSelectedRow() >= 0);
        }
    }
}
