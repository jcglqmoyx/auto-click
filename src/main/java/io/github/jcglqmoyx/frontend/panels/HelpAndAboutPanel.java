package io.github.jcglqmoyx.frontend.panels;

import io.github.jcglqmoyx.utils.I18NUtils;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public final class HelpAndAboutPanel extends JPanel {
    private static HelpAndAboutPanel HELP_AND_ABOUT_PANEL;
    private static final String DOCUMENTATION_URL = "https://zhuanlan.zhihu.com/p/611186534";
    private static final String AUTHOR_CONTACT_URL = "https://linktree.cn/jcglqmoyx";

    private HelpAndAboutPanel() {
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.setLayout(new GridLayout(2, 1));

        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        final JButton helpButton = new JButton(I18NUtils.get("help"));
        helpButton.addActionListener(e -> {
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(DOCUMENTATION_URL));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(helpButton);

        final JButton aboutButton = new JButton(I18NUtils.get("contact.author"));
        aboutButton.addActionListener(e -> {
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(new URI(AUTHOR_CONTACT_URL));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(aboutButton);
    }

    private HelpAndAboutPanel(int x, int y, int width, int height) {
        this();
        this.setBounds(x, y, width, height);
    }

    public static HelpAndAboutPanel getInstance(int x, int y, int width, int height) {
        if (HELP_AND_ABOUT_PANEL == null) {
            HELP_AND_ABOUT_PANEL = new HelpAndAboutPanel(x, y, width, height);
        }
        return HELP_AND_ABOUT_PANEL;
    }
}