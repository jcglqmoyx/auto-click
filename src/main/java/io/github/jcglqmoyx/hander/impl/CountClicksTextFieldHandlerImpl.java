package io.github.jcglqmoyx.hander.impl;

import io.github.jcglqmoyx.hander.CountClicksTextFieldHandler;

import java.awt.event.KeyEvent;

public class CountClicksTextFieldHandlerImpl implements CountClicksTextFieldHandler {
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
        if (!Character.isDigit(e.getKeyChar()) && e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
            e.consume();
        }
    }
}
