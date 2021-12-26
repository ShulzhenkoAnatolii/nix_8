package ua.com.alevel.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteOutFile {

    public static void write(String path, String str) {
        Path current = Paths.get(path);
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException exception) {
            System.out.println(path + " cannot be written");
        }
    }
}
