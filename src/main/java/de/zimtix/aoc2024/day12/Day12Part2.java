package de.zimtix.aoc2024.day12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toCollection;

public class Day12Part2 extends Day12 {
    public Day12Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();
        return calculatePrices();
    }

    private long calculatePrices() {
        long price = 0;
        for (Day12Field[] plot : plots) {
            for (Day12Field field : plot) {
                if (!field.isVisited()) {
                    List<Day12Field> area = collectAdjacentPlots(field).getLeft();
                    price += countSides(area);
                }
            }
        }
        return price;
    }

    private int countSides(List<Day12Field> area) {
        int horizontals = getHorizontals(area);
        int verticals = getVerticals(area);

        return (horizontals + verticals) * area.size();
    }

    private int getHorizontals(List<Day12Field> area) {
        Map<Integer, List<Day12Field>> sortedByX = area.stream()
                .collect(groupingBy(a -> a.getCoordinate().x(),
                        getCollector(comparing(a -> a.getCoordinate().y()))));

        int upBorder = 0;
        int downBorder = 0;
        for (List<Day12Field> row : sortedByX.values()) {
            upBorder += calculateBorder(row, Day12Direction.UP, Day12Coordinate::y);
            downBorder += calculateBorder(row, Day12Direction.DOWN, Day12Coordinate::y);
        }
        return upBorder + downBorder;
    }

    private int getVerticals(List<Day12Field> area) {
        Map<Integer, List<Day12Field>> sortedByY = area.stream()
                .collect(groupingBy(a -> a.getCoordinate().y(),
                        getCollector(comparing(a -> a.getCoordinate().x()))));

        int leftBorder = 0;
        int rightBorder = 0;
        for (List<Day12Field> column : sortedByY.values()) {
            leftBorder += calculateBorder(column, Day12Direction.LEFT, Day12Coordinate::x);
            rightBorder += calculateBorder(column, Day12Direction.RIGHT, Day12Coordinate::x);
        }
        return leftBorder + rightBorder;
    }

    private int calculateBorder(List<Day12Field> row, Day12Direction direction, Function<Day12Coordinate, Integer> lastValueGetter) {
        int border = 0;
        int lastValue = -1;
        boolean hasBoundary = false;

        for (Day12Field field : row) {
            Day12Coordinate coordinate = field.getCoordinate();
            char plant = field.getPlant();

            int xNeighbor = coordinate.x() + direction.getX();
            int yNeighbor = coordinate.y() + direction.getY();

            if (!isInBounds(xNeighbor, yNeighbor) || plots[xNeighbor][yNeighbor].getPlant() != plant) {
                int value = lastValueGetter.apply(coordinate);
                if (!hasBoundary || lastValue != value - 1) {
                    border++;
                }
                lastValue = value;
                hasBoundary = true;
            } else {
                hasBoundary = false;
            }
        }

        return border;
    }

    private Collector<Day12Field, Object, List<Day12Field>> getCollector(Comparator<Day12Field> comparator) {
        return collectingAndThen(toCollection(ArrayList::new),
                l -> {
                    l.sort(comparator);
                    return l;
                }
        );
    }
}
