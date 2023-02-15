package io.github.jcglqmoyx.src.utils;

import io.github.jcglqmoyx.src.global.Global;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class AuthenticationUtils {
    private static final String CREDENTIALS_PATH = System.getProperty("user.home") + "/.clicker_credentials";

    public static boolean authenticate() throws IOException, JSONException {
        String machineID = OSUtils.getMachineID();
        if (machineID == null) {
            JOptionPane.showMessageDialog(null, I18NUtils.get("machine.not.supported"), I18NUtils.get("unsupported.machine"), JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
            return false;
        }
        File credentials = new File(CREDENTIALS_PATH);
        if (!credentials.exists()) {
            String activationCode = JOptionPane.showInputDialog(null, I18NUtils.get("enter.credentials"), I18NUtils.get("credentials.not.found"), JOptionPane.INFORMATION_MESSAGE, IconUtils.NOTIFICATION, null, null).toString();
            JSONObject obj = new JSONObject(HttpUtils.post(activationCode, Global.OS, machineID));
            String result = obj.getString("result");
            if (result.equals("success")) {
                FileUtils.writeToFile(CREDENTIALS_PATH, activationCode);
                return true;
            } else if (result.equals("trial not expired") || result.equals("trial started")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, obj.getString("error_message"), "Error", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                return false;
            }
        } else {
            if (credentials.length() > 1024) {
                String message = I18NUtils.get("invalid.credentials") + "(" + CREDENTIALS_PATH + ").";
                JOptionPane.showMessageDialog(null, message, I18NUtils.get("error"), JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                return false;
            }
            String activationCode = FileUtils.readFromFile(CREDENTIALS_PATH);
            JSONObject obj = new JSONObject(HttpUtils.post(activationCode, Global.OS, machineID));
            String result = obj.getString("result");
            if (result.equals("success")) {
                return true;
            } else {
                if (credentials.delete()) {
                    String message = obj.getString("error_message");
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                } else {
                    String message = I18NUtils.get("invalid.credentials") + "(" + CREDENTIALS_PATH + ").";
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                }
                return false;
            }
        }
    }
}
