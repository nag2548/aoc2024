package de.zimtix.aoc2024.day10;

import java.util.List;

import static java.util.Arrays.asList;

public enum Day10Direction {
    UP(-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int x;
    private final int y;

    Day10Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static List<Day10Direction> getDirections() {
        return asList(Day10Direction.values());
    }
}
