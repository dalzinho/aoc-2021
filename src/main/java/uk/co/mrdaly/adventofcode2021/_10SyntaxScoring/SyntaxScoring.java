package uk.co.mrdaly.adventofcode2021._10SyntaxScoring;

import java.util.*;
import java.util.stream.Collectors;

public class SyntaxScoring {

    private static final Map<String, Integer> BRACKET_SCORE_LOOKUP;
    private static final Map<String, String> BRACKET_PAIRS;

    static {
        BRACKET_SCORE_LOOKUP = new HashMap<>();
        BRACKET_PAIRS = new HashMap<>();
        BRACKET_PAIRS.put("{", "}");
        BRACKET_PAIRS.put("<", ">");
        BRACKET_PAIRS.put("(", ")");
        BRACKET_PAIRS.put("[", "]");
    }

    public int partOne(List<String> sampleInput) {
        BRACKET_SCORE_LOOKUP.put(")", 3);
        BRACKET_SCORE_LOOKUP.put("]", 57);
        BRACKET_SCORE_LOOKUP.put("}", 1197);
        BRACKET_SCORE_LOOKUP.put(">", 25137);

        return sampleInput.stream()
                .map(this::findInvalidCharacter)
                .filter(Objects::nonNull)
                .mapToInt(BRACKET_SCORE_LOOKUP::get)
                .sum();
    }

    private String findInvalidCharacter(String input) {
        String invalid = null;

        Deque<String> character = new ArrayDeque<>();

        for (String s : input.split("")) {
            if (BRACKET_PAIRS.containsKey(s)) {
                character.add(s);
            } else {
                String expected = BRACKET_PAIRS.get(character.getLast());
                if (!expected.equals(s)) {
                    invalid = s;
                    break;
                } else {
                    character.removeLast();
                }
            }
        }
        return invalid;
    }

    public long partTwo(List<String> actualInput) {
        BRACKET_SCORE_LOOKUP.put(")", 1);
        BRACKET_SCORE_LOOKUP.put("]", 2);
        BRACKET_SCORE_LOOKUP.put("}", 3);
        BRACKET_SCORE_LOOKUP.put(">", 4);

        final List<Long> collect = actualInput.stream()
                .filter(s -> null == findInvalidCharacter(s))
                .map(this::deriveRemainingBrackets)
                .map(this::closeRemainingBrackets)
                .mapToLong(this::calculateCompletionScore)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        return collect.get(collect.size() / 2);
    }

    private Deque<String> deriveRemainingBrackets(String input) {
        Deque<String> character = new ArrayDeque<>();

        for (String s : input.split("")) {
            if (BRACKET_PAIRS.containsKey(s)) {
                character.add(s);
            } else {
                character.removeLast();
            }
        }
        return character;
    }

    private Collection<String> closeRemainingBrackets(Deque<String> openBrackets) {
        Deque<String> result = new ArrayDeque<>();

        while (!openBrackets.isEmpty()) {
            String open = openBrackets.pop();
            String close = BRACKET_PAIRS.get(open);
            result.push(close);
        }
        return result;
    }

    private long calculateCompletionScore(Collection<String> strings) {
        long score = 0L;

        for (String s : strings) {
            score *= 5;
            score += BRACKET_SCORE_LOOKUP.get(s);
        }
        return score;
    }
}