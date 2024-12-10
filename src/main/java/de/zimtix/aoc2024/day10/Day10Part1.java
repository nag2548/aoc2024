package de.zimtix.aoc2024.day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day10Part1 extends Day10 {
    public Day10Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        int result = 0;
        for (Day10Coordinate start : starts) {
            result += targetsReached(start);
        }

        return result;
    }

    private int targetsReached(Day10Coordinate start) {
        Set<Day10Coordinate> reachedTargets = new HashSet<>();
        checkPaths(start, reachedTargets::add);
        return reachedTargets.size();
    }
}
