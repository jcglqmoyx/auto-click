package io.github.jcglqmoyx.src.frontend.panels;

import io.github.jcglqmoyx.src.global.Global;

import javax.swing.*;
import java.awt.*;

public final class AdditionalSettingsPanel extends JPanel {
    private static AdditionalSettingsPanel ADDITIONAL_SETTINGS_PANEL;

    private AdditionalSettingsPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Settings"));
        this.setLayout(new GridLayout(2, 2));

        final JCheckBox keepOnTopCheckBox = new JCheckBox("Keep on top");

        final Container[] container = {this};
        keepOnTopCheckBox.addActionListener(e -> {
            while (!(container[0] instanceof JFrame)) {
                container[0] = container[0].getParent();
            }
            ((JFrame) container[0]).setAlwaysOnTop(keepOnTopCheckBox.isSelected());
        });
        this.add(keepOnTopCheckBox);

        final JCheckBox freezePointerCheckBox = new JCheckBox("Freeze pointer");
        Global.freezePointerCheckBox = freezePointerCheckBox;
        freezePointerCheckBox.addActionListener(e -> {
                    if (freezePointerCheckBox.isSelected()) {
                        Global.isToFreezePointer = true;
                        Global.smartClickCheckBox.setEnabled(false);
                    } else {
                        Global.isToFreezePointer = false;
                        Global.smartClickCheckBox.setEnabled(true);
                    }
                }
        );
        this.add(freezePointerCheckBox);
    }

    private AdditionalSettingsPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static AdditionalSettingsPanel getInstance(int x, int y, int width, int height) {
        if (ADDITIONAL_SETTINGS_PANEL == null) {
            ADDITIONAL_SETTINGS_PANEL = new AdditionalSettingsPanel(x, y, width, height);
        }
        return ADDITIONAL_SETTINGS_PANEL;
    }
}
