package de.zimtix.aoc2024.day13;

import java.util.List;

public class Day13Part2 extends Day13 {
    public Day13Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init(10000000000000L);
        return getTokens();
    }
}
