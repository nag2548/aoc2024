package de.zimtix.aoc2024.day6;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Day6Part2 extends Day6 {

    public Day6Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();
        Day6Part1 day6Part1 = new Day6Part1(lines);
        day6Part1.getResult();
        Set<Day6Coordinate> visitedFields = day6Part1.getVisitedFields();

        int result = 0;
        for (Day6Field[] row : fields) {
            for (Day6Field field : row) {
                if (!visitedFields.contains(field.getCoordinate())) {
                    continue;
                }

                currentDirection = Day6Direction.UP;

                Day6FieldType originalType = field.getType();
                if (originalType == Day6FieldType.NORMAL) {
                    field.setType(Day6FieldType.OBSTACLE);

                    if (doesLoop()) {
                        result++;
                    }
                    field.setType(originalType);
                }
            }
        }

        return result;
    }

    private boolean doesLoop() {
        Day6Coordinate coordinate = start.getCoordinate();
        Day6Node head = null;
        Day6Node previousNode = null;
        while (true) {
            Day6Field currentField = fields[coordinate.x()][coordinate.y()];
            Day6Direction direction = currentDirection;
            Day6Node newHead = new Day6Node(new Day6State(currentField.getCoordinate(), direction));
            if (head == null) {
                head = newHead;
            }
            if (previousNode != null) {
                previousNode.setNext(newHead);
            }
            previousNode = newHead;

            Day6Coordinate nextCoordinate = new Day6Coordinate(coordinate.x() + direction.getX(), coordinate.y() + direction.getY());
            if (nextCoordinate.x() < 0 || nextCoordinate.y() < 0 || nextCoordinate.x() >= fields.length || nextCoordinate.y() >= fields[0].length) {
                return false;
            }

            if (detectLoop(head)) {
                return true;
            }

            Day6Field nextPossibleField = fields[nextCoordinate.x()][nextCoordinate.y()];
            if (nextPossibleField.getType() == Day6FieldType.OBSTACLE) {
                currentDirection = directions.get((directions.indexOf(currentDirection) + 1) % directions.size());
            } else {
                coordinate = nextCoordinate;
            }
        }
    }

    private boolean detectLoop(Day6Node head) {
        Day6Node slow = head;
        Day6Node fast = head;

        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (fast != null && Objects.equals(slow.getState(), fast.getState())) {
                return true;
            }
        }
        return false;
    }
}
