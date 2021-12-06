package uk.co.mrdaly.adventofcode2021._01sonarsweep;


import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.IntegerFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SonarSweepTest {

    private SonarSweep sonarSweep;
    private List<Integer> testInputs;
    private List<Integer> actualInputs;

    @Before
    public void setup() {
        sonarSweep = new SonarSweep();
        testInputs = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
        actualInputs = IntegerFileReader
                .getInstance("_01sonarsweep/01input1.txt")
                .read()
                .collect(Collectors.toList());
    }

    @Test
    public void partOne_test() {
        int increaseCount = sonarSweep.partOne(testInputs);
        assertEquals(7, increaseCount);
    }

    @Test
    public void partOne() {

        int increaseCount = sonarSweep.partOne(actualInputs);
        assertEquals(1228, increaseCount);
    }

    @Test
    public void partTwo_test() {
        int increaseCount = sonarSweep.partTwo(testInputs);
        assertEquals(5, increaseCount);
    }

    @Test
    public void partTwo() {
        int increaseCount = sonarSweep.partTwo(actualInputs);
        assertEquals(1257, increaseCount);
    }
}