package io.github.jcglqmoyx.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NUtils {
    private static final ResourceBundle resourceBundle;

    private I18NUtils() {
    }

    static {
        Locale locale = Locale.getDefault();
        if (locale.getLanguage().equals("zh")) {
            if (locale.getCountry().equals("CN")) {
                resourceBundle = ResourceBundle.getBundle("i18n/zh_CN");
            } else {
                resourceBundle = ResourceBundle.getBundle("i18n/zh_TW");
            }
        } else {
            resourceBundle = ResourceBundle.getBundle("i18n/en");
        }
    }

    public static String get(String key) {
        return resourceBundle.getString(key);
    }
}
