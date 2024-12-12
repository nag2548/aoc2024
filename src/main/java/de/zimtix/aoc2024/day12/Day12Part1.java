package de.zimtix.aoc2024.day12;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Day12Part1 extends Day12 {
    public Day12Part1(List<String> lines) {
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
                    Pair<List<Day12Field>, Integer> pair = collectAdjacentPlots(field);
                    price += (long) pair.getLeft().size() * pair.getRight();
                }
            }
        }
        return price;
    }
}
