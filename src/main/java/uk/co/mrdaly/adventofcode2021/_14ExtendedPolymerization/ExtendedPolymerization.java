package uk.co.mrdaly.adventofcode2021._14ExtendedPolymerization;

import java.util.*;
import java.util.stream.Collectors;

public class ExtendedPolymerization {

    private final StringBuilder stringBuilder = new StringBuilder();

    public long partOne(List<String> input, int generations) {
        String initialPolymer = input.get(0);
        final Map<String, String> polymerMap = buildPolymerMap(input.subList(2, input.size()));
        String result = generation(initialPolymer, polymerMap, generations);
        return calculateResult(result);
    }

    private String generation(String input, final Map<String, String> polymerMap, int generations) {
        if (generations == 0) {
            return input;
        }

        stringBuilder.setLength(0);

        for (int i = 0; i < input.length(); i++) {
            String polymer = input.substring(i, Math.min(i + 2, input.length()));
            String nextPolymer = polymerMap.getOrDefault(polymer, polymer);
            stringBuilder.append(nextPolymer);
        }
        return generation(stringBuilder.toString(), polymerMap, generations - 1);
    }

    private long calculateResult(String lastGeneration) {
        final Map<String, Long> instanceCount = Arrays.stream(lastGeneration.split(""))
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));

        long max = instanceCount.values().stream()
                .mapToLong(Long::longValue)
                .max().getAsLong();

        long min = instanceCount.values().stream()
                .mapToLong(Long::longValue)
                .min().getAsLong();

        return max - min;
    }

    private Map<String, String> buildPolymerMap(List<String> input) {
        Map<String, String> result = new HashMap<>();

        for (String s : input) {
            String[] elements = s.split(" -> ");
            String nextPolymer = elements[0].split("")[0] + elements[1];
            result.put(elements[0], nextPolymer);
        }
        return result;
    }
}