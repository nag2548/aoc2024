package de.zimtix.aoc2024.day15;

public class Day15Field {
    private final Day15Coordinate coordinate;
    private Day15FieldType fieldType;

    public Day15Field(Day15Coordinate coordinate, Day15FieldType fieldType) {
        this.coordinate = coordinate;
        this.fieldType = fieldType;
    }

    public Day15Coordinate getCoordinate() {
        return coordinate;
    }

    public Day15FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(Day15FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
