package de.zimtix.aoc2024.day15;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class Day15Part1 extends Puzzle {
    private Day15Field[][] fields;
    private List<Day15Direction> movements;
    private Day15Coordinate robot;

    public Day15Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();
        move();
        return getGpsSum();
    }

    private void init() {
        int emptyLineIndex = IntStream.range(0, lines.size()).filter(i -> StringUtils.isBlank(lines.get(i))).findFirst().orElseThrow();

        List<String> mapLines = lines.subList(0, emptyLineIndex);
        fields = new Day15Field[mapLines.size()][];
        for (int i = 0; i < mapLines.size(); i++) {
            String line = mapLines.get(i);
            fields[i] = new Day15Field[line.length()];
            for (int j = 0; j < line.length(); j++) {
                Day15FieldType fieldType = Day15FieldType.fromChar(line.charAt(j));
                fields[i][j] = new Day15Field(new Day15Coordinate(i, j), fieldType);

                if (fieldType == Day15FieldType.ROBOT) {
                    robot = new Day15Coordinate(j, i);
                }
            }
        }

        movements = lines.subList(emptyLineIndex + 1, lines.size()).stream()
                .map(l -> l.chars().mapToObj(c -> Day15Direction.fromDirection((char) c)).toList())
                .flatMap(Collection::stream)
                .toList();
    }

    private void move() {
        for (Day15Direction movement : movements) {
            Day15Field oldField = fields[robot.x()][robot.y()];
            int newX = robot.x() + movement.getX();
            int newY = robot.y() + movement.getY();
            Day15Field newField = fields[newX][newY];

            if (newField.getFieldType() == Day15FieldType.WALL) {
                continue;
            }

            if (newField.getFieldType() == Day15FieldType.GROUND) {
                oldField.setFieldType(Day15FieldType.GROUND);
                newField.setFieldType(Day15FieldType.ROBOT);
                robot = new Day15Coordinate(newX, newY);
            }

            if (newField.getFieldType() == Day15FieldType.BOX) {
                Day15Coordinate newFieldCoordinate = newField.getCoordinate();
                Day15Field subsequentField = fields[newFieldCoordinate.x()][newFieldCoordinate.y()];
                do {
                    Day15Coordinate subsequentCoordinate = subsequentField.getCoordinate();
                    subsequentField = fields[subsequentCoordinate.x() + movement.getX()][subsequentCoordinate.y() + movement.getY()];
                } while (subsequentField.getFieldType() == Day15FieldType.BOX);

                if (subsequentField.getFieldType() == Day15FieldType.GROUND) {
                    oldField.setFieldType(Day15FieldType.GROUND);
                    subsequentField.setFieldType(Day15FieldType.BOX);
                    newField.setFieldType(Day15FieldType.ROBOT);
                    robot = new Day15Coordinate(newX, newY);
                }
            }
        }
    }

    private int getGpsSum() {
        int sum = 0;
        for (Day15Field[] row : fields) {
            for (Day15Field field : row) {
                if (field.getFieldType() == Day15FieldType.BOX) {
                    Day15Coordinate coordinate = field.getCoordinate();
                    sum += coordinate.x() * 100 + coordinate.y();
                }
            }
        }
        return sum;
    }
}
