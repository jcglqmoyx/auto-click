package io.github.jcglqmoyx.src.frontend.window;

import io.github.jcglqmoyx.src.entity.PointEntity;
import io.github.jcglqmoyx.src.global.Global;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

public class RecordWindow extends JFrame {
    public RecordWindow() {
        this.setLayout(null);

        JButton recordButton = new JButton("Record");
        int x;
        if (Global.OS.contains("mac")) {
            x = 0;
        } else {
            x = 5;
        }
        recordButton.setBounds(x, 20, 120, 30);
        this.add(recordButton);

        JLabel xLabel = new JLabel("X:");
        xLabel.setBounds(140, 10, 20, 30);
        this.add(xLabel);
        JLabel xCoordinateLabel = new JLabel("0");
        xCoordinateLabel.setBounds(160, 10, 50, 30);
        this.add(xCoordinateLabel);
        JLabel yLabel = new JLabel("Y:");
        yLabel.setBounds(140, 30, 20, 30);
        this.add(yLabel);
        JLabel yCoordinateLabel = new JLabel("0");
        yCoordinateLabel.setBounds(160, 30, 50, 30);
        this.add(yCoordinateLabel);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Point point = MouseInfo.getPointerInfo().getLocation();
                xCoordinateLabel.setText(String.valueOf(point.x));
                yCoordinateLabel.setText(String.valueOf(point.y));
            }
        }, 0, 100);

        JLabel recordsLabel = new JLabel("Records:");
        recordsLabel.setBounds(220, 20, 70, 30);
        this.add(recordsLabel);
        JLabel recordsNumberLabel = new JLabel(String.valueOf(Global.pointsList == null ? 0 : Global.pointsList.size()));
        Global.recordNumberLabel = recordsNumberLabel;
        recordsNumberLabel.setBounds(290, 20, 50, 30);
        this.add(recordsNumberLabel);

        recordButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point point = MouseInfo.getPointerInfo().getLocation();
                Global.pointsList.add(new PointEntity(point.x, point.y));
                recordsNumberLabel.setText(String.valueOf(Global.pointsList.size()));
                Global.recordTextField.setText(String.valueOf(Global.pointsList.size()));

                Global.mouseButtonComboBox.setSelectedIndex(0);
                Global.clickComboBox.setSelectedIndex(0);
                for (int i = 0; i < 5; i++) {
                    if (i == 2) {
                        Global.timeIntervalSpinner[i].setValue(2);
                    } else {
                        Global.timeIntervalSpinner[i].setValue(0);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int WIDTH = 340, OFFSET = 50;
        int height;
        if (Global.OS.contains("mac")) {
            height = 100;
        } else if (Global.OS.contains("linux")) {
            height = 160;
        } else {
            height = 110;
        }
        this.setBounds((int) screenSize.getWidth() - WIDTH - OFFSET, OFFSET, WIDTH, height);
        this.setResizable(false);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
