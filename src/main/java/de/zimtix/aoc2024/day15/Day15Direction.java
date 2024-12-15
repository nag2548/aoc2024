package de.zimtix.aoc2024.day15;

import java.util.Arrays;

public enum Day15Direction {
    UP('^', -1, 0),
    DOWN('v', 1, 0),
    LEFT('<', 0, -1),
    RIGHT('>', 0, 1);

    private final char direction;
    private final int x;
    private final int y;

    Day15Direction(char direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public static Day15Direction fromDirection(char direction) {
        return Arrays.stream(values())
                .filter(v -> v.getDirection() == direction)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid direction: " + direction));
    }

    public char getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
