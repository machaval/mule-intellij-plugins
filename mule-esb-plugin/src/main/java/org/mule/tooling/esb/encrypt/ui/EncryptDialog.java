package org.mule.tooling.esb.encrypt.ui;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import org.jetbrains.annotations.Nullable;
import org.mule.security.encryption.binary.jce.algorithms.EncryptionAlgorithm;
import org.mule.security.encryption.binary.jce.algorithms.EncryptionMode;

import javax.swing.*;

/**
 * Created by eberman on 10/11/16.
 */
public class EncryptDialog extends DialogWrapper {
    private JComboBox algorithm;
    private JComboBox mode;
    private JPasswordField encryptionKey;
    private JPanel root;

    public static String previousKey = null;
    public static EncryptionMode previousMode = null;
    public static EncryptionAlgorithm previousAlgoritm = null;

    public EncryptDialog() {
        super(true);
        super.init();
        setTitle("Encrypt Property");
        createCenterPanel();
        setModal(true);
        for (EncryptionMode encryptionMode : java.util.Arrays.asList(EncryptionMode.values())) {
            mode.addItem(encryptionMode);
        }
        for (EncryptionAlgorithm encryptionAlgorithm : java.util.Arrays.asList(EncryptionAlgorithm.values())) {
            algorithm.addItem(encryptionAlgorithm);
        }
        if (previousKey != null) {
            encryptionKey.setText(previousKey);
        }
        if (previousMode != null) {
            mode.setSelectedItem(previousMode);
        }
        if (previousAlgoritm != null) {
            algorithm.setSelectedItem(previousAlgoritm);
        }
    }

    public JComboBox getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(JComboBox algorithm) {
        this.algorithm = algorithm;
    }

    public JComboBox getMode() {
        return mode;
    }

    public void setMode(JComboBox mode) {
        this.mode = mode;
    }

    public JPasswordField getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(JPasswordField encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public JPanel getRoot() {
        return root;
    }

    public void setRoot(JPanel root) {
        this.root = root;
    }


    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return getRoot();
    }

    @Override
    protected String getDimensionServiceKey() {
        return getClass().getCanonicalName();
    }

    @Override
    protected ValidationInfo doValidate() {
        String encKey = getEncryptionKey().getText();
        ValidationInfo validationInfo = null;

        EncryptionAlgorithm selectedAlgorithm = (EncryptionAlgorithm)getAlgorithm().getSelectedItem();
        if (encKey == null || encKey.length() < selectedAlgorithm.minKeySize()) {
            validationInfo = new ValidationInfo("The encryption key for the algorithm " + selectedAlgorithm.toString() + " must be at least " + selectedAlgorithm.minKeySize() + " characters long",
                    this.encryptionKey);
        }

        /* Remember values */
        previousMode = (EncryptionMode)getMode().getSelectedItem();
        previousKey = encKey;
        previousAlgoritm = selectedAlgorithm;
        /******************/

        return validationInfo;
    }



}
