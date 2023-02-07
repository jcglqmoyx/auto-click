package io.github.jcglqmoyx.src.frontend.panels;

import io.github.jcglqmoyx.src.global.Global;

import javax.swing.*;
import java.awt.*;

public final class WorkingStatusPanel extends JPanel {
    private static WorkingStatusPanel WORKING_STATUS_PANEL;

    private WorkingStatusPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(1, 1));

        final JButton workingStatusButton = new JButton("Stopped clicking");
        Global.workingStatusButton = workingStatusButton;
        workingStatusButton.setForeground(Color.BLUE);
        this.add(workingStatusButton);
    }

    private WorkingStatusPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static WorkingStatusPanel getInstance(int x, int y, int width, int height) {
        if (WORKING_STATUS_PANEL == null) {
            WORKING_STATUS_PANEL = new WorkingStatusPanel(x, y, width, height);
        }
        return WORKING_STATUS_PANEL;
    }
}