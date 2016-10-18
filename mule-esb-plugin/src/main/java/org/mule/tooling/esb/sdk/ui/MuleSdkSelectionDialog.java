package org.mule.tooling.esb.sdk.ui;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.ui.AnActionButton;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.table.TableView;
import com.intellij.util.SystemProperties;
import com.intellij.util.io.ZipUtil;
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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

import static java.lang.String.format;

public class MuleSdkSelectionDialog extends JDialog {
    //
    private static final int BUFFER_SIZE = 1024 * 5;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel listPanel;
    private TableView<MuleSdk> myInputsTable;
    private final JComponent myParent;
    private final ListTableModel<MuleSdk> myTableModel = getSdkTableModel();
    private MuleSdk mySelectedSdk;

    public MuleSdkSelectionDialog(JComponent parent) {
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
        AnActionButton downloadVersionActions = new AnActionButton("Download a version", AllIcons.ToolbarDecorator.Import) {
            @Override
            public void actionPerformed(AnActionEvent anActionEvent) {
                onDownload();
            }
        };
        downloadVersionActions.setEnabled(true);
        listPanel.add(ToolbarDecorator.createDecorator(myInputsTable)
                .setAddAction(anActionButton -> onBrowse())
                .setRemoveAction(anActionButton -> removeSelected())
                .addExtraAction(downloadVersionActions).createPanel(), BorderLayout.CENTER);

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());

        myInputsTable.getSelectionModel().addListSelectionListener(new SdkSelectionListener());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        updateTable();
    }

    protected ListTableModel<MuleSdk> getSdkTableModel() {
        return new SdkTableModel();
    }

    private void removeSelected() {
        final MuleSdk selectedObject = myInputsTable.getSelectedObject();
        if (selectedObject != null) {
            final int selectedRow = myInputsTable.getSelectedRow();
            myTableModel.removeRow(selectedRow);
            MuleSdkManager.getInstance().removeSdk(selectedObject);
        }
    }

    private void updateTable() {
        final List<MuleSdk> sdks = new ArrayList<>(MuleSdkManager.getInstance().getSdks());
        myTableModel.setItems(sdks);
        myInputsTable.setModelAndUpdateColumns(myTableModel);
        if (!sdks.isEmpty()) {
            myInputsTable.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    protected String getLanguageName() {
        return "Mule";
    }

    private void onDownload() {
        String languageName = getLanguageName();
        List<String> versions = MuleUrl.getVERSIONS().stream().map(MuleUrl::getName).collect(Collectors.toList());
        final SdkVersionSelectionDialog<String> dialog = new SdkVersionSelectionDialog<>(contentPane, "Download ", format("%s version:", languageName), versions);
        if (dialog.showAndGet()) {
            downloadVersionWithProgress(dialog.getSelectedValue(), dialog.getDestinationText());
        }

    }

    private void downloadVersionWithProgress(String version, String destinationDir) {

        Messages.showInfoMessage(contentPane, "Download Is Going to Take Some Time. Good time for a coffee.", "Mule Distribution Download");
        final Optional<MuleUrl> first = MuleUrl.getVERSIONS().stream().filter((url) -> url.getName().equals(version)).findFirst();
        final MuleUrl muleUrl = first.get();
        try {
            final ProgressManager instance = ProgressManager.getInstance();
            final File distro = instance.runProcessWithProgressSynchronously(() -> {
                final URL artifactUrl = new URL(muleUrl.getUrl());
                final File sourceFile = FileUtil.createTempFile("mule" + version, ".zip");
                if (download(instance.getProgressIndicator(), artifactUrl, sourceFile, version)) {
                    final File destDir = new File(destinationDir);
                    destDir.mkdirs();
                    ZipUtil.extract(sourceFile, destDir, null);
                    try (ZipFile zipFile = new ZipFile(sourceFile)) {
                        String rootName = zipFile.entries().nextElement().getName();
                        return new File(destDir, rootName);
                    }
                } else {
                    return null;
                }
            }, "Downloading Mule Distribution " + muleUrl.getName(), true, null);
            if (distro != null) {
                final MuleSdk muleSdk = new MuleSdk(distro.getAbsolutePath());
                MuleSdkManagerImpl.getInstance().addSdk(muleSdk);
                myTableModel.addRow(muleSdk);
                final int rowIndex = myTableModel.getRowCount() - 1;
                myInputsTable.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
                onOK();
            }
        } catch (Exception e) {
            Messages.showErrorDialog("An error occurred while trying to download " + version + ".\n" + e.getMessage(),
                    "Mule SDK Download Error");
        }

    }


    private boolean download(ProgressIndicator progressIndicator, URL url, File outputFile, String version) {
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) (url.openConnection());
            long completeFileSize = httpConnection.getContentLength();
            java.io.BufferedInputStream in = new java.io.BufferedInputStream(httpConnection.getInputStream());
            java.io.FileOutputStream fos = new java.io.FileOutputStream(outputFile);
            java.io.BufferedOutputStream bout = new BufferedOutputStream(fos, BUFFER_SIZE);
            byte[] data = new byte[BUFFER_SIZE];
            long downloadedFileSize = 0;
            int x;
            while (!progressIndicator.isCanceled() && (x = in.read(data, 0, BUFFER_SIZE)) >= 0) {
                downloadedFileSize += x;
                // calculate progress
                final double currentProgress = ((double) downloadedFileSize) / ((double) completeFileSize);
                progressIndicator.setFraction(currentProgress);
                progressIndicator.setText2(Math.ceil(downloadedFileSize / (1024 * 1024)) + "/" + (Math.ceil(completeFileSize / (1024 * 1024)) + " MB"));
                bout.write(data, 0, x);
            }
            bout.close();
            in.close();
        } catch (IOException e) {
            Messages.showErrorDialog("An error occurred while trying to download " + version + ".\n" + e.getMessage(), "Mule SDK Download Error");
            return false;
        }
        return !progressIndicator.isCanceled();
    }

    @NotNull
    private File getUserHome() {
        return new File(SystemProperties.getUserHome());
    }


    private void onBrowse() {
        final MuleSdk muleSdk = MuleUIUtils.selectSdk(contentPane);
        if (muleSdk != null) {
            MuleSdkManagerImpl.getInstance().addSdk(muleSdk);
            myTableModel.addRow(muleSdk);
            final int rowIndex = myTableModel.getRowCount() - 1;
            myInputsTable.getSelectionModel().setSelectionInterval(rowIndex, rowIndex);
            onOK();
        }
    }


    private void onOK() {
        if (myInputsTable.getSelectedRowCount() > 0) {
            mySelectedSdk = myTableModel.getItems().get(myInputsTable.getSelectedRow());
        }
        dispose();
    }

    private void onCancel() {
        mySelectedSdk = null;
        dispose();
    }

    public MuleSdk open() {
        pack();
        setLocationRelativeTo(myParent.getTopLevelAncestor());
        setVisible(true);
        return mySelectedSdk;
    }


    private class SdkSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            buttonOK.setEnabled(myInputsTable.getSelectedRow() >= 0);
        }
    }
}
