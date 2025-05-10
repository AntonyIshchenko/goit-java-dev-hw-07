package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private FileReader() {
    }

    public static String read(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
