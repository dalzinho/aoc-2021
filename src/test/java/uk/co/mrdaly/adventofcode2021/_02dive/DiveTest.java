package uk.co.mrdaly.adventofcode2021._02dive;

import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DiveTest {

    @Test
    public void partOne_sampleInput() {
        final List<String> steps = Arrays.asList(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"
        );
        int actual = new Dive().partOne(steps);
        assertEquals(150, actual);
    }

    @Test
    public void partOne() {
        final List<String> steps = StringFileReader.getInstance("_02dive/02input1.txt")
                .read()
                .collect(Collectors.toList());
        int actual = new Dive().partOne(steps);
        assertEquals(1868935, actual);
    }

    @Test
    public void partTwo_sampleData() {
        final List<String> steps = Arrays.asList(
                "forward 5",
                "down 5",
                "forward 8",
                "up 3",
                "down 8",
                "forward 2"
        );
        int actual = new Dive().partTwo(steps);
        assertEquals(900, actual);
    }

    @Test
    public void partTwo() {
        final List<String> steps = StringFileReader.getInstance("_02dive/02input1.txt")
                .read()
                .collect(Collectors.toList());
        int actual = new Dive().partTwo(steps);
        assertEquals(1965970888, actual);
    }
}