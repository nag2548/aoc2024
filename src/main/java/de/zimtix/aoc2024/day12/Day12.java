package de.zimtix.aoc2024.day12;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public abstract class Day12 extends Puzzle {
    protected final List<Day12Direction> directions = Day12Direction.getDirections();
    protected Day12Field[][] plots;

    public Day12(List<String> lines) {
        super(lines);
    }

    protected void init() {
        plots = new Day12Field[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            Day12Field[] row = new Day12Field[line.length()];
            for (int j = 0; j < line.length(); j++) {
                row[j] = new Day12Field(new Day12Coordinate(i, j), line.charAt(j), false);
            }
            plots[i] = row;
        }
    }

    protected Pair<List<Day12Field>, Integer> collectAdjacentPlots(Day12Field start) {
        List<Day12Field> plants = new ArrayList<>();
        Deque<Day12Field> fields = new ArrayDeque<>();
        markVisited(start);
        fields.push(start);
        plants.add(start);
        int perimeter = 0;

        while (!fields.isEmpty()) {
            Day12Field field = fields.pop();
            char plant = field.getPlant();
            Day12Coordinate coordinate = field.getCoordinate();

            for (Day12Direction direction : directions) {
                int newX = coordinate.x() + direction.getX();
                int newY = coordinate.y() + direction.getY();
                if (isInBounds(newX, newY) && plots[newX][newY].getPlant() == plant && !plots[newX][newY].isVisited()) {
                    Day12Field newField = plots[newX][newY];
                    newField.setVisited(true);
                    fields.push(newField);
                    plants.add(newField);
                }

                if (!isInBounds(newX, newY) || plots[newX][newY].getPlant() != plant) {
                    perimeter++;
                }
            }
        }
        return Pair.of(plants, perimeter);
    }

    protected boolean isInBounds(int x, int y) {
        return x >= 0 && x < plots.length && y >= 0 && y < plots[0].length;
    }

    private void markVisited(Day12Field field) {
        Day12Coordinate coordinate = field.getCoordinate();
        plots[coordinate.x()][coordinate.y()].setVisited(true);
    }
}
