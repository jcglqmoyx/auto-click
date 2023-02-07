package io.github.jcglqmoyx.src.utils;

import io.github.jcglqmoyx.src.entity.PointEntity;
import io.github.jcglqmoyx.src.global.Global;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class RecordScriptUtils {
    public static String generatePythonScript() {
        if (Global.pointsList.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("import time\n\n");
        builder.append("import pyautogui as p\n\n");
        builder.append(String.format("for i in range(%d):\n", Global.clicks));
        for (int i = 0; i < Global.pointsList.size(); i++) {
            PointEntity point = Global.pointsList.get(i);
            builder.append(String.format("\tp.moveTo(%d, %d)\n", point.getX(), point.getY()));
            int cnt = point.isDoubleClick() ? 2 : 1;
            if (point.getButton() == KeyEvent.BUTTON1_DOWN_MASK) {
                for (int it = 0; it < cnt; it++) {
                    builder.append("\tp.leftClick()\n");
                }
            } else if (point.getButton() == KeyEvent.BUTTON2_DOWN_MASK) {
                for (int it = 0; it < cnt; it++) {
                    builder.append("\tp.middleClick()\n");
                }
            } else {
                for (int it = 0; it < cnt; it++) {
                    builder.append("\tp.rightClick()\n");
                }
            }
            builder.append(String.format("\ttime.sleep(%.3f)\n", point.getDelay() / 1000.0));
        }
        return builder.toString();
    }

    public static boolean loadScript(String path) {
        try {
            Global.pointsList.clear();
            File file = new File(path);
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            String prevLine = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("for i in range")) {
                    int clicks = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                            clicks = clicks * 10 + line.charAt(i) - '0';
                        }
                    }
                    Global.clicks = clicks;
                } else if (line.startsWith("\tp.moveTo")) {
                    int indexOfLeftParenthesis = line.indexOf('(');
                    int indexOfComma = line.indexOf(',');
                    int indexOfRightParenthesis = line.indexOf(')');
                    int x = Integer.parseInt(line.substring(indexOfLeftParenthesis + 1, indexOfComma));
                    int y = Integer.parseInt(line.substring(indexOfComma + 2, indexOfRightParenthesis));
                    PointEntity point = new PointEntity(x, y);
                    Global.pointsList.add(point);
                } else if (line.contains("Click")) {
                    if (line.equals(prevLine)) {
                        Global.pointsList.get(Global.pointsList.size() - 1).setDoubleClick(true);
                    } else {
                        String type = line.substring(3, line.indexOf("Click"));
                        if (type.equals("left")) {
                            Global.pointsList.get(Global.pointsList.size() - 1).setButton(KeyEvent.BUTTON1_DOWN_MASK);
                        } else if (type.equals("middle")) {
                            Global.pointsList.get(Global.pointsList.size() - 1).setButton(KeyEvent.BUTTON2_DOWN_MASK);
                        } else {
                            Global.pointsList.get(Global.pointsList.size() - 1).setButton(KeyEvent.BUTTON3_DOWN_MASK);
                        }
                    }
                } else if (line.contains("sleep")) {
                    int indexOfLeftParenthesis = line.indexOf('(');
                    int indexOfRightParenthesis = line.indexOf(')');
                    double delay = Double
                            .parseDouble(line.substring(indexOfLeftParenthesis + 1, indexOfRightParenthesis)) * 1000;
                    Global.pointsList.get(Global.pointsList.size() - 1).setDelay((int) delay);
                }
                prevLine = line;
            }
            scanner.close();
            Global.recordTextField.setText(String.valueOf(Global.pointsList.size()));
            if (Global.recordNumberLabel != null) {
                Global.recordNumberLabel.setText(String.valueOf(Global.pointsList.size()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
