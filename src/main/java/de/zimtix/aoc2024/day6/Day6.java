package de.zimtix.aoc2024.day6;

import de.zimtix.aoc2024.Puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Day6 extends Puzzle {
    protected Day6Field[][] fields;
    protected Day6Field start;
    protected Day6Direction currentDirection = Day6Direction.UP;
    protected final List<Day6Direction> directions = Day6Direction.getDirections();

    public Day6(List<String> lines) {
        super(lines);
    }

    protected void init() {
        fields = new Day6Field[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            fields[i] = new Day6Field[line.length()];
            for (int j = 0; j < line.length(); j++) {
                fields[i][j] = new Day6Field(Day6FieldType.fromChar(line.charAt(j)), new Day6Coordinate(i, j));

                if (fields[i][j].getType() == Day6FieldType.START) {
                    start = fields[i][j];
                }
            }
        }
    }

    protected Set<Day6Coordinate> getVisitedFields() {
        Set<Day6Coordinate> visitedFields = new HashSet<>();

        Day6Coordinate coordinate = start.getCoordinate();
        while (isInBounds(coordinate)) {
            Day6Field currentField = fields[coordinate.x()][coordinate.y()];
            visitedFields.add(currentField.getCoordinate());

            coordinate = move(coordinate);
        }

        return visitedFields;
    }

    private boolean isInBounds(Day6Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.y() >= 0 && coordinate.x() < fields.length && coordinate.y() < fields[0].length;
    }

    private Day6Coordinate move(Day6Coordinate coordinate) {
        Day6Field nextPossibleField;
        Day6Coordinate nextCoordinate;
        do {
            nextCoordinate = new Day6Coordinate(coordinate.x() + currentDirection.getX(), coordinate.y() + currentDirection.getY());
            if (!isInBounds(nextCoordinate)) {
                return nextCoordinate;
            }

            nextPossibleField = fields[nextCoordinate.x()][nextCoordinate.y()];
            if (nextPossibleField.getType() == Day6FieldType.OBSTACLE) {
                currentDirection = directions.get((directions.indexOf(currentDirection) + 1) % directions.size());
            }

        } while (nextPossibleField.getType() == Day6FieldType.OBSTACLE);

        return nextCoordinate;
    }
}
