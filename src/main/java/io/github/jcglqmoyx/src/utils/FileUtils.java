package io.github.jcglqmoyx.src.utils;

import java.io.*;

public class FileUtils {
    public static boolean isValidFilename(String filename) {
        return filename.matches("[a-zA-Z0-9_]+");
    }

    public static void writeToFile(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.createNewFile()) {
            return;
        }
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String readFromFile(String path) {
        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
