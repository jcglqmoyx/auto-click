package io.github.jcglqmoyx.hander.impl;

import io.github.jcglqmoyx.hander.CountClicksTextFieldHandler;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class CountClicksTextFieldHandlerImpl implements CountClicksTextFieldHandler {
    private final Set<Integer> allowedKeyCodes;
    private final JCheckBox counterCheckBox;

    public CountClicksTextFieldHandlerImpl(JCheckBox counterCheckBox) {
        this.allowedKeyCodes = new HashSet<>();
        this.allowedKeyCodes.add(KeyEvent.VK_LEFT);
        this.allowedKeyCodes.add(KeyEvent.VK_RIGHT);
        this.allowedKeyCodes.add(KeyEvent.VK_DELETE);
        this.allowedKeyCodes.add(KeyEvent.VK_BACK_SPACE);
        this.counterCheckBox = counterCheckBox;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.handleEvent(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.handleEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.handleEvent(e);
    }

    private void handleEvent(KeyEvent e) {
        this.counterCheckBox.setSelected(false);
        char keyChar = e.getKeyChar();
        if (!Character.isDigit(keyChar) && !this.allowedKeyCodes.contains(e.getKeyCode())) {
            e.consume();
        }
    }
}
