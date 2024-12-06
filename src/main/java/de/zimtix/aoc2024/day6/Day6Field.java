package de.zimtix.aoc2024.day6;

public class Day6Field {
    private Day6FieldType type;
    private final Day6Coordinate coordinate;

    public Day6Field(Day6FieldType type, Day6Coordinate coordinate) {
        this.type = type;
        this.coordinate = coordinate;
    }

    public Day6FieldType getType() {
        return type;
    }

    public void setType(Day6FieldType type) {
        this.type = type;
    }

    public Day6Coordinate getCoordinate() {
        return coordinate;
    }
}
