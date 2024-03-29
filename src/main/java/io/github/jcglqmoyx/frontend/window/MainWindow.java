package io.github.jcglqmoyx.frontend.window;

import com.github.kwhat.jnativehook.NativeHookException;
import io.github.jcglqmoyx.frontend.base.NativeFrame;
import io.github.jcglqmoyx.frontend.panels.*;
import io.github.jcglqmoyx.global.Global;
import io.github.jcglqmoyx.utils.I18NUtils;

import javax.swing.*;

public class MainWindow extends NativeFrame {
    public MainWindow() throws NativeHookException {
        super(I18NUtils.get("title"));
        this.setLayout(null);

        this.add(MouseSettingsPanel.getInstance(10, 10, 230, 80));
        this.add(CountClicksSettingPanel.getInstance(250, 10, 230, 80));
        this.add(TimeIntervalSettingsPanel.getInstance(10, 100, 470, 80));
        this.add(AdditionalSettingsPanel.getInstance(10, 190, 230, 80));
        this.add(SmartClickSettingPanel.getInstance(10, 280, 230, 100));
        this.add(HotKeySettingsPanel.getInstance(250, 190, 230, 80));
        this.add(HelpAndAboutPanel.getInstance(250, 280, 230, 100));
        this.add(WorkingStatusPanel.getInstance(10, 390, 470, 50));

        int height = 0;
        if (Global.OS.contains("mac")) {
            height = 480;
        } else if (Global.OS.contains("linux")) {
            height = 550;
        } else if (Global.OS.contains("windows")) {
            height = 480;
        }
        this.setSize(500, height);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}