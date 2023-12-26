package com.example.algorithms.advent2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public final class Util {
    private Util () {}

    private static final String URL = "C:\\hudson\\data-and-algorithms\\src\\com\\example\\algorithms\\advent2023";

    public static List<String> readFile(String packageName, String fileName) throws IOException {
        Path path = Paths.get(URL + "\\" + packageName + "\\" + fileName);
        Stream<String> lines = Files.lines(path);
        return lines.toList();
    }

}
