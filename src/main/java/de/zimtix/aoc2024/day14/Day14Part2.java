package de.zimtix.aoc2024.day14;

import java.util.List;

public class Day14Part2 extends Day14 {
    private int safetyFactor = Integer.MAX_VALUE;

    public Day14Part2(List<String> lines, int sizeY, int sizeX) {
        super(lines, sizeY, sizeX);
    }

    @Override
    public Object getResult() {
        init();
        int count = 1;
        while (count < 10001) {
            System.out.println("######## Count: " + count + "########");
            calculateNextPositions();
            count++;
        }

        return null;
    }

    private void calculateNextPositions() {
        for (Day14Robot robot : robots) {
            Day14Coordinate coordinate = robot.getCoordinate();
            Day14Coordinate velocity = robot.getVelocity();

            int endY = mod(coordinate.getY() + velocity.getY(), sizeY);
            int endX = mod(coordinate.getX() + velocity.getX(), sizeX);
            robot.setY(endY);
            robot.setX(endX);
        }

        int currentSafetyFactor = getSafetyFactor();
        if (currentSafetyFactor < safetyFactor) {
            print();
            safetyFactor = currentSafetyFactor;
        }
    }

    private void print() {
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                String field = ".";
                if (hasRobots(y, x)) {
                    field = "X";
                }
                System.out.print(field);
            }
            System.out.print("\n");
        }
    }

    private boolean hasRobots(int y, int x) {
        return robots.stream()
                .anyMatch(robot -> robot.getCoordinate().equals(new Day14Coordinate(y, x)));
    }
}
