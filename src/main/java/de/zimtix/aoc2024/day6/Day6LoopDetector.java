package de.zimtix.aoc2024.day6;

import java.util.List;

public class Day6LoopDetector {
    private final Day6Field[][] fields;
    private final List<Day6Direction> directions = Day6Direction.getDirections();
    private final Day6Field start;

    public Day6LoopDetector(Day6Field[][] fields, Day6Field start) {
        this.fields = fields;
        this.start = start;
    }

    public boolean doesLoop() {
        Day6State slow = new Day6State(start.getCoordinate(), Day6Direction.UP);
        Day6State fast = new Day6State(start.getCoordinate(), Day6Direction.UP);

        while (isInBounds(slow.coordinate()) && isInBounds(fast.coordinate())) {
            slow = move(slow);
            fast = move(fast);
            fast = move(fast);

            if (slow.coordinate().x() == fast.coordinate().x() && slow.coordinate().y() == fast.coordinate().y() && slow.direction() == fast.direction()) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBounds(Day6Coordinate coordinate) {
        return coordinate.x() >= 0 && coordinate.y() >= 0 && coordinate.x() < fields.length && coordinate.y() < fields[0].length;
    }

    private Day6State move(Day6State state) {
        Day6Direction direction = state.direction();
        Day6Field nextPossibleField;
        Day6State nextState;
        do {
            nextState = new Day6State(new Day6Coordinate(state.coordinate().x() + direction.getX(), state.coordinate().y() + direction.getY()), direction);
            if (!isInBounds(nextState.coordinate())) {
                return nextState;
            }

            nextPossibleField = fields[nextState.coordinate().x()][nextState.coordinate().y()];
            if (nextPossibleField.getType() == Day6FieldType.OBSTACLE) {
                direction = directions.get((directions.indexOf(direction) + 1) % directions.size());
            }
        } while (nextPossibleField.getType() == Day6FieldType.OBSTACLE);

        return nextState;
    }
}
