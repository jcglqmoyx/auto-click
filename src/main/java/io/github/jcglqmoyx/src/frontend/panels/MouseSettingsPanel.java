package io.github.jcglqmoyx.src.frontend.panels;

import io.github.jcglqmoyx.src.global.Global;
import io.github.jcglqmoyx.src.utils.I18NUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public final class MouseSettingsPanel extends JPanel {
    private static MouseSettingsPanel MOUSE_SETTINGS_PANEL;

    private MouseSettingsPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(2, 1));

        final JLabel mouseLabel = new JLabel(I18NUtils.get("mouse"));
        final JComboBox<String> mouseButtonCombobox = new JComboBox<>(new String[]{I18NUtils.get("left"), I18NUtils.get("middle"), I18NUtils.get("right")});
        Global.mouseButtonComboBox = mouseButtonCombobox;
        mouseButtonCombobox.addItemListener(e -> {
            if (e.getItem().equals(I18NUtils.get("left"))) {
                Global.buttonToClick = InputEvent.BUTTON1_DOWN_MASK;
                if (Global.recordWindow != null && Global.recordWindow.isDisplayable() && !Global.pointsList.isEmpty()) {
                    Global.pointsList.get(Global.pointsList.size() - 1).setButton(InputEvent.BUTTON1_DOWN_MASK);
                }
            } else if (e.getItem().equals(I18NUtils.get("middle"))) {
                Global.buttonToClick = InputEvent.BUTTON2_DOWN_MASK;
                if (Global.recordWindow != null && Global.recordWindow.isDisplayable() && !Global.pointsList.isEmpty()) {
                    Global.pointsList.get(Global.pointsList.size() - 1).setButton(InputEvent.BUTTON2_DOWN_MASK);
                }
            } else {
                Global.buttonToClick = InputEvent.BUTTON3_DOWN_MASK;
                if (Global.recordWindow != null && Global.recordWindow.isDisplayable() && !Global.pointsList.isEmpty()) {
                    Global.pointsList.get(Global.pointsList.size() - 1).setButton(InputEvent.BUTTON3_DOWN_MASK);
                }
            }
        });

        final JLabel clickLabel = new JLabel(I18NUtils.get("click"));
        final JComboBox<String> clickComboBox = new JComboBox<>(new String[]{I18NUtils.get("single"), I18NUtils.get("double")});
        Global.clickComboBox = clickComboBox;
        clickComboBox.addItemListener(e -> {
            Global.isToDoubleClick = e.getItem().equals(I18NUtils.get("double"));
            if (Global.recordWindow != null && Global.recordWindow.isDisplayable() && !Global.pointsList.isEmpty()) {
                Global.pointsList.get(Global.pointsList.size() - 1).setDoubleClick(Global.isToDoubleClick);
            }
        });

        this.add(mouseLabel);
        this.add(mouseButtonCombobox);
        this.add(clickLabel);
        this.add(clickComboBox);
    }

    private MouseSettingsPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static MouseSettingsPanel getInstance(int x, int y, int width, int height) {
        if (MOUSE_SETTINGS_PANEL == null) {
            MOUSE_SETTINGS_PANEL = new MouseSettingsPanel(x, y, width, height);
        }
        return MOUSE_SETTINGS_PANEL;
    }
}