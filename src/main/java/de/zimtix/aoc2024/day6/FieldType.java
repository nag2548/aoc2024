package de.zimtix.aoc2024.day6;

public enum FieldType {
    OBSTACLE,
    NORMAL,
    START;

    public static FieldType fromChar(char c) {
        return switch (c) {
            case '#' -> OBSTACLE;
            case '.' -> NORMAL;
            default -> START;
        };
    }
}
