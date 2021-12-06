package uk.co.mrdaly.adventofcode2021._03BinaryDiagnostic;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BinaryDiagnosticTest {

    private BinaryDiagnostic binaryDiagnostic;
    private List<String> sampleData;

    @Before
    public void setup() {
        binaryDiagnostic = new BinaryDiagnostic();
        sampleData = Arrays.asList(
                "00100",
                "11110",
                "10110",
                "10111",
                "10101",
                "01111",
                "00111",
                "11100",
                "10000",
                "11001",
                "00010",
                "01010"
        );
    }
    @Test
    public void partOne_sampleInput() {
        int actual = binaryDiagnostic.partOne(sampleData);
        assertEquals(198, actual);
    }

    @Test
    public void partOne() {
        final List<String> input = StringFileReader.getInstance("_03BinaryDiagnostic/03input1.txt")
                .read()
                .collect(Collectors.toList());
        int actual = binaryDiagnostic.partOne(input);
        assertEquals(775304, actual);
    }

    @Test
    public void partTwo_sampleData() {
        int actual = binaryDiagnostic.partTwo(sampleData);
        assertEquals(230, actual);
    }

    @Test
    public void partTwo() {
        final List<String> input = StringFileReader.getInstance("_03BinaryDiagnostic/03input1.txt")
                .read()
                .collect(Collectors.toList());
        int actual = binaryDiagnostic.partTwo(input);
        assertEquals(1370737, actual);
    }
}