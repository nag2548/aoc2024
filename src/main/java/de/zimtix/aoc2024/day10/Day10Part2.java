package de.zimtix.aoc2024.day10;

import java.util.ArrayList;
import java.util.List;

public class Day10Part2 extends Day10 {
    public Day10Part2(List<String> lines) {
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
        List<Day10Coordinate> reachedTargets = new ArrayList<>();
        checkPaths(start, reachedTargets::add);
        return reachedTargets.size();
    }
}
