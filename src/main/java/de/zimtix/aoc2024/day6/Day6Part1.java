package de.zimtix.aoc2024.day6;

import java.util.List;

public class Day6Part1 extends Day6 {
    public Day6Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        return getVisitedFields().size();
    }
}
