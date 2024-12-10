package de.zimtix.aoc2024.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Day10Part1 extends Day10 {
    public Day10Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        int result = 0;
        for (Day10Coordinate start : starts) {
            result += targetsReached(start);
        }

        return result;
    }

    private int targetsReached(Day10Coordinate start) {
        Set<Day10Coordinate> targetsCopy = new HashSet<>(targets);
        Stack<Day10State> stack = new Stack<>();
        stack.push(new Day10State(0, start));

        while (!stack.isEmpty()) {
            Day10State item = stack.pop();
            Day10Coordinate coordinate = item.coordinate();
            int lastHeight = item.lastHeight();
            for (Day10Direction direction : directions) {
                int newX = coordinate.x() + direction.getX();
                int newY = coordinate.y() + direction.getY();
                if (!isInBounds(newX, newY)) {
                    continue;
                }

                int height = array[newX][newY];
                if (height == lastHeight + 1) {
                    Day10Coordinate newCoordinate = new Day10Coordinate(newX, newY);
                    if (height == 9) {
                        targetsCopy.remove(newCoordinate);
                    } else {
                        stack.push(new Day10State(height, newCoordinate));
                    }
                }
            }
        }

        return Math.abs(targetsCopy.size() - targets.size());
    }
}
