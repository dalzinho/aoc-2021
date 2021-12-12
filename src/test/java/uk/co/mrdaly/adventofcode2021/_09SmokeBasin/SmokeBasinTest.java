package uk.co.mrdaly.adventofcode2021._09SmokeBasin;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SmokeBasinTest {

    private SmokeBasin smokeBasin;
    private List<String> sampleInput;
    private List<String> actualInput;

    @Before
    public void setup() {
        smokeBasin = new SmokeBasin();
        sampleInput = Arrays.asList(
                "2199943210",
                "3987894921",
                "9856789892",
                "8767896789",
                "9899965678"
        );
        actualInput = StringFileReader.getInstance("_09SmokeBasin/09input1.txt")
                .read()
                .collect(Collectors.toList());
    }

    @Test
    public void partOne_sampleData() {
        int actual = smokeBasin.partOne(sampleInput);
        assertEquals(15, actual);
    }

    @Test
    public void partOne_actualData() {
        int actual = smokeBasin.partOne(actualInput);
        assertEquals(532, actual);
    }

    @Test
    public void partTwo_sampleData() {
        int actual = smokeBasin.partTwo(sampleInput);
        assertEquals(1134, actual);
    }

    @Ignore
    @Test
    public void partTwo_actualData() {
        int actual = smokeBasin.partTwo(actualInput);
        assertEquals(15, actual);
    }
}
