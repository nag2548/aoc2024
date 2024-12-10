package de.zimtix.aoc2024.day10;

import de.zimtix.aoc2024.Puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Day10 extends Puzzle {
    protected final List<Day10Direction> directions = Day10Direction.getDirections();
    protected int[][] array;
    protected final Set<Day10Coordinate> starts = new HashSet<>();
    protected final Set<Day10Coordinate> targets = new HashSet<>();

    public Day10(List<String> lines) {
        super(lines);
    }

    protected void init() {
        array = new int[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            array[i] = new int[line.length()];
            for (int j = 0; j < line.length(); j++) {
                int height = Integer.parseInt(String.valueOf(line.charAt(j)));
                array[i][j] = height;

                if (height == 0) {
                    starts.add(new Day10Coordinate(i, j));
                }
                if (height == 9) {
                    targets.add(new Day10Coordinate(i, j));
                }
            }
        }
    }

    protected boolean isInBounds(int x, int y) {
        return x >= 0 && x < array.length && y >= 0 && y < array[0].length;
    }
}
