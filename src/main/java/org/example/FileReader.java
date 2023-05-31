package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    public static final String FILE_READ_ERROR = "Could not read file for some reason";
    public static List<String> readFile(String path){
        try {
            return Files.readAllLines(Path.of(path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            throw new RuntimeException(FILE_READ_ERROR);
        }
    }
}