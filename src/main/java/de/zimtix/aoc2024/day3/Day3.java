package de.zimtix.aoc2024.day3;

import de.zimtix.aoc2024.Puzzle;

import java.util.List;

public abstract class Day3 extends Puzzle {
    public Day3(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        String line = String.join("\n", lines);
        return getLineResult(line);
    }

    protected abstract int getLineResult(String line);
}
