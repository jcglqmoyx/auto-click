package io.github.jcglqmoyx.src.service.impl;

import io.github.jcglqmoyx.src.frontend.window.RecordWindow;
import io.github.jcglqmoyx.src.global.Global;
import io.github.jcglqmoyx.src.service.RecordService;

import javax.swing.*;

public class RecordServiceImpl implements RecordService {
    private static JFrame recordWindow;

    public static void handle() {
        if (recordWindow == null || !recordWindow.isDisplayable()) {
            record();
        } else {
            stopRecording();
        }
    }

    private static void record() {
        recordWindow = new RecordWindow();
        Global.recordWindow = recordWindow;
    }

    private static void stopRecording() {
        recordWindow.dispose();
    }
}
