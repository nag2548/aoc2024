package de.zimtix.aoc2024.day14;

public final class Day14Robot {
    private Day14Coordinate coordinate;
    private final Day14Coordinate velocity;

    public Day14Robot(Day14Coordinate coordinate, Day14Coordinate velocity) {
        this.coordinate = coordinate;
        this.velocity = velocity;
    }

    public Day14Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Day14Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Day14Coordinate getVelocity() {
        return velocity;
    }

    public void setY(int y) {
        coordinate.setY(y);
    }

    public void setX(int x) {
        coordinate.setX(x);
    }
}
