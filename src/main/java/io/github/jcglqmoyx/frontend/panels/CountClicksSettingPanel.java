package io.github.jcglqmoyx.frontend.panels;

import io.github.jcglqmoyx.global.Global;
import io.github.jcglqmoyx.hander.impl.CountClicksTextFieldHandlerImpl;
import io.github.jcglqmoyx.utils.I18NUtils;

import javax.swing.*;
import java.awt.*;

public final class CountClicksSettingPanel extends JPanel {
    private static CountClicksSettingPanel COUNT_CLICKS_SETTINGS_PANEL;

    private CountClicksSettingPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(2, 1));

        final JCheckBox counterCheckBox = new JCheckBox(I18NUtils.get("counter"));
        Global.counterCheckBox = counterCheckBox;
        this.add(counterCheckBox);

        final JPanel countClicksPanel = new JPanel();
        countClicksPanel.setLayout(new GridLayout(1, 2));

        final JTextField countClicksTextField = new JTextField();
        Global.countClicksTextField = countClicksTextField;
        countClicksTextField.addKeyListener(new CountClicksTextFieldHandlerImpl());

        final JLabel countClicksLabel = new JLabel(I18NUtils.get("times"));
        countClicksPanel.add(countClicksTextField);
        countClicksPanel.add(countClicksLabel);

        this.add(countClicksPanel);
    }

    private CountClicksSettingPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static CountClicksSettingPanel getInstance(int x, int y, int width, int height) {
        if (COUNT_CLICKS_SETTINGS_PANEL == null) {
            COUNT_CLICKS_SETTINGS_PANEL = new CountClicksSettingPanel(x, y, width, height);
        }
        return COUNT_CLICKS_SETTINGS_PANEL;
    }
}