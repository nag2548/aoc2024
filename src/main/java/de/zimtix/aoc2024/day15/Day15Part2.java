package de.zimtix.aoc2024.day15;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Day15Part2 extends Puzzle {
    private Day15LargeField[][] fields;
    private List<Day15Direction> movements;
    private Day15Coordinate robot;

    public Day15Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();
        move();
        print();
        return getGpsSum();
    }

    private void init() {
        int emptyLineIndex = IntStream.range(0, lines.size()).filter(i -> StringUtils.isBlank(lines.get(i))).findFirst().orElseThrow();

        List<String> mapLines = lines.subList(0, emptyLineIndex);
        fields = new Day15LargeField[mapLines.size()][];
        for (int i = 0; i < mapLines.size(); i++) {
            String line = mapLines.get(i);
            fields[i] = new Day15LargeField[line.length() * 2];
            for (int j = 0, k = 0; j < line.length(); j++, k = k + 2) {
                List<Day15LargeFieldType> fieldTypes = Day15LargeFieldType.fromChar(line.charAt(j));
                int x = i;
                int y = k;
                IntStream.range(0, fieldTypes.size()).forEach(index -> {
                    Day15LargeFieldType fieldType = fieldTypes.get(index);
                    fields[x][y + index] = new Day15LargeField(new Day15Coordinate(x, y + index), fieldType);

                    if (fieldType == Day15LargeFieldType.ROBOT) {
                        robot = new Day15Coordinate(x, y + index);
                    }
                });
            }
        }

        print();

        movements = lines.subList(emptyLineIndex + 1, lines.size()).stream()
                .map(l -> l.chars().mapToObj(c -> Day15Direction.fromDirection((char) c)).toList())
                .flatMap(Collection::stream)
                .toList();
    }

    private void print() {
        for (Day15LargeField[] row : fields) {
            for (Day15LargeField field : row) {
                System.out.print(field.getFieldType().getCharacter());
            }
            System.out.print("\n");
        }
    }

    private void move() {
        for (Day15Direction movement : movements) {
            System.out.println(movement);

            Day15LargeField oldField = fields[robot.x()][robot.y()];
            int newX = robot.x() + movement.getX();
            int newY = robot.y() + movement.getY();
            Day15LargeField newField = fields[newX][newY];

            if (newField.getFieldType() == Day15LargeFieldType.WALL) {
                continue;
            }

            if (newField.getFieldType() == Day15LargeFieldType.GROUND) {
                oldField.setFieldType(Day15LargeFieldType.GROUND);
                newField.setFieldType(Day15LargeFieldType.ROBOT);
                robot = new Day15Coordinate(newX, newY);
            }

            if (isBox(newField)) {
                Pair<Day15LargeField, Day15LargeField> subsequentBox = getWholeBoxes(newField);
                Day15Node node = new Day15Node(subsequentBox);
                List<Day15Node> prev = List.of(node);
                do {
                    List<Day15Node> nextNodes = new ArrayList<>();

                    for (Day15Node prevNode : prev) {
                        Pair<Day15LargeField, Day15LargeField> box = prevNode.getCurrent();
                        Day15LargeField left = box.getLeft();
                        Day15LargeField right = box.getRight();
                        if (isBox(left) || isBox(right)) {
                            if (movement == Day15Direction.LEFT) {
                                right = box.getLeft();
                            }
                            if (movement == Day15Direction.RIGHT) {
                                left = box.getRight();
                            }
                            Set<Pair<Day15LargeField, Day15LargeField>> nextBoxes = new HashSet<>(getWholeBoxes(fields[left.getCoordinate().x() + movement.getX()][left.getCoordinate().y() + movement.getY()], fields[right.getCoordinate().x() + movement.getX()][right.getCoordinate().y() + movement.getY()]));
                            nextBoxes.forEach(next -> {
                                Day15Node newNode = prevNode.addNext(next);
                                nextNodes.add(newNode);
                            });
                        }
                    }

                    prev = nextNodes;
                } while (node.allLeavesAreBoxes());

                if (node.allLeavesAreGround(movement)) {
                    Day15LargeField[][] copy = getArrayCopy();
                    List<Day15Node> leaves = node.getLeaves();
                    for (Day15Node leaf : leaves) {
                        moveLeaves(copy, movement, leaf);
                    }
                    oldField.setFieldType(Day15LargeFieldType.GROUND);
                    newField.setFieldType(Day15LargeFieldType.ROBOT);
                    robot = new Day15Coordinate(newX, newY);
                }
            }

            print();
        }
    }

    private List<Pair<Day15LargeField, Day15LargeField>> getWholeBoxes(Day15LargeField a, Day15LargeField b) {
        Day15LargeFieldType aType = a.getFieldType();
        Day15LargeFieldType bType = b.getFieldType();
        if ((aType == Day15LargeFieldType.WALL || aType == Day15LargeFieldType.GROUND) && (bType == Day15LargeFieldType.WALL || bType == Day15LargeFieldType.GROUND)) {
            return List.of(Pair.of(a, b));
        }

        return List.of(getWholeBoxes(a), getWholeBoxes(b));
    }

    private void moveLeaves(Day15LargeField[][] copy, Day15Direction movement, Day15Node leaf) {
        Day15Node parent = leaf.getParent();
        Day15Node lastNode = leaf;
        while (parent != null) {
            Day15Coordinate left = lastNode.getCurrent().getLeft().getCoordinate();
            Day15Coordinate right = lastNode.getCurrent().getRight().getCoordinate();

            Day15LargeField parentLeft = copy[parent.getCurrent().getLeft().getCoordinate().x()][parent.getCurrent().getLeft().getCoordinate().y()];
            Day15LargeField parentRight = copy[parent.getCurrent().getRight().getCoordinate().x()][parent.getCurrent().getRight().getCoordinate().y()];

            if (movement == Day15Direction.LEFT) {
                fields[right.x()][right.y()].setFieldType(parentLeft.getFieldType());
                fields[parentLeft.getCoordinate().x()][parentLeft.getCoordinate().y()].setFieldType(parentRight.getFieldType());
            }

            if (movement == Day15Direction.RIGHT) {
                fields[left.x()][left.y()].setFieldType(parentRight.getFieldType());
                fields[parentRight.getCoordinate().x()][parentRight.getCoordinate().y()].setFieldType(parentLeft.getFieldType());
            }

            if (movement == Day15Direction.UP || movement == Day15Direction.DOWN) {
                fields[parentLeft.getCoordinate().x()][parentLeft.getCoordinate().y()].setFieldType(Day15LargeFieldType.GROUND);
                fields[parentRight.getCoordinate().x()][parentRight.getCoordinate().y()].setFieldType(Day15LargeFieldType.GROUND);
                fields[parentLeft.getCoordinate().x() + movement.getX()][parentLeft.getCoordinate().y() + movement.getY()].setFieldType(parentLeft.getFieldType());
                fields[parentRight.getCoordinate().x() + movement.getX()][parentRight.getCoordinate().y() + movement.getY()].setFieldType(parentRight.getFieldType());
            }

            lastNode = parent;
            parent = parent.getParent();
        }

        Day15LargeField lastNodeLeft = lastNode.getCurrent().getLeft();
        Day15LargeField lastNodeRight = lastNode.getCurrent().getRight();

        if (movement == Day15Direction.LEFT) {
            fields[lastNodeRight.getCoordinate().x()][lastNodeRight.getCoordinate().y()].setFieldType(Day15LargeFieldType.GROUND);
        }

        if (movement == Day15Direction.RIGHT) {
            fields[lastNodeLeft.getCoordinate().x()][lastNodeLeft.getCoordinate().y()].setFieldType(Day15LargeFieldType.GROUND);
        }

        if (movement == Day15Direction.UP || movement == Day15Direction.DOWN) {
            fields[lastNodeLeft.getCoordinate().x()][lastNodeLeft.getCoordinate().y()].setFieldType(Day15LargeFieldType.GROUND);
            fields[lastNodeRight.getCoordinate().x()][lastNodeRight.getCoordinate().y()].setFieldType(Day15LargeFieldType.GROUND);
        }
    }

    public static boolean isBox(Day15LargeField field) {
        return field.getFieldType() == Day15LargeFieldType.BOX_LEFT || field.getFieldType() == Day15LargeFieldType.BOX_RIGHT;
    }

    public static boolean isGround(Day15LargeField field) {
        return field.getFieldType() == Day15LargeFieldType.GROUND;
    }

    private Pair<Day15LargeField, Day15LargeField> getWholeBoxes(Day15LargeField newField) {
        Day15LargeFieldType fieldType = newField.getFieldType();
        Day15Coordinate coordinate = newField.getCoordinate();

        if (fieldType == Day15LargeFieldType.BOX_LEFT) {
            return Pair.of(newField, fields[coordinate.x() + Day15Direction.RIGHT.getX()][coordinate.y() + Day15Direction.RIGHT.getY()]);
        }
        return Pair.of(fields[coordinate.x() + Day15Direction.LEFT.getX()][coordinate.y() + Day15Direction.LEFT.getY()], newField);
    }

    private int getGpsSum() {
        int sum = 0;
        for (Day15LargeField[] row : fields) {
            for (Day15LargeField field : row) {
                if (field.getFieldType() == Day15LargeFieldType.BOX_LEFT) {
                    Day15Coordinate coordinate = field.getCoordinate();
                    sum += coordinate.x() * 100 + coordinate.y();
                }
            }
        }
        return sum;
    }

    private Day15LargeField[][] getArrayCopy() {
        Day15LargeField[][] result = new Day15LargeField[fields.length][];
        for (int i = 0; i < fields.length; i++) {
            result[i] = Arrays.stream(fields[i]).map(Day15LargeField::clone).toArray(Day15LargeField[]::new);
        }
        return result;
    }
}
