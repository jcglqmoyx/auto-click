package io.github.jcglqmoyx.service.impl;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import io.github.jcglqmoyx.global.Global;
import io.github.jcglqmoyx.service.HotKeyService;
import io.github.jcglqmoyx.utils.KeystrokeUtils;

import java.util.Set;

public class HotKeyServiceImpl implements HotKeyService {
    public static void handle(NativeKeyEvent event) {
        Set<Integer> keystrokeSet = KeystrokeUtils.getHotKeyKeyCodes(event);
        if (keystrokeSet.equals(Global.clickHotKeyKeyCodes)) {
            ClickServiceImpl.handle();
        } else if (keystrokeSet.equals(Global.recordHotKeyKeyCodes)) {
            RecordServiceImpl.handle();
        }
    }
}