package io.github.jcglqmoyx.src.frontend.panels;

import io.github.jcglqmoyx.src.global.Global;
import io.github.jcglqmoyx.src.utils.FileUtils;
import io.github.jcglqmoyx.src.utils.I18NUtils;
import io.github.jcglqmoyx.src.utils.IconUtils;
import io.github.jcglqmoyx.src.utils.RecordScriptUtils;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public final class SmartClickSettingPanel extends JPanel {
    private static SmartClickSettingPanel SMART_CLICK_SETTINGS_PANEL;

    private SmartClickSettingPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(3, 1));

        final JPanel smartClickPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final JCheckBox smartClickCheckBox = new JCheckBox(I18NUtils.get("smart.click"));
        Global.smartClickCheckBox = smartClickCheckBox;
        smartClickCheckBox.addActionListener(e -> {
                    if (smartClickCheckBox.isSelected()) {
                        Global.isSmartClick = true;
                        Global.freezePointerCheckBox.setEnabled(false);
                    } else {
                        Global.isSmartClick = false;
                        Global.freezePointerCheckBox.setEnabled(true);
                    }
                }
        );
        this.add(smartClickCheckBox);
        smartClickPanel.add(smartClickCheckBox);
        this.add(smartClickPanel);

        final JPanel recordPanel = new JPanel();
        recordPanel.setLayout(new GridLayout(1, 3));
        final JLabel recordLabel = new JLabel(I18NUtils.get("records"));
        this.add(recordLabel);
        final JTextField recordTextField = new JTextField("0");
        Global.recordTextField = recordTextField;
        recordTextField.setEditable(false);
        this.add(recordTextField);
        recordPanel.add(recordLabel);
        recordPanel.add(recordTextField);
        this.add(recordPanel);

        final JPanel clearRecordPanel = new JPanel(new GridLayout(1, 3));
        final JButton clearRecordButton = new JButton(I18NUtils.get("clear"));
        clearRecordButton.addActionListener(e -> {
                    Global.pointsList.clear();
                    Global.recordTextField.setText("0");
                    if (Global.recordWindow != null) {
                        Global.recordNumberLabel.setText("0");
                    }
                }
        );
        clearRecordPanel.add(clearRecordButton);
        final JButton saveRecordButton = new JButton(I18NUtils.get("save"));
        saveRecordButton.addActionListener(
                e -> {
                    if (Global.pointsList.isEmpty()) {
                        JOptionPane.showConfirmDialog(null, "No record to save.", "no record", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, IconUtils.WARNING);
                        return;
                    }
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setDialogTitle("Save record");
                    int result = fileChooser.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String path = fileChooser.getSelectedFile().getAbsolutePath() + ".py";
                        String fileName = fileChooser.getSelectedFile().getName();
                        if (!FileUtils.isValidFilename(fileName)) {
                            JOptionPane.showConfirmDialog(null, "Filename can only contain letters, numbers, and underscores.", "invalid filename", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, IconUtils.WARNING);
                        } else {
                            String content = RecordScriptUtils.generatePythonScript();
                            try {
                                FileWriter writer = new FileWriter(path);
                                writer.write(content);
                                writer.close();
                            } catch (IOException exception) {
                                exception.printStackTrace();
                            }
                        }
                    }
                }
        );
        clearRecordPanel.add(saveRecordButton);
        final JButton loadRecordButton = new JButton(I18NUtils.get("load"));
        loadRecordButton.addActionListener(
                e -> {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setDialogTitle("Load saved record");
                    int result = fileChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String path = fileChooser.getSelectedFile().getAbsolutePath();
                        String fileName = fileChooser.getSelectedFile().getName();
                        if (!fileName.contains(".") || !fileName.substring(fileName.lastIndexOf(".") + 1).equals("py")) {
                            JOptionPane.showConfirmDialog(null, "Record files should have '.py' extension.", "invalid record file", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, IconUtils.WARNING);
                            return;
                        }
                        fileName = fileName.substring(0, fileName.lastIndexOf("."));
                        if (!FileUtils.isValidFilename(fileName)) {
                            JOptionPane.showConfirmDialog(null, "Filename can only contain letters, numbers, and underscores.", "invalid filename", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, IconUtils.WARNING);
                        } else {
                            if (!RecordScriptUtils.loadScript(path)) {
                                JOptionPane.showConfirmDialog(null, "Invalid record file.", "failed to load record file", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, IconUtils.WARNING);
                            }
                        }
                    }
                });
        clearRecordPanel.add(loadRecordButton);
        this.add(clearRecordPanel);
    }

    private SmartClickSettingPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static SmartClickSettingPanel getInstance(int x, int y, int width, int height) {
        if (SMART_CLICK_SETTINGS_PANEL == null) {
            SMART_CLICK_SETTINGS_PANEL = new SmartClickSettingPanel(x, y, width, height);
        }
        return SMART_CLICK_SETTINGS_PANEL;
    }
}