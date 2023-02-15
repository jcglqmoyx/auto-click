package io.github.jcglqmoyx.entity;

import java.awt.event.KeyEvent;

public class PointEntity {
    private final int x;
    private final int y;
    private int button;
    private boolean isDoubleClick;
    private int delay;

    public PointEntity(int x, int y) {
        this.x = x;
        this.y = y;
        this.button = KeyEvent.BUTTON1_DOWN_MASK;
        this.isDoubleClick = false;
        this.delay = 2000;
    }

    public void setButton(int button) {
        this.button = button;
    }

    public void setDoubleClick(boolean isDoubleClick) {
        this.isDoubleClick = isDoubleClick;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getButton() {
        return button;
    }

    public boolean isDoubleClick() {
        return isDoubleClick;
    }

    public int getDelay() {
        return delay;
    }
}