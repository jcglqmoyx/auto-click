package io.github.jcglqmoyx.hander.impl;

import io.github.jcglqmoyx.hander.TextFieldInputLengthRestrictHandler;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class TextFieldInputLengthRestrictHandlerImpl extends TextFieldInputLengthRestrictHandler {
    private final int limit;

    public TextFieldInputLengthRestrictHandlerImpl(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) return;
        if ((this.getLength() + str.length()) <= this.limit) {
            super.insertString(offs, str, a);
        }
    }
}
