package io.github.jcglqmoyx.service.impl;

import io.github.jcglqmoyx.global.Global;
import io.github.jcglqmoyx.service.ClickService;
import io.github.jcglqmoyx.utils.ClickUtils;

import java.awt.*;

public class ClickServiceImpl implements ClickService {
    private static final ClickUtils clickUtils;
    private static Thread clickThread;

    static {
        clickUtils = ClickUtils.getInstance();
    }

    public static void handle() {
        if (Global.isToClick) {
            Global.isToClick = false;
            click();
        } else {
            Global.isToClick = true;
            stopClicking();
        }
    }

    private static void click() {
        clickThread = new Thread(clickUtils);
        clickThread.start();
    }

    private static void stopClicking() {
        clickThread.interrupt();
        Global.workingStatusButton.setForeground(Color.BLUE);
        Global.workingStatusButton.setText("Stopped clicking");
    }
}