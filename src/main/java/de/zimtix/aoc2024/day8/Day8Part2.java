package de.zimtix.aoc2024.day8;

import java.util.List;
import java.util.function.BiFunction;

public class Day8Part2 extends Day8 {
    public Day8Part2(List<String> lines) {
        super(lines);
    }

    @Override
    protected void collectAntinodes(Day8Coordinate coordinate, int x, int y, BiFunction<Integer, Integer, Integer> operation) {
        Day8Coordinate newCoordinate = coordinate;
        while (isInBounds(newCoordinate)) {
            putIfInBounds(newCoordinate);
            int newX = operation.apply(newCoordinate.x(), x);
            int newY = operation.apply(newCoordinate.y(), y);
            newCoordinate = new Day8Coordinate(newX, newY);
        }
    }
}
