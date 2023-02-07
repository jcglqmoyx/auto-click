package io.github.jcglqmoyx.src.utils;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeystrokeUtils {
    private static long lastTime;
    public static Set<Integer> keystrokeSet;
    private static final long INTERVAL = 200; // unit: millisecond
    private static final Map<Integer, Integer> NATIVE_KEY_CODE_TO_JAVA_KEY_CODE;

    static {
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE = new HashMap<>();

        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_ESCAPE, KeyEvent.VK_ESCAPE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F1, KeyEvent.VK_F1);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F2, KeyEvent.VK_F2);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F3, KeyEvent.VK_F3);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F4, KeyEvent.VK_F4);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F5, KeyEvent.VK_F5);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F6, KeyEvent.VK_F6);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F7, KeyEvent.VK_F7);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F8, KeyEvent.VK_F8);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F9, KeyEvent.VK_F9);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F10, KeyEvent.VK_F10);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F11, KeyEvent.VK_F11);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F12, KeyEvent.VK_F12);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F13, KeyEvent.VK_F13);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F14, KeyEvent.VK_F14);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F15, KeyEvent.VK_F15);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F16, KeyEvent.VK_F16);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F17, KeyEvent.VK_F17);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F18, KeyEvent.VK_F18);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F19, KeyEvent.VK_F19);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F20, KeyEvent.VK_F20);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F21, KeyEvent.VK_F21);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F22, KeyEvent.VK_F22);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F23, KeyEvent.VK_F23);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F24, KeyEvent.VK_F24);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_BACKQUOTE, KeyEvent.VK_BACK_QUOTE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_1, KeyEvent.VK_1);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_2, KeyEvent.VK_2);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_3, KeyEvent.VK_3);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_4, KeyEvent.VK_4);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_5, KeyEvent.VK_5);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_6, KeyEvent.VK_6);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_7, KeyEvent.VK_7);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_8, KeyEvent.VK_8);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_9, KeyEvent.VK_9);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_0, KeyEvent.VK_0);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_MINUS, KeyEvent.VK_MINUS);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_EQUALS, KeyEvent.VK_EQUALS);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_BACKSPACE, KeyEvent.VK_BACK_SPACE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_TAB, KeyEvent.VK_TAB);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_CAPS_LOCK, KeyEvent.VK_CAPS_LOCK);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_A, KeyEvent.VK_A);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_B, KeyEvent.VK_B);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_C, KeyEvent.VK_C);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_D, KeyEvent.VK_D);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_E, KeyEvent.VK_E);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_F, KeyEvent.VK_F);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_G, KeyEvent.VK_G);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_H, KeyEvent.VK_H);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_I, KeyEvent.VK_I);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_J, KeyEvent.VK_J);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_K, KeyEvent.VK_K);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_L, KeyEvent.VK_L);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_M, KeyEvent.VK_M);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_N, KeyEvent.VK_N);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_O, KeyEvent.VK_O);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_P, KeyEvent.VK_P);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_Q, KeyEvent.VK_Q);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_R, KeyEvent.VK_R);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_S, KeyEvent.VK_S);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_T, KeyEvent.VK_T);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_U, KeyEvent.VK_U);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_V, KeyEvent.VK_V);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_W, KeyEvent.VK_W);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_X, KeyEvent.VK_X);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_Y, KeyEvent.VK_Y);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_Z, KeyEvent.VK_Z);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_OPEN_BRACKET, KeyEvent.VK_OPEN_BRACKET);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_CLOSE_BRACKET, KeyEvent.VK_CLOSE_BRACKET);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_BACK_SLASH, KeyEvent.VK_BACK_SLASH);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SEMICOLON, KeyEvent.VK_SEMICOLON);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_QUOTE, KeyEvent.VK_QUOTE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_ENTER, KeyEvent.VK_ENTER);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_COMMA, KeyEvent.VK_COMMA);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_PERIOD, KeyEvent.VK_PERIOD);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SLASH, KeyEvent.VK_SLASH);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SPACE, KeyEvent.VK_SPACE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_PRINTSCREEN, KeyEvent.VK_PRINTSCREEN);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SCROLL_LOCK, KeyEvent.VK_SCROLL_LOCK);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_PAUSE, KeyEvent.VK_PAUSE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_INSERT, KeyEvent.VK_INSERT);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_DELETE, KeyEvent.VK_DELETE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_HOME, KeyEvent.VK_HOME);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_END, KeyEvent.VK_END);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_PAGE_UP, KeyEvent.VK_PAGE_UP);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_PAGE_DOWN, KeyEvent.VK_PAGE_DOWN);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_UP, KeyEvent.VK_UP);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_LEFT, KeyEvent.VK_LEFT);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_CLEAR, KeyEvent.VK_CLEAR);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_RIGHT, KeyEvent.VK_RIGHT);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_DOWN, KeyEvent.VK_DOWN);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_NUM_LOCK, KeyEvent.VK_NUM_LOCK);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SEPARATOR, KeyEvent.VK_SEPARATOR);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SHIFT, KeyEvent.VK_SHIFT);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_CONTROL, KeyEvent.VK_CONTROL);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_ALT, KeyEvent.VK_ALT);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_META, KeyEvent.VK_META);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_CONTEXT_MENU, KeyEvent.VK_CONTEXT_MENU);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_MEDIA_STOP, KeyEvent.VK_STOP);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_VOLUME_UP, KeyEvent.VK_UP);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_VOLUME_DOWN, KeyEvent.VK_DOWN);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_KATAKANA, KeyEvent.VK_KATAKANA);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_UNDERSCORE, KeyEvent.VK_UNDERSCORE);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_KANJI, KeyEvent.VK_KANJI);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_HIRAGANA, KeyEvent.VK_HIRAGANA);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_HELP, KeyEvent.VK_HELP);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_STOP, KeyEvent.VK_STOP);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_FIND, KeyEvent.VK_FIND);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_AGAIN, KeyEvent.VK_AGAIN);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_UNDO, KeyEvent.VK_UNDO);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_COPY, KeyEvent.VK_COPY);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_INSERT, KeyEvent.VK_INSERT);
        NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.put(NativeKeyEvent.VC_SUN_CUT, KeyEvent.VK_CUT);
    }

    public static Set<Integer> getHotKeyKeyCodes(NativeKeyEvent e) {
        if (keystrokeSet == null) {
            lastTime = -1;
            keystrokeSet = new HashSet<>();
        }

        long currentTime = System.currentTimeMillis();

        if (lastTime != -1 && currentTime - lastTime > INTERVAL || keystrokeSet.contains(e.getKeyCode())) {
            keystrokeSet.clear();
        }

        if (!NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.containsKey(e.getKeyCode())) {
            keystrokeSet.clear();
            return keystrokeSet;
        }

        int keyCode = NATIVE_KEY_CODE_TO_JAVA_KEY_CODE.get(e.getKeyCode());

        keystrokeSet.add(keyCode);
        if (keystrokeSet.size() > 5) {
            keystrokeSet.clear();
            return keystrokeSet;
        }

        lastTime = currentTime;
        return keystrokeSet;
    }
}
