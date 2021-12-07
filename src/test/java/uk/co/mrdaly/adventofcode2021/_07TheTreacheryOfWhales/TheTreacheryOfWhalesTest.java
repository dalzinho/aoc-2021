package uk.co.mrdaly.adventofcode2021._07TheTreacheryOfWhales;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TheTreacheryOfWhalesTest {

    private TheTreacheryOfWhales theTreacheryOfWhales;
    private List<Integer> sampleInput;
    private List<Integer> actualInput;

    @Before
    public void setup() {
        theTreacheryOfWhales = new TheTreacheryOfWhales();
        sampleInput = parseInput("16,1,2,0,4,2,7,1,2,14");
        actualInput = StringFileReader.getInstance("_07TheTreacheryOfWhales/07input1.txt").read()
                .map(this::parseInput)
                .findFirst()
                .get();
        System.out.println("ready!");
    }

    private List<Integer> parseInput(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Test
    public void partOne_sampleData() {
        long actual = theTreacheryOfWhales.partOne(sampleInput);
        assertEquals(37, actual);
    }

    @Test
    public void partOne() {
        long actual = theTreacheryOfWhales.partOne(actualInput);
        assertEquals(328262, actual);
    }

    @Test
    public void partTwo_sampleData() {
        long actual = theTreacheryOfWhales.partTwo(sampleInput);
        assertEquals(168, actual);
    }

    @Test
    public void partTwo() {
        long actual = theTreacheryOfWhales.partTwo(actualInput);
        assertEquals(90040997, actual);
    }


}
