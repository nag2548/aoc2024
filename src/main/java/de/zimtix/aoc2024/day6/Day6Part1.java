package de.zimtix.aoc2024.day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6Part1 extends Day6 {
    private Field[][] fields;
    private Field start;
    private Direction currentDirection = Direction.UP;
    private final List<Direction> directions = Direction.getDirections();
    private final Set<Coordinate> visitedFields = new HashSet<>();

    public Day6Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        Coordinate coordinate = start.coordinate();
        while (true) {
            Field currentField = fields[coordinate.x()][coordinate.y()];
            visitedFields.add(currentField.coordinate());

            Coordinate nextCoordinate = new Coordinate(coordinate.x() + currentDirection.getX(), coordinate.y() + currentDirection.getY());
            if (nextCoordinate.x() < 0 || nextCoordinate.y() < 0 || nextCoordinate.x() >= fields.length || nextCoordinate.y() >= fields[0].length) {
                break;
            }

            Field nextPossibleField = fields[nextCoordinate.x()][nextCoordinate.y()];
            if (nextPossibleField.type() == FieldType.OBSTACLE) {
                currentDirection = directions.get((directions.indexOf(currentDirection) + 1) % directions.size());
            } else {
                coordinate = nextCoordinate;
            }
        }

        return visitedFields.size();
    }

    private void init() {
        fields = new Field[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            fields[i] = new Field[line.length()];
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                fields[i][j] = new Field(FieldType.fromChar(c), new Coordinate(i, j));

                if (fields[i][j].type() == FieldType.START) {
                    start = fields[i][j];
                }
            }
        }
    }
}
