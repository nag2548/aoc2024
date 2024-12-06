package de.zimtix.aoc2024.day6;

public enum Day6FieldType {
    OBSTACLE,
    NORMAL,
    START;

    public static Day6FieldType fromChar(char c) {
        return switch (c) {
            case '#' -> OBSTACLE;
            case '.' -> NORMAL;
            default -> START;
        };
    }
}
