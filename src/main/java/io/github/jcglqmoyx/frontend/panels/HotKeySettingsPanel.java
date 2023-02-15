package io.github.jcglqmoyx.frontend.panels;

import io.github.jcglqmoyx.global.Global;
import io.github.jcglqmoyx.hander.impl.HotKeySettingsTextFieldHandlerImpl;
import io.github.jcglqmoyx.utils.I18NUtils;

import javax.swing.*;
import java.awt.*;

public final class HotKeySettingsPanel extends JPanel {
    private static HotKeySettingsPanel HOT_KEY_SETTINGS_PANEL;

    private HotKeySettingsPanel() {
        this.setBorder(BorderFactory.createTitledBorder(I18NUtils.get("hotkey")));
        this.setLayout(new GridLayout(2, 1));

        JPanel clickHotKeyPanel = new JPanel(new GridLayout(1, 2));
        clickHotKeyPanel.setLayout(new BoxLayout(clickHotKeyPanel, BoxLayout.X_AXIS));
        this.add(clickHotKeyPanel);

        final JLabel clickHotKeyLabel = new JLabel(I18NUtils.get("click.hotkey.settings"));
        clickHotKeyPanel.add(clickHotKeyLabel);

        final JTextField clickHotKeyTextField = new JTextField();
        clickHotKeyTextField.setEditable(false);
        HotKeySettingsTextFieldHandlerImpl clickHotKeyTextFieldHandler = new HotKeySettingsTextFieldHandlerImpl(clickHotKeyTextField, Global.CLICK_HOT_KEY_FLAG);
        clickHotKeyTextField.addKeyListener(clickHotKeyTextFieldHandler);
        clickHotKeyTextField.addMouseListener(clickHotKeyTextFieldHandler);
        clickHotKeyPanel.add(clickHotKeyTextField);
        this.add(clickHotKeyPanel);


        final JPanel recordHotKeyPanel = new JPanel();
        recordHotKeyPanel.setLayout(new BoxLayout(recordHotKeyPanel, BoxLayout.X_AXIS));
        this.add(recordHotKeyPanel);
        final JLabel recordHotKeyLabel = new JLabel(I18NUtils.get("record.hotkey.settings"));
        recordHotKeyPanel.add(recordHotKeyLabel);
        final JTextField recordHotKeyTextField = new JTextField();
        recordHotKeyTextField.setEditable(false);
        HotKeySettingsTextFieldHandlerImpl recordHotKeyTextFieldHandler = new HotKeySettingsTextFieldHandlerImpl(recordHotKeyTextField, Global.RECORD_HOT_KEY_FLAG);
        recordHotKeyTextField.addKeyListener(recordHotKeyTextFieldHandler);
        recordHotKeyTextField.addMouseListener(recordHotKeyTextFieldHandler);
        recordHotKeyPanel.add(recordHotKeyTextField);
        this.add(recordHotKeyPanel);
    }

    private HotKeySettingsPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static HotKeySettingsPanel getInstance(int x, int y, int width, int height) {
        if (HOT_KEY_SETTINGS_PANEL == null) {
            HOT_KEY_SETTINGS_PANEL = new HotKeySettingsPanel(x, y, width, height);
        }
        return HOT_KEY_SETTINGS_PANEL;
    }
}