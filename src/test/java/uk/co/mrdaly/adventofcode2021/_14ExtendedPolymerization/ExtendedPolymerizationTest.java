package uk.co.mrdaly.adventofcode2021._14ExtendedPolymerization;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ExtendedPolymerizationTest {

    private ExtendedPolymerization extendedPolymerization;
    private List<String> sampleInput;
    private List<String> actualInput;

    @Before
    public void setup() {
        extendedPolymerization = new ExtendedPolymerization();
        sampleInput = Arrays.asList(
                "NNCB",
                "",
                "CH -> B",
                "HH -> N",
                "CB -> H",
                "NH -> C",
                "HB -> C",
                "HC -> B",
                "HN -> C",
                "NN -> C",
                "BH -> H",
                "NC -> B",
                "NB -> B",
                "BN -> B",
                "BB -> N",
                "BC -> B",
                "CC -> N",
                "CN -> C"
        );

        actualInput = StringFileReader.getInstance("_14ExtendedPolymerization/14input1.txt")
                .read().collect(Collectors.toList());
    }

    @Test
    public void partOne_sampleData() {
        long actual = extendedPolymerization.partOne(sampleInput, 10);
        assertEquals(1588, actual);
    }

    @Test
    public void partOne_actualData() {
        long actual = extendedPolymerization.partOne(actualInput, 10);
        assertEquals(2703, actual);
    }

    @Test
    public void partTwo_sampleData() {
        long actual = extendedPolymerization.partOne(sampleInput, 40);
        assertEquals(2188189693529L, actual);
    }
    @Test
    public void partTwo_actualData() {
        long actual = extendedPolymerization.partOne(actualInput, 40);
        assertEquals(2984946368465L, actual);
    }

}