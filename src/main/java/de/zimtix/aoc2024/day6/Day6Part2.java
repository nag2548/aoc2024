package de.zimtix.aoc2024.day6;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Day6Part2 extends Day6 {
    public Day6Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();
        Set<Day6Coordinate> visitedFields = getVisitedFields();
        currentDirection = Day6Direction.UP;

        int result = 0;
        for (Day6Field[] row : fields) {
            for (Day6Field field : row) {
                if (!visitedFields.contains(field.getCoordinate())) {
                    continue;
                }

                Day6FieldType originalType = field.getType();
                if (originalType == Day6FieldType.NORMAL) {
                    Day6Field[][] copy = getArrayCopy();
                    copy[field.getCoordinate().x()][field.getCoordinate().y()].setType(Day6FieldType.OBSTACLE);

                    Day6LoopDetector loopDetector = new Day6LoopDetector(copy, start);
                    if (loopDetector.doesLoop()) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private Day6Field[][] getArrayCopy() {
        Day6Field[][] result = new Day6Field[fields.length][];
        for (int i = 0; i < fields.length; i++) {
            result[i] = Arrays.stream(fields[i]).map(Day6Field::clone).toArray(Day6Field[]::new);
        }
        return result;
    }
}
