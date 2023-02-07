package io.github.jcglqmoyx.src;

import com.github.kwhat.jnativehook.NativeHookException;
import io.github.jcglqmoyx.src.frontend.window.MainWindow;
import io.github.jcglqmoyx.src.utils.AuthenticationUtils;
import org.json.JSONException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NativeHookException, IOException, JSONException {
        if (!AuthenticationUtils.authenticate()) {
            System.exit(1);
        }
        new MainWindow();
    }
}
