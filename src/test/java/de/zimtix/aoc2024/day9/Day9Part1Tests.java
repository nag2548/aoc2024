package de.zimtix.aoc2024.day9;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day9Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day9/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day9/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return null;
    }

    @Override
    protected Object getExpectedRealResult() {
        return null;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day9Part1(lines);
    }
}
