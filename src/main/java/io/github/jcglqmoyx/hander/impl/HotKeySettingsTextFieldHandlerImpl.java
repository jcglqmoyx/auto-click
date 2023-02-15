package io.github.jcglqmoyx.hander.impl;

import io.github.jcglqmoyx.global.Global;
import io.github.jcglqmoyx.hander.HotKeySettingTextFieldHandler;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Set;
import java.util.TreeSet;

public class HotKeySettingsTextFieldHandlerImpl implements HotKeySettingTextFieldHandler {
    private final int hotKeyType;
    private final JTextField hotKeyTextField;
    private final StringBuilder hotKeyText;
    private final Set<Integer> hotKeyKeyCodes;
    private long lastTime;
    private static final long INTERVAL = 200; // unit: millisecond

    private boolean isHotKeyModifiable = false;

    public HotKeySettingsTextFieldHandlerImpl(JTextField clickHotKeyTextField, int type) {
        this.hotKeyType = type;
        this.hotKeyTextField = clickHotKeyTextField;
        this.hotKeyText = new StringBuilder();
        this.hotKeyKeyCodes = new TreeSet<>();
        this.lastTime = -1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!this.isHotKeyModifiable) {
            return;
        }
        int keyCode = e.getKeyCode();
        this.hotKeyText.setLength(0);
        long currentTime = System.currentTimeMillis();

        if (lastTime != -1 && currentTime - lastTime > INTERVAL || this.hotKeyKeyCodes.contains(keyCode)) {
            this.hotKeyKeyCodes.clear();
        }

        if (KeyEvent.getKeyText(keyCode).isEmpty()) {
            this.hotKeyKeyCodes.clear();
            this.hotKeyTextField.setText("Invalid");
            return;
        }

        this.hotKeyKeyCodes.add(keyCode);
        if (this.hotKeyKeyCodes.size() > 5) {
            this.hotKeyKeyCodes.clear();
            this.hotKeyText.setLength(0);
            this.hotKeyTextField.setText("Too many keys");
            return;
        }

        for (Integer key : this.hotKeyKeyCodes) {
            this.hotKeyText.append(KeyEvent.getKeyText(key)).append("+");
        }
        this.hotKeyText.setLength(this.hotKeyText.length() - 1);
        this.hotKeyTextField.setText(this.hotKeyText.toString());

        if (this.hotKeyType == Global.CLICK_HOT_KEY_FLAG) {
            if (this.hotKeyKeyCodes.equals(Global.recordHotKeyKeyCodes)) {
                this.hotKeyKeyCodes.clear();
                this.hotKeyTextField.setText("Invalid");
            } else {
                Global.clickHotKeyKeyCodes = this.hotKeyKeyCodes;
            }
        } else if (this.hotKeyType == Global.RECORD_HOT_KEY_FLAG) {
            if (this.hotKeyKeyCodes.equals(Global.clickHotKeyKeyCodes)) {
                this.hotKeyKeyCodes.clear();
                this.hotKeyTextField.setText("Invalid");
            } else {
                Global.recordHotKeyKeyCodes = this.hotKeyKeyCodes;
            }
        }
        lastTime = currentTime;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.isHotKeyModifiable = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isHotKeyModifiable = false;
    }
}
