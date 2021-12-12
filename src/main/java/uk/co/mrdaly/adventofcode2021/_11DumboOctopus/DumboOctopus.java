package uk.co.mrdaly.adventofcode2021._11DumboOctopus;

import uk.co.mrdaly.adventofcode2021.util.MatrixParser;

import java.util.Arrays;
import java.util.List;

public class DumboOctopus {

    private long flashCount;

    public long partOne(List<String> input, int generations) {
        final List<List<Integer>> matrix = MatrixParser.listOfStringsToIntMatrix(input);

        for (int i = 0; i < generations; i++) {
            generate(matrix);
        }
        return flashCount;
    }

    public void generate(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int column = 0; column < matrix.get(row).size(); column++) {
                int current = matrix.get(row).get(column);
                matrix.get(row).set(column, current + 1);
            }
        }

        boolean flashDetected;

        do {
            flashDetected = false;
            for (int row = 0; row < matrix.size(); row++) {
                for (int column = 0; column < matrix.get(row).size(); column++) {
                    int current = matrix.get(row).get(column);
                    if (current > 9) {
                        flashDetected = true;
                        matrix.get(row).set(column, 0);
                        incrementNeighbours(matrix, row, column);
                    }
                }
            }
        } while (flashDetected);

        incrementFlashCount(matrix);

    }

    private void incrementNeighbours(List<List<Integer>> matrix, int row, int column) {
        for (int r : Arrays.asList(row - 1, row, row + 1)) {
            for (int c : Arrays.asList(column - 1, column, column + 1)) {
                if (exists(matrix, r, c)) {
                    int current = matrix.get(r).get(c);
                    if (current != 0) {
                        matrix.get(r).set(c, current + 1);
                    }
                }
            }
        }
    }

    private void incrementFlashCount(List<List<Integer>> matrix) {
        long count = matrix.stream()
                .flatMap(List::stream)
                .filter(i -> i == 0)
                .count();

        flashCount += count;
    }

    private boolean exists(List<List<Integer>> matrix, int row, int column) {
        return row >= 0 && row < matrix.size() && column >= 0 && column < matrix.get(row).size();
    }


    public int partTwo(List<String> input) {
        final List<List<Integer>> matrix = MatrixParser.listOfStringsToIntMatrix(input);

        int loopCount = 0;

        while (!allZero(matrix)) {
            loopCount++;
            generate(matrix);
        }

        return loopCount;
    }

    private boolean allZero(List<List<Integer>> matrix) {
        return matrix.stream()
                .flatMap(List::stream)
                .allMatch(i -> i == 0);
    }
}