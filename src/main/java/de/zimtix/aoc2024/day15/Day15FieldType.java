package de.zimtix.aoc2024.day15;

import java.util.Arrays;

public enum Day15FieldType {
    WALL('#'),
    BOX('O'),
    GROUND('.'),
    ROBOT('@');

    private final char character;

    Day15FieldType(char character) {
        this.character = character;
    }

    public static Day15FieldType fromChar(char c) {
        return Arrays.stream(values())
                .filter(v -> v.getCharacter() == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid field type: " + c));
    }

    public char getCharacter() {
        return character;
    }
}
