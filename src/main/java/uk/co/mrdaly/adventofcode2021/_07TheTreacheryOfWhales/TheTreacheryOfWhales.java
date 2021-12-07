package uk.co.mrdaly.adventofcode2021._07TheTreacheryOfWhales;

import java.util.Collections;
import java.util.List;
import java.util.function.LongUnaryOperator;

public class TheTreacheryOfWhales {

    public long partOne(List<Integer> input) {
        return calculateFuel(input, calculateMedian(input), l -> l);
    }

    private long calculateFuel(List<Integer> input, long stat, LongUnaryOperator fuelFactor) {
        return input.stream()
                .mapToLong(i -> Math.abs(i - stat))
                .map(fuelFactor)
                .sum();
    }

    private int calculateMedian(List<Integer> ints) {
        Collections.sort(ints);
        int middle = ints.size() / 2;
        int median = ints.get(middle);

        if (ints.size() % 2 == 0) {
            median = (ints.get(middle - 1) + ints.get(middle)) / 2;
        }

        return median;
    }

    public long partTwo(List<Integer> input) {
        double mean = input.stream().mapToInt(Integer::intValue).average().orElse(0);

        double floor = calculateFuel(input, (long) Math.floor(mean), this::calc);
        double ceil = calculateFuel(input, (long) Math.ceil(mean), this::calc);
        return (long) Math.min(floor, ceil);
    }

    private long calc(long l) {
        if (l <= 1) {
            return l;
        }

        return l + calc(l - 1);
    }
}
