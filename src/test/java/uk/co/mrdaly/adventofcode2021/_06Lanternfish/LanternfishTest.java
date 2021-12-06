package uk.co.mrdaly.adventofcode2021._06Lanternfish;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.IntegerFileReader;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class LanternfishTest {

    private Lanternfish lanternfish;
    private List<Integer> sampleInput;
    private List<Integer> actualInputs;

    @Before
    public void setup() {
        lanternfish = new Lanternfish();
        sampleInput = Arrays.asList(
                3,4,3,1,2
        );
        actualInputs = StringFileReader.getInstance("_06Lanternfish/06input1.txt")
                .read()
                .flatMap(s -> Arrays.stream(s.split(",")))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Test
    public void partOne_sampleInputs() {
        int generations = 80;
        long actual = lanternfish.partOne(sampleInput, generations);
        assertEquals(5934, actual);
    }

    @Test
    public void partOne() {
        int generations = 80;
        long actual = lanternfish.partOne(actualInputs, generations);
        assertEquals(354564, actual);
    }

    @Test
    public void partTwo_sampleInputs() {
        int generations = 256;
        long actual = lanternfish.partOne(sampleInput, generations);
        assertEquals(26984457539L, actual);
    }

    @Test
    public void partTwo() {
        int generations = 256;
        long actual = lanternfish.partOne(actualInputs, generations);
        assertEquals(1609058859115L, actual);
    }
}
