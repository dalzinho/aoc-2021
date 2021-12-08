package uk.co.mrdaly.adventofcode2021._08SevenSegmentSearch;

import org.junit.Before;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SevenSegmentSearchTest {

    private SevenSegmentSearch sevenSegmentSearch;
    private List<String> sampleData;
    private List<String> actualData;

    @Before
    public void setup() {
        sevenSegmentSearch = new SevenSegmentSearch();
        sampleData = Arrays.asList(
                "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe",
                "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc",
                "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg",
                "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb",
                "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea",
                "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb",
                "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe",
                "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef",
                "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb",
                "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce"
        );
        actualData = StringFileReader.getInstance("_08SevenSegmentSearch/08input1.txt")
                .read()
                .collect(Collectors.toList());
    }
    @Test
    public void partOne_sampleData() {
        int actual = sevenSegmentSearch.partOne(sampleData);
        assertEquals(26, actual);
    }

    @Test
    public void partOne() {
        int actual = sevenSegmentSearch.partOne(actualData);
        assertEquals(383, actual);
    }

    @Test
    public void partTwo_sampleData() {
        int actual = sevenSegmentSearch.partTwo(sampleData);
        assertEquals(61229, actual);
    }

    @Test
    public void partTwo() {
        int actual = sevenSegmentSearch.partTwo(actualData);
        assertEquals(998900, actual);
    }
}
