package de.zimtix.aoc2024.day6;

import java.util.List;

import static java.util.Arrays.asList;

public enum Day6Direction {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private final int x;
    private final int y;

    Day6Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static List<Day6Direction> getDirections() {
        return asList(Day6Direction.values());
    }
}
