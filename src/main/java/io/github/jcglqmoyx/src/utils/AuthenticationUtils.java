package io.github.jcglqmoyx.src.utils;

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
            JOptionPane.showMessageDialog(null, "Your machine is not supported. Please contact the developer.", "Unsupported machine", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
            return false;
        }
        File credentials = new File(CREDENTIALS_PATH);
        if (!credentials.exists()) {
            String activationCode = JOptionPane.showInputDialog(null, "Please enter your activation code.", "credentials not found", JOptionPane.INFORMATION_MESSAGE, IconUtils.NOTIFICATION, null, null).toString();
            JSONObject obj = new JSONObject(HttpUtils.post(activationCode, OSUtils.getOSName(), machineID));
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
                String message = String.format("Your credential file %s is invalid. Delete it and reopen the app", CREDENTIALS_PATH);
                JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                return false;
            }
            String activationCode = FileUtils.readFromFile(CREDENTIALS_PATH);
            JSONObject obj = new JSONObject(HttpUtils.post(activationCode, OSUtils.getOSName(), machineID));
            String result = obj.getString("result");
            if (result.equals("success")) {
                return true;
            } else {
                if (credentials.delete()) {
                    String message = obj.getString("error_message");
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                } else {
                    String message = String.format("Credential file %s is invalid, please delete it and retry.", CREDENTIALS_PATH);
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE, IconUtils.ERROR);
                }
                return false;
            }
        }
    }
}
