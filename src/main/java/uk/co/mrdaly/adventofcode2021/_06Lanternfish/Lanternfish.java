package uk.co.mrdaly.adventofcode2021._06Lanternfish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lanternfish {

    public long partOne(List<Integer> input, int generations) {
        final Map<Integer, Long> collect = input.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        for (int i = 0; i <= 8; i++) {
            collect.putIfAbsent(i, 0L);
        }

        return solve(collect, generations);
    }

    private long solve(Map<Integer, Long> currentGeneration, int generations) {
        if (generations == 0) {
            return currentGeneration.values().stream().mapToLong(Long::longValue).sum();
        }

        Map<Integer, Long> nextGeneration = new HashMap<>();

        long currentlyAtZero = currentGeneration.get(0);

        for (int i = 8; i > 0; i--) {
            nextGeneration.put(i - 1, currentGeneration.get(i));

        }
        nextGeneration.put(8, currentlyAtZero);
        nextGeneration.put(6, nextGeneration.get(6) + currentlyAtZero);

        return solve(nextGeneration, generations - 1);
    }
}
