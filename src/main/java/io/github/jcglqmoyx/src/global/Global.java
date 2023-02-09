package io.github.jcglqmoyx.src.global;

import io.github.jcglqmoyx.src.entity.PointEntity;
import io.github.jcglqmoyx.src.utils.OSUtils;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Global {
    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final int CLICK_HOT_KEY_FLAG = 1;
    public static final int RECORD_HOT_KEY_FLAG = 2;
    public static final int DEFAULT_CLICKS = Integer.MAX_VALUE;
    public final static int COUNT_CLICK_TEXT_FIELD_MAXIMUM_INPUT_LENGTH_LIMIT = 8;

    public static JComboBox<String> mouseButtonComboBox;
    public static JComboBox<String> clickComboBox;
    public static JSpinner[] timeIntervalSpinner;

    public static boolean isSmartClick = false;
    public static JCheckBox smartClickCheckBox;

    public static boolean isToFreezePointer = false;
    public static JCheckBox freezePointerCheckBox;

    public static long clicks = DEFAULT_CLICKS;

    public static int clickTimeInterval = 2000;

    public static int buttonToClick = InputEvent.BUTTON1_DOWN_MASK;

    public static boolean isToDoubleClick = false;

    public static boolean isToClick = true;

    public static Set<Integer> clickHotKeyKeyCodes;
    public static Set<Integer> recordHotKeyKeyCodes;

    public static List<PointEntity> pointsList;

    static {
        pointsList = new ArrayList<>();
    }

    public static JTextField recordTextField;
    public static JLabel recordNumberLabel;

    public static JFrame recordWindow;

    public static JButton workingStatusButton;
}
