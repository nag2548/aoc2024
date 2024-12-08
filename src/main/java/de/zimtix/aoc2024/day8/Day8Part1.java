package de.zimtix.aoc2024.day8;

import java.util.List;
import java.util.function.BiFunction;

public class Day8Part1 extends Day8 {
    public Day8Part1(List<String> lines) {
        super(lines);
    }

    @Override
    protected void collectAntinodes(Day8Coordinate coordinate, int x, int y, BiFunction<Integer, Integer, Integer> operation) {
        Day8Coordinate newCoordinate = new Day8Coordinate(operation.apply(coordinate.x(), x), operation.apply(coordinate.y(), y));
        putIfInBounds(newCoordinate);
    }
}
