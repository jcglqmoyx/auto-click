package io.github.jcglqmoyx.src.frontend.panels;

import io.github.jcglqmoyx.src.global.Global;
import io.github.jcglqmoyx.src.utils.I18NUtils;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;

public final class TimeIntervalSettingsPanel extends JPanel {
    private static TimeIntervalSettingsPanel TIME_INTERVAL_SETTINGS_PANEL;

    private TimeIntervalSettingsPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(2, 1));

        final JPanel intervalPanel = new JPanel();
        intervalPanel.setLayout(new GridLayout(1, 5));
        this.add(intervalPanel);
        final JPanel timeIntervalSpinnerPanel = new JPanel();
        timeIntervalSpinnerPanel.setLayout(new GridLayout(1, 5));
        this.add(timeIntervalSpinnerPanel);
        final String[] timeIntervals = new String[]{I18NUtils.get("hour"), I18NUtils.get("minute"), I18NUtils.get("second"), I18NUtils.get("tenth.second"), I18NUtils.get("hundredth.second")};
        final JLabel[] timeIntervalLabel = new JLabel[5];
        final JSpinner[] timeIntervalSpinner = new JSpinner[5];
        Global.timeIntervalSpinner = timeIntervalSpinner;
        final SpinnerNumberModel[] timeIntervalSpinnerModel = new SpinnerNumberModel[]{
                new SpinnerNumberModel(0, 0, 23, 1),
                new SpinnerNumberModel(0, 0, 59, 1),
                new SpinnerNumberModel(2, 0, 59, 1),
                new SpinnerNumberModel(0, 0, 9, 1),
                new SpinnerNumberModel(0, 0, 9, 1)
        };
        for (int i = 0; i < timeIntervalLabel.length; i++) {
            timeIntervalLabel[i] = new JLabel(timeIntervals[i]);
            intervalPanel.add(timeIntervalLabel[i]);
            timeIntervalSpinner[i] = new JSpinner(timeIntervalSpinnerModel[i]);
            timeIntervalSpinner[i].addChangeListener(e -> {
                int hour = (int) timeIntervalSpinner[0].getValue();
                int minute = (int) timeIntervalSpinner[1].getValue();
                int second = (int) timeIntervalSpinner[2].getValue();
                int tenth = (int) timeIntervalSpinner[3].getValue();
                int hundredth = (int) timeIntervalSpinner[4].getValue();
                Global.clickTimeInterval = hour * 3600000 + minute * 60000 + second * 1000 + tenth * 100 + hundredth * 10;
                if (Global.recordWindow != null && Global.recordWindow.isDisplayable() && !Global.pointsList.isEmpty()) {
                    Global.pointsList.get(Global.pointsList.size() - 1).setDelay(Global.clickTimeInterval);
                }
            });
            timeIntervalSpinnerPanel.add(timeIntervalSpinner[i]);

            timeIntervalSpinner[i].setEditor(new JSpinner.NumberEditor(timeIntervalSpinner[i], "0"));
            JFormattedTextField textField = ((JSpinner.NumberEditor) timeIntervalSpinner[i].getEditor()).getTextField();
            textField.setEditable(true);
            DefaultFormatterFactory factory = (DefaultFormatterFactory) textField.getFormatterFactory();
            NumberFormatter formatter = (NumberFormatter) factory.getDefaultFormatter();
            formatter.setAllowsInvalid(false);
        }

    }

    private TimeIntervalSettingsPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static TimeIntervalSettingsPanel getInstance(int x, int y, int width, int height) {
        if (TIME_INTERVAL_SETTINGS_PANEL == null) {
            TIME_INTERVAL_SETTINGS_PANEL = new TimeIntervalSettingsPanel(x, y, width, height);
        }
        return TIME_INTERVAL_SETTINGS_PANEL;
    }
}
