package uk.co.mrdaly.adventofcode2021._04giantsquid;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class GiantSquidTest {

    private String calledNumbers;
    private List<String> sampleCards;
    private GiantSquid giantSquid;

    @Before
    public void setup() {
        calledNumbers = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1";
        sampleCards = Arrays.asList("22 13 17 11  0",
                "8  2 23  4 24",
                "21  9 14 16  7",
                "6 10  3 18  5",
                "1 12 20 15 19",
                "",
                "3 15  0  2 22",
                "9 18 13 17  5",
                "19  8  7 25 23",
                "20 11 10 24  4",
                "14 21 16 12  6",
                "",
                "14 21 17 24  4",
                "10 16 15  9 19",
                "18  8 23 26 20",
                "22 11 13  6  5",
                "2  0 12  3  7");

        giantSquid = new GiantSquid();
    }

    @Test
    public void partOne_sampleData() {
        int actual = giantSquid.partOne(calledNumbers, sampleCards);
        assertEquals(4512, actual);
    }

    @Test
    public void partOne() {

        final List<String> collect = StringFileReader.getInstance("_04giantsquid/04input1.txt").read()
                .collect(Collectors.toList());
        int actual = giantSquid.partOne(collect.get(0), collect.subList(1, collect.size()));
        assertEquals(29440, actual);
    }

    @Test
    public void partTwo_sampleData() {
        int actual = giantSquid.partTwo(calledNumbers, sampleCards);
        assertEquals(1924, actual);
    }

    @Test
    public void partTwo() {
        final List<String> collect = StringFileReader.getInstance("_04giantsquid/04input1.txt").read()
                .collect(Collectors.toList());
        int actual = giantSquid.partTwo(collect.get(0), collect.subList(1, collect.size()));
        assertEquals(13884, actual);
    }

}