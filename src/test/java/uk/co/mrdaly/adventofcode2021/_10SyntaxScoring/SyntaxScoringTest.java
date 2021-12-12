package uk.co.mrdaly.adventofcode2021._10SyntaxScoring;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import uk.co.mrdaly.adventofcode2021.util.StringFileReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class SyntaxScoringTest {

    private SyntaxScoring syntaxScoring;
    private List<String> sampleInput;
    private List<String> actualInput;

    @Before
    public void setup() {
        syntaxScoring = new SyntaxScoring();
        sampleInput = Arrays.asList(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]"
        );
        actualInput = StringFileReader.getInstance("_10SyntaxScoring/10input1.txt")
                .read()
                .collect(Collectors.toList());
    }

    @Test
    public void testIncompleteButValid() {

        final int actual = syntaxScoring.partOne(Collections.singletonList("[({(<(())[]>[[{[]{<()<>>"));
        assertEquals(0, actual);
    }

    @Test
    public void testForIllegalBrace() {
        final int actual = syntaxScoring.partOne(Collections.singletonList("{([(<{}[<>[]}>{[]{[(<()>"));
        assertEquals(1197, actual);
    }

    @Test
    public void partOne_sampleData() {
        int actual = syntaxScoring.partOne(sampleInput);
        assertEquals(26397, actual);
    }

    @Test
    public void partOne_actualData() {
        int actual = syntaxScoring.partOne(actualInput);
        assertEquals(345441, actual);
    }

    @Test
    public void partTwoExample() {
        long actual = syntaxScoring.partTwo(Collections.singletonList("<{([{{}}[<[[[<>{}]]]>[]]"));
        assertEquals(294, actual);
    }

    @Test
    public void partTwo_sampleData() {
        long actual = syntaxScoring.partTwo(sampleInput);
        assertEquals(288957, actual);
    }

    @Test
    public void partTwo_actualData() {
        long actual = syntaxScoring.partTwo(actualInput);
        assertEquals(3235371166L, actual);
    }
}