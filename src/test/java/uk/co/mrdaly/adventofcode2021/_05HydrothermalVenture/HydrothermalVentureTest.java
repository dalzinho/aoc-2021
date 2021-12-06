package uk.co.mrdaly.adventofcode2021._05HydrothermalVenture;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class HydrothermalVentureTest {

    private HydrothermalVenture hydrothermalVenture;

    final List<String> input = StringFileReader.getInstance("_05HydrothermalVenture/05input1.txt")
            .read().collect(Collectors.toList());

    private List<String> sampleInput;

    @Before
    public void setup() {
        sampleInput = Arrays.asList(
                "0,9 -> 5,9",
                "8,0 -> 0,8",
                "9,4 -> 3,4",
                "2,2 -> 2,1",
                "7,0 -> 7,4",
                "6,4 -> 2,0",
                "0,9 -> 2,9",
                "3,4 -> 1,4",
                "0,0 -> 8,8",
                "5,5 -> 8,2"
        );

        hydrothermalVenture = new HydrothermalVenture();
    }

    @Test
    public void partOne_sampleInput() {
        long actual = hydrothermalVenture.partOne(sampleInput);
        assertEquals(5, actual);
    }

    @Test
    public void partOne() {
        final long actual = hydrothermalVenture.partOne(input);
        assertEquals(6564, actual);
    }

    @Test
    public void partTwo_sampleInput() {
        long actual = hydrothermalVenture.partTwo(sampleInput);
        assertEquals(12, actual);
    }

    @Test
    public void partTwo() {
        final long actual = hydrothermalVenture.partTwo(input);
        assertEquals(19172, actual);
    }

}
