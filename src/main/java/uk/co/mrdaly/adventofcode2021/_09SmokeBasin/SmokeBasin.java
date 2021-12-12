package uk.co.mrdaly.adventofcode2021._09SmokeBasin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmokeBasin {

    public int partOne(List<String> input) {
        final List<List<Integer>> matrix = parseMatrix(input);
        final List<Integer> lowPoints = filterLowPoints(matrix);
        return calculateResult(lowPoints);
    }

    private List<List<Integer>> parseMatrix(List<String> input) {
        List<List<Integer>> matrix = new ArrayList<>();

        for (String inputRow : input) {
            List<Integer> row = new ArrayList<>();
            for (String s : inputRow.split("")) {
                row.add(Integer.parseInt(s));
            }
            matrix.add(row);
        }
        return matrix;
    }

    private List<Integer> filterLowPoints(List<List<Integer>> matrix) {
        int rightBound = matrix.get(0).size() - 1;
        int bottomBound = matrix.size() - 1;

        List<Integer> lowPoints = new ArrayList<>();

        for (int row = 0; row <= bottomBound; row++) {
            for (int column = 0; column <= rightBound; column++) {
                int test = matrix.get(row).get(column);
                List<Integer> adjacent = new ArrayList<>();

                if (hasAbove(row)) {
                    adjacent.add(matrix.get(row - 1).get(column));
                }

                if (hasLeft(column)) {
                    adjacent.add(matrix.get(row).get(column - 1));
                }

                if (hasBelow(row, bottomBound)) {
                    adjacent.add(matrix.get(row + 1).get(column));
                }

                if (hasRight(column, rightBound)) {
                    adjacent.add(matrix.get(row).get(column + 1));
                }

                if (isLowPoint(test, adjacent)) {
                    lowPoints.add(test);
                }
            }
        }

        return lowPoints;
    }

    private boolean hasAbove(int row) {
        return row > 0;
    }

    private boolean hasBelow(int row, int bottomBound) {
        return row < bottomBound;
    }

    private boolean hasLeft(int column) {
        return column > 0;
    }

    private boolean hasRight(int column, int rightBound) {
        return column < rightBound;
    }

    private boolean isLowPoint(int test, List<Integer> adjacents) {
        return adjacents.stream()
                .noneMatch(adjacent -> adjacent <= test);
    }

    private int calculateResult(List<Integer> lowPoints) {
        return lowPoints.stream()
                .map(i -> i + 1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int partTwo(List<String> input) {
        final List<List<Integer>> matrix = parseMatrix(input);
        final List<Integer> basinSizes = findBasinSizes(matrix);
        return 0;
    }

    private List<Integer> findBasinSizes(List<List<Integer>> matrix) {
        int rightBound = matrix.get(0).size() - 1;
        int bottomBound = matrix.size() - 1;

        List<Integer> basins = new ArrayList<>();

        for (int row = 0; row <= bottomBound; row++) {
            for (int column = 0; column <= rightBound; column++) {
                int test = matrix.get(row).get(column);
                if (matrix.get(row).get(column) != 9) {
                    if (matrix.get(row).get(column) < 9) {
                        int basin = findBasin(row, column, matrix, new HashSet<>()).size();
                        basins.add(basin);
                    }

                }
            }
        }

        return basins;
    }

    private Set<String> findBasin(int row, int column, List<List<Integer>> matrix, Set<String> found) {
        try {
            int test = matrix.get(row).get(column);
            if (test < 9) {
                found.add(row + "," + column);
            }

            matrix.get(row).set(column, 10);
            findBasin(row - 1, column,  matrix, found);
            findBasin(row + 1, column, matrix, found);
            findBasin(row, column - 1, matrix, found);
            findBasin(row, column + 1, matrix, found);
        } catch (IndexOutOfBoundsException e) {

        }

       return found;
    }
}