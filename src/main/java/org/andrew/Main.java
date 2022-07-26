package org.andrew;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\new project\\src\\main\\resources");
        setAllFilesPng(path);



    }
    public static void setAllFilesPng(Path path)

            throws IOException {

        try (Stream<Path> walk = Files.walk(path)) {
            walk
                    .filter(Files::isReadable)      // read permission
                    .filter(Files::isRegularFile)   // file only
                    .forEach(p -> {
                        if (!FilenameUtils.getExtension(p.getFileName().toString()).equals("pdf")){

                            try {
                                Files.move(p, p.resolveSibling(p+".png"));
                                //add file extention png

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
    }
}
