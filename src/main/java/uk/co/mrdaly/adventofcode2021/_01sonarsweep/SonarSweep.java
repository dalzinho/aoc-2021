package uk.co.mrdaly.adventofcode2021._01sonarsweep;

import java.util.ArrayList;
import java.util.List;

public class SonarSweep {

    public int partOne(List<Integer> inputs) {
       return countIncreases(inputs);
    }

    private int countIncreases(List<Integer> inputs) {
        int count = 0;

        for (int i = 1; i < inputs.size(); i++) {
            if (inputs.get(i) > inputs.get(i - 1)) {
                count++;
            }
        }

        return count;
    }

    public int partTwo(List<Integer> testInputs) {
        List<Integer> windowResults = new ArrayList<>();

        for (int i = 0; i < testInputs.size(); i++) {
            if (i + 2 > testInputs.size() - 1) {
                break;
            }
            final int sum = testInputs.subList(i, i + 3).stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            windowResults.add(sum);
        }
        return countIncreases(windowResults);
    }
}
