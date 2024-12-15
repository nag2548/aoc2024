package de.zimtix.aoc2024.day15;

import java.util.Objects;

public class Day15LargeField {
    private final Day15Coordinate coordinate;
    private Day15LargeFieldType fieldType;

    public Day15LargeField(Day15Coordinate coordinate, Day15LargeFieldType fieldType) {
        this.coordinate = coordinate;
        this.fieldType = fieldType;
    }

    public Day15Coordinate getCoordinate() {
        return coordinate;
    }

    public Day15LargeFieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(Day15LargeFieldType fieldType) {
        this.fieldType = fieldType;
    }

    public static Day15LargeField clone(Day15LargeField field) {
        return new Day15LargeField(field.getCoordinate(), field.getFieldType());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Day15LargeField that = (Day15LargeField) o;
        return Objects.equals(coordinate, that.coordinate) && fieldType == that.fieldType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, fieldType);
    }
}
