package uk.co.mrdaly.adventofcode2021.util;

import java.util.stream.Stream;

public class StringFileReader extends FileReader<String> {

    private StringFileReader(String path) {
        super(path);
    }

    @Override
    public Stream<String> read() {
        return readFile();
    }

    public static StringFileReader getInstance(String path) {
        return new StringFileReader(path);
    }

}
