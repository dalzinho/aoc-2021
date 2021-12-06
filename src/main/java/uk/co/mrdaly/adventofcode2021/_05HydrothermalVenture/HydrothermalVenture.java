package uk.co.mrdaly.adventofcode2021._05HydrothermalVenture;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HydrothermalVenture {

    List<List<Integer>> matrix;

    public long partOne(List<String> inputs) {
        final List<Line> lines = parseInputs(inputs);
        lines.stream()
                .filter(line -> !line.isDiagonal())
                .forEach(this::processLine);
        return getResult();

    }

    public List<Line> parseInputs(List<String> inputs) {
        int maxX = 0;
        int maxY = 0;

        List<Line> lines = new ArrayList<>();

        for (String s : inputs) {
            Matcher m = Pattern.compile("(\\d+),(\\d+) -> (\\d+),(\\d+)").matcher(s);
            m.find();

            int startX = Integer.parseInt(m.group(1));
            int startY = Integer.parseInt(m.group(2));
            int endX = Integer.parseInt(m.group(3));
            int endY = Integer.parseInt(m.group(4));

            Line line = new Line(new Position(startX, startY), new Position(endX, endY));
            lines.add(line);

            maxX = getMaxOf(maxX, startX, endX);
            maxY = getMaxOf(maxY, startY, endY);
        }

        matrix = buildMatrix(maxX, maxY);
        return lines;
    }

    private int getMaxOf(int currentMax, int start, int end) {
        int maxNew = Math.max(start, end);
        return Math.max(currentMax, maxNew);
    }

    private List<List<Integer>> buildMatrix(int x, int y) {
        List<List<Integer>> m = new ArrayList<>();

        for (int i = 0; i <= y; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= x; j++) {
                row.add(0);
            }
            m.add(row);
        }
        return m;
    }


    private void processLine(Line line) {
        if (line.isHorizontal()) {
            int row = line.getStart().getY();
            for (int column = line.getStart().getX(); column <= line.getEnd().getX(); column++) {
                int current = matrix.get(row).get(column);
                int next = current + 1;
                matrix.get(row).set(column, next);
            }
        } else if (line.isVertical()) {
            int column = line.getStart().getX();
            for (int row = line.getStart().getY(); row <= line.getEnd().getY(); row++) {
                int current = matrix.get(row).get(column);
                matrix.get(row).set(column, current + 1);
            }
        } else if (line.isDiagonal()) {
            int row = line.getStart().getY();
            int column = line.getStart().getX();

            while (row <= line.getEnd().getY()) {
                incrementMatrix(row, column);
                row++;
                column = line.isDiagonalLToR() ? column + 1 : column - 1;
            }
        }
    }

    private void incrementMatrix(int row, int column) {
        int current = matrix.get(row).get(column);
        matrix.get(row).set(column, current + 1);
    }

    private long getResult() {
        return matrix.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .filter(i -> i > 1)
                .count();
    }

    public long partTwo(List<String> inputs) {
        final List<Line> lines = parseInputs(inputs);
        lines.forEach(this::processLine);
        return getResult();
    }
}
