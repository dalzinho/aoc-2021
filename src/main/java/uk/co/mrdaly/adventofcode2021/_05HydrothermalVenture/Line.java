package uk.co.mrdaly.adventofcode2021._05HydrothermalVenture;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final Position start;
    private final Position end;

    public Line(Position start, Position end) {
        final List<Position> positions = positions(start, end);
        this.start = positions.get(0);
        this.end = positions.get(1);
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }

    public boolean isVertical() {
        return start.getX() == end.getX();
    }

    public boolean isHorizontal() {
        return start.getY() == end.getY();
    }

    public boolean isDiagonal() {
        return !isHorizontal() && !isVertical();
    }

    public boolean isDiagonalLToR() {
        return isDiagonal() && start.getX() < end.getX();
    }


    private List<Position> positions(Position start, Position end) {
        return Stream.of(start, end)
                .sorted(
                        Comparator.comparingInt(Position::getY)
                                .thenComparingInt(Position::getX)
                )
                .collect(Collectors.toList());
    }

}
