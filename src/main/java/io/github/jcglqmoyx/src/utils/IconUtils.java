package io.github.jcglqmoyx.src.utils;

import javax.swing.*;
import java.util.Objects;

public class IconUtils {
    public static final Icon NOTIFICATION = new ImageIcon(Objects.requireNonNull(AuthenticationUtils.class.getResource("/img/icon/notification.png")));
    public static final Icon WARNING = new ImageIcon(Objects.requireNonNull(AuthenticationUtils.class.getResource("/img/icon/warning.png")));
    public static final Icon ERROR = new ImageIcon(Objects.requireNonNull(AuthenticationUtils.class.getResource("/img/icon/error.png")));
}