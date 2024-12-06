package de.zimtix.aoc2024.day6;

import java.util.List;
import java.util.Objects;

public class Day6LoopDetector {
    private final Day6Field[][] fields;
    private Day6Direction currentDirection = Day6Direction.UP;
    private final List<Day6Direction> directions = Day6Direction.getDirections();
    private final Day6Field start;

    public Day6LoopDetector(Day6Field[][] fields, Day6Field start) {
        this.fields = fields;
        this.start = start;
    }

    public boolean doesLoop() {
        Day6Coordinate coordinate = start.getCoordinate();
        Day6Node head = null;
        Day6Node previousNode = null;
        while (true) {
            Day6Node newHead = new Day6Node(new Day6State(fields[coordinate.x()][coordinate.y()].getCoordinate(), currentDirection));
            if (head == null) {
                head = newHead;
            }
            if (previousNode != null) {
                previousNode.setNext(newHead);
            }
            previousNode = newHead;

            Day6Coordinate nextCoordinate = new Day6Coordinate(coordinate.x() + currentDirection.getX(), coordinate.y() + currentDirection.getY());
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
