package org.andrew;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        System.out.println("Hello world");
        try (Stream<Path> entries = Files.walk(path)){
            System.out.println();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
