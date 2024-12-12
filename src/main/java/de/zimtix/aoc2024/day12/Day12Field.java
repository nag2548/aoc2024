package de.zimtix.aoc2024.day12;

public final class Day12Field {
    private Day12Coordinate coordinate;
    private char plant;
    private boolean visited;

    public Day12Field(Day12Coordinate coordinate, char plant, boolean visited) {
        this.coordinate = coordinate;
        this.plant = plant;
        this.visited = visited;
    }

    public Day12Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Day12Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public char getPlant() {
        return plant;
    }

    public void setPlant(char plant) {
        this.plant = plant;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "{" +
                "coordinate=" + coordinate +
                ", plant=" + plant +
                ", visited=" + visited +
                '}';
    }
}
