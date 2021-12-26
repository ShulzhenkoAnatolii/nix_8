package ua.com.alevel.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadInputFile {

    public static String readInputFile(String nameFile) {
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameFile));
            while (reader.ready()) {
                line += reader.readLine() + "\n";
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return line;
    }
}
