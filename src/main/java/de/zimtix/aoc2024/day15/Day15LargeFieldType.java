package de.zimtix.aoc2024.day15;

import java.util.List;

public enum Day15LargeFieldType {
    WALL('#'),
    BOX_LEFT('['),
    BOX_RIGHT(']'),
    GROUND('.'),
    ROBOT('@');

    private final char character;

    Day15LargeFieldType(char character) {
        this.character = character;
    }

    public static List<Day15LargeFieldType> fromChar(char c) {
        return switch (c) {
            case '#' -> List.of(WALL, WALL);
            case 'O' -> List.of(BOX_LEFT, BOX_RIGHT);
            case '.' -> List.of(GROUND, GROUND);
            case '@' -> List.of(ROBOT, GROUND);
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

    public char getCharacter() {
        return character;
    }
}
