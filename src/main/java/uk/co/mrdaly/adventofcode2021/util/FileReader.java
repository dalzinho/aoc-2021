package uk.co.mrdaly.adventofcode2021.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public abstract class FileReader<T> {

    private String path;

    protected FileReader(String path) {
        this.path = path;
    }

    abstract public Stream<T> read();

    protected Stream<String> readFile() {
        Stream<String> stream;
        try {
            ClassPathResource classPathResource = new ClassPathResource(path);
            final Path toPath = classPathResource.getFile().toPath();
            stream = Files.lines(toPath);
        } catch (IOException e) {
            System.err.println("couldnae load " + path);
            throw new RuntimeException();
        }
        return stream;
    }

}
