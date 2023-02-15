package io.github.jcglqmoyx.src.frontend.panels;

import io.github.jcglqmoyx.src.global.Global;
import io.github.jcglqmoyx.src.hander.impl.CountClicksTextFieldHandlerImpl;
import io.github.jcglqmoyx.src.hander.impl.TextFieldInputLengthRestrictHandlerImpl;
import io.github.jcglqmoyx.src.utils.I18NUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public final class CountClicksSettingPanel extends JPanel {
    private static CountClicksSettingPanel COUNT_CLICKS_SETTINGS_PANEL;

    private CountClicksSettingPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(2, 1));

        final JCheckBox counterCheckBox = new JCheckBox(I18NUtils.get("counter"));
        this.add(counterCheckBox);

        final JPanel countClicksPanel = new JPanel();
        countClicksPanel.setLayout(new GridLayout(1, 2));

        final JTextField countClicksTextField = new JTextField();
        countClicksTextField.addKeyListener(new CountClicksTextFieldHandlerImpl(counterCheckBox));
        countClicksTextField.setDocument(new TextFieldInputLengthRestrictHandlerImpl(Global.COUNT_CLICK_TEXT_FIELD_MAXIMUM_INPUT_LENGTH_LIMIT));

        counterCheckBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!countClicksTextField.getText().isEmpty()) {
                    Global.clicks = Long.parseLong(countClicksTextField.getText());
                } else {
                    countClicksTextField.setText("0");
                    Global.clicks = 0;
                }
            } else {
                Global.clicks = Global.DEFAULT_CLICKS;
            }
        });

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