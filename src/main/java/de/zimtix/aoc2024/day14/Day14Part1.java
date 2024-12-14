package de.zimtix.aoc2024.day14;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Day14Part1 extends Day14 {
    public static final int SECONDS = 100;

    private final List<Day14Robot> robots = new ArrayList<>();
    private final int sizeY;
    private final int sizeX;

    public Day14Part1(List<String> lines, int sizeY, int sizeX) {
        super(lines);
        this.sizeY = sizeY;
        this.sizeX = sizeX;
    }

    @Override
    public Object getResult() {
        init();
        calculateEndpositions();
        return getSafetyFactor();
    }

    private void init() {
        for (String line : lines) {
            String[] parts = line.split(" ");
            String[] positions = parts[0].substring("p=".length()).split(",");
            Day14Coordinate start = new Day14Coordinate(parseInt(positions[1]), parseInt(positions[0]));
            String[] velocities = parts[1].substring("v=".length()).split(",");
            Day14Coordinate velocity = new Day14Coordinate(parseInt(velocities[1]), parseInt(velocities[0]));
            robots.add(new Day14Robot(start, velocity));
        }
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

    private int getSafetyFactor() {
        int q1, q2, q3, q4;
        q1 = q2 = q3 = q4 = 0;
        int midY = sizeY / 2;
        int midX = sizeX / 2;

        for (Day14Robot robot : robots) {
            Day14Coordinate pos = robot.getCoordinate();
            if (pos.getX() < midX && pos.getY() < midY) {
                q1++;
            }
            if (pos.getX() > midX && pos.getY() < midY) {
                q2++;
            }
            if (pos.getX() < midX && pos.getY() > midY) {
                q3++;
            }
            if (pos.getX() > midX && pos.getY() > midY) {
                q4++;
            }
        }

        return q1 * q2 * q3 * q4;
    }

    private int mod(int a, int b) {
        int r = a % b;
        return r < 0 ? r + b : r;
    }
}
