package de.zimtix.aoc2024.day13;

import java.util.List;

public class Day13Part1 extends Day13 {
    public Day13Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init(0L);
        return getTokens();
    }
}
