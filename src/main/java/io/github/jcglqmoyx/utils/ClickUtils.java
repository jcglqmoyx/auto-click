package io.github.jcglqmoyx.utils;

import io.github.jcglqmoyx.entity.PointEntity;
import io.github.jcglqmoyx.global.Global;

import java.awt.*;

public class ClickUtils implements Runnable {
    private static ClickUtils clickUtils;

    private ClickUtils() {
    }

    private void singleClick(Robot robot, int button) throws AWTException {
        robot.mousePress(button);
        robot.mouseRelease(button);
    }

    private void doubleClick(Robot robot, int button) throws AWTException {
        for (int i = 0; i < 2; i++) {
            singleClick(robot, button);
        }
    }

    public static ClickUtils getInstance() {
        if (clickUtils == null) {
            clickUtils = new ClickUtils();
        }
        return clickUtils;
    }

    private void freezePointerClick() {
        Point point = MouseInfo.getPointerInfo().getLocation();
        int x = (int) point.getX();
        int y = (int) point.getY();
        try {
            int cnt = 0;
            Robot robot = new Robot();
            for (int i = 0; i < Global.clicks; i++) {
                robot.mouseMove(x, y);
                if (Global.isToDoubleClick) {
                    doubleClick(robot, Global.buttonToClick);
                } else {
                    singleClick(robot, Global.buttonToClick);
                }
                cnt++;
                Thread.sleep(Global.clickTimeInterval);
            }
            if (cnt == Global.clicks) {
                Global.isToClick = true;
                Global.workingStatusButton.setText(I18NUtils.get("stopped.clicking"));
                Global.workingStatusButton.setForeground(Color.BLUE);
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void click() {
        try {
            int cnt = 0;
//                Robot robot = new Robot(); // On Linux and Windows
            for (int i = 0; i < Global.clicks; i++) {
                Robot robot = new Robot(); // On Mac OS
                if (Global.isToDoubleClick) {
                    doubleClick(robot, Global.buttonToClick);
                } else {
                    singleClick(robot, Global.buttonToClick);
                }
                cnt++;
                Thread.sleep(Global.clickTimeInterval);
            }
            if (cnt == Global.clicks) {
                Global.isToClick = true;
                Global.workingStatusButton.setText(I18NUtils.get("stopped.clicking"));
                Global.workingStatusButton.setForeground(Color.BLUE);
            }
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void smartClick() {
        try {
            int cnt = 0;
//            Robot robot = new Robot(); On Linux and Windows
            for (int i = 0; i < Global.clicks; i++) {
                for (int j = 0; j < Global.pointsList.size(); j++) {
                    PointEntity pointEntity = Global.pointsList.get(j);
                    Robot robot = new Robot(); // On Mac OS
                    if (Global.pointsList.get(j).isDoubleClick()) {
                        robot.mouseMove(pointEntity.getX(), pointEntity.getY());
                        doubleClick(robot, pointEntity.getButton());
                    } else {
                        robot.mouseMove(pointEntity.getX(), pointEntity.getY());
                        singleClick(robot, pointEntity.getButton());
                    }
                    Thread.sleep(pointEntity.getDelay());
                }
                cnt++;
            }
            if (cnt == Global.clicks) {
                Global.isToClick = true;
                Global.workingStatusButton.setText("Stopped clicking");
                Global.workingStatusButton.setForeground(Color.BLUE);
            }
        } catch (InterruptedException | AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Global.workingStatusButton.setText(I18NUtils.get("clicking"));
        Global.workingStatusButton.setForeground(Color.RED);
        if (Global.isToFreezePointer) {
            this.freezePointerClick();
        } else {
            if (Global.isSmartClick) {
                this.smartClick();
            } else {
                this.click();
            }
        }
    }
}