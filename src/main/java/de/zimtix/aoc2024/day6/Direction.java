package de.zimtix.aoc2024.day6;

import java.util.List;

import static java.util.Arrays.asList;

public enum Direction {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static List<Direction> getDirections() {
        return asList(Direction.values());
    }
}
