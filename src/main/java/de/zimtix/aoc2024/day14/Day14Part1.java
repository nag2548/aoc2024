package de.zimtix.aoc2024.day14;

import java.util.List;

public class Day14Part1 extends Day14 {
    private static final int SECONDS = 100;

    public Day14Part1(List<String> lines, int sizeY, int sizeX) {
        super(lines, sizeY, sizeX);
    }

    @Override
    public Object getResult() {
        init();
        calculateEndpositions();
        return getSafetyFactor();
    }

    private void calculateEndpositions() {
        for (Day14Robot robot : robots) {
            Day14Coordinate coordinate = robot.getCoordinate();
            Day14Coordinate velocity = robot.getVelocity();

            int endY = mod(coordinate.getY() + velocity.getY() * SECONDS, sizeY);
            int endX = mod(coordinate.getX() + velocity.getX() * SECONDS, sizeX);
            robot.setY(endY);
            robot.setX(endX);
        }
    }
}
