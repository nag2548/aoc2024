package de.zimtix.aoc2024.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6Part1 extends Day6 {
    private final Set<Day6Coordinate> visitedFields = new HashSet<>();

    public Day6Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        Day6Coordinate coordinate = start.getCoordinate();
        while (true) {
            Day6Field currentField = fields[coordinate.x()][coordinate.y()];
            visitedFields.add(currentField.getCoordinate());

            Day6Coordinate nextCoordinate = new Day6Coordinate(coordinate.x() + currentDirection.getX(), coordinate.y() + currentDirection.getY());
            if (nextCoordinate.x() < 0 || nextCoordinate.y() < 0 || nextCoordinate.x() >= fields.length || nextCoordinate.y() >= fields[0].length) {
                break;
            }

            Day6Field nextPossibleField = fields[nextCoordinate.x()][nextCoordinate.y()];
            if (nextPossibleField.getType() == Day6FieldType.OBSTACLE) {
                currentDirection = directions.get((directions.indexOf(currentDirection) + 1) % directions.size());
            } else {
                coordinate = nextCoordinate;
            }
        }

        return visitedFields.size();
    }
}
