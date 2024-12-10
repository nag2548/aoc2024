package de.zimtix.aoc2024.day11;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day11Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day11/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day11/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return -1;
    }

    @Override
    protected Object getExpectedRealResult() {
        return -1;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day11Part1(lines);
    }
}
