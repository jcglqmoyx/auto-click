package io.github.jcglqmoyx;

import com.github.kwhat.jnativehook.NativeHookException;
import io.github.jcglqmoyx.frontend.window.MainWindow;
import io.github.jcglqmoyx.utils.AuthenticationUtils;
import org.json.JSONException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws NativeHookException, IOException, JSONException {
//        if (!AuthenticationUtils.authenticate()) {
//            System.exit(1);
//        }
        new MainWindow();
    }
}
