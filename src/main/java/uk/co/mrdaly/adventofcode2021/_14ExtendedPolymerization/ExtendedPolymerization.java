package uk.co.mrdaly.adventofcode2021._14ExtendedPolymerization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtendedPolymerization {

    public long partOne(List<String> input, int generationsRemaining) {
        String initialPolymer = input.get(0);

        final Map<String, String> polymerDictionary = buildPolymerDictionary(input.subList(2, input.size()));

        final Map<String, Long> initialPairCounts = buildIntitialPairCountMap(initialPolymer);

        Map<String, Long> intialLetterCount = Arrays.stream(initialPolymer.split(""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        Map<String, Long> result = recursiveGenerate(
                initialPairCounts,
                intialLetterCount,
                polymerDictionary,
                generationsRemaining
        );

        return calculateResult(result);
    }

    private Map<String, String> buildPolymerDictionary(List<String> input) {
        Map<String, String> result = new HashMap<>();

        for (String s : input) {
            String[] elements = s.split(" -> ");
            result.put(elements[0], elements[1]);
        }
        return result;
    }

    private Map<String, Long> buildIntitialPairCountMap(String input) {
        Map<String, Long> map = new HashMap<>();

        for (int i = 0; i < input.length() - 1; i++) {
            String polymer = input.substring(i, i + 2);
            map.merge(polymer, 1L, Long::sum);
        }

        return map;
    }

    private Map<String, Long> recursiveGenerate(Map<String, Long> pairCounts,
                                                Map<String, Long> letterCount,
                                                final Map<String, String> polymerMap,
                                                int generationsRemaining) {
        if (generationsRemaining == 0) {
            return letterCount;
        }

        Map<String, Long> nextPairs = new HashMap<>();

        for (Map.Entry<String, Long> entry : pairCounts.entrySet()) {
            String insertedElement = polymerMap.get(entry.getKey());

            String l = entry.getKey().substring(0, 1);
            String r = entry.getKey().substring(1, 2);

            nextPairs.merge(l + insertedElement, entry.getValue(), Long::sum);
            nextPairs.merge(insertedElement + r, entry.getValue(), Long::sum);
            letterCount.merge(insertedElement, entry.getValue(), Long::sum);
        }

        return recursiveGenerate(nextPairs, letterCount, polymerMap, generationsRemaining - 1);
    }

    private long calculateResult(Map<String, Long> lastGeneration) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (long l : lastGeneration.values()) {
            if (l > max) {
                max = l;
            }

            if (l < min) {
                min = l;
            }
        }
        return max - min;
    }
}