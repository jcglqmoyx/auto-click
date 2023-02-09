package io.github.jcglqmoyx.src.utils;

import io.github.jcglqmoyx.src.global.Global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSUtils {
    private static String getWindowsMachineID() throws IOException {
        String command = "wmic csproduct get UUID";
        StringBuilder output = new StringBuilder();

        Process SerNumProcess = Runtime.getRuntime().exec(command);
        BufferedReader sNumReader = new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));

        String line;
        while ((line = sNumReader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.substring(output.indexOf("\n"), output.length()).trim();
    }

    private static String getLinuxMachineID() throws IOException {
        String command = "cat /var/lib/dbus/machine-id";
        StringBuilder output = new StringBuilder();

        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }
        return output.toString();
    }

    private static String getMacMachineID() throws IOException {
        String command = "system_profiler SPHardwareDataType | awk '/UUID/ { print $3; }'";
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        String machineID = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains("UUID:")) {
                machineID = line.substring(line.indexOf("UUID: ")).replace("UUID: ", "");
            }
        }
        reader.close();
        return machineID;
    }

    public static String getMachineID() throws IOException {
        String OS = Global.OS;
        if (OS.contains("win")) {
            return getWindowsMachineID();
        } else if (OS.contains("nix") || OS.contains("nux") || OS.contains("aix")) {
            return getLinuxMachineID();
        } else if (OS.contains("mac")) {
            return getMacMachineID();
        } else {
            return null;
        }
    }
}
