package uk.co.mrdaly.adventofcode2021.util;

import java.util.stream.Stream;

public class IntegerFileReader extends FileReader<Integer> {

    private IntegerFileReader(String path) {
        super(path);
    }

    @Override
    public Stream<Integer> read() {
        return readFile().mapToInt(Integer::parseInt).boxed();
    }

    public static IntegerFileReader getInstance(String path) {
        return new IntegerFileReader(path);
    }
}
