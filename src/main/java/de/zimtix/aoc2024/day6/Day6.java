package de.zimtix.aoc2024.day6;

import de.zimtix.aoc2024.Puzzle;

import java.util.List;

public abstract class Day6 extends Puzzle {
    protected Day6Field[][] fields;
    protected Day6Field start;
    protected Day6Direction currentDirection = Day6Direction.UP;
    protected final List<Day6Direction> directions = Day6Direction.getDirections();

    public Day6(List<String> lines) {
        super(lines);
    }

    protected void init() {
        fields = new Day6Field[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            fields[i] = new Day6Field[line.length()];
            for (int j = 0; j < line.length(); j++) {
                fields[i][j] = new Day6Field(Day6FieldType.fromChar(line.charAt(j)), new Day6Coordinate(i, j));

                if (fields[i][j].getType() == Day6FieldType.START) {
                    start = fields[i][j];
                }
            }
        }
    }
}
