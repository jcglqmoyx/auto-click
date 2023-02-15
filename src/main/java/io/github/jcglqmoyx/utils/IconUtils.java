package io.github.jcglqmoyx.utils;

import javax.swing.*;
import java.util.Objects;

public class IconUtils {
    public static final Icon NOTIFICATION = new ImageIcon(Objects.requireNonNull(AuthenticationUtils.class.getResource("/static/img/icon/notification.png")));
    public static final Icon WARNING = new ImageIcon(Objects.requireNonNull(AuthenticationUtils.class.getResource("/static/img/icon/warning.png")));
    public static final Icon ERROR = new ImageIcon(Objects.requireNonNull(AuthenticationUtils.class.getResource("/static/img/icon/error.png")));
}