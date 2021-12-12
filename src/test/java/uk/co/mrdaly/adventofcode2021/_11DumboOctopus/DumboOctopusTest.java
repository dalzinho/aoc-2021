package uk.co.mrdaly.adventofcode2021._11DumboOctopus;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DumboOctopusTest {

    private DumboOctopus dumboOctopus;
    private List<String> simpleInput;
    private List<String> sampleInput;
    private List<String> actualInput;

    @Before
    public void setup() {
        dumboOctopus = new DumboOctopus();
        simpleInput = Arrays.asList(
                "11111",
                "19991",
                "19191",
                "19991",
                "11111"
        );

        sampleInput = Arrays.asList(
                "5483143223",
                "2745854711",
                "5264556173",
                "6141336146",
                "6357385478",
                "4167524645",
                "2176841721",
                "6882881134",
                "4846848554",
                "5283751526"
        );
        actualInput = StringFileReader.getInstance("_11DumboOctopus/11input1.txt")
                .read()
                .collect(Collectors.toList());
    }

    @Test
    public void partOne_simpleData() {
        long actual = dumboOctopus.partOne(simpleInput, 1);
        assertEquals(9, actual);
    }

    @Test
    public void partOne_sampleData() {
        long actual = dumboOctopus.partOne(sampleInput, 100);
        assertEquals(1656, actual);
    }

    @Test
    public void partOne_actualData() {
        long actual = dumboOctopus.partOne(actualInput, 100);
        assertEquals(1562, actual);
    }

    @Test
    public void partTwo_sampleData() {
        int actual = dumboOctopus.partTwo(sampleInput);
        assertEquals(195, actual);
    }

    @Test
    public void partTwo_actualData() {
        int actual = dumboOctopus.partTwo(actualInput);
        assertEquals(268, actual);
    }
}
