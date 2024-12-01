package de.zimtix.aoc2024.day1;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day1Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day1/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day1/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 11;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 1938424;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day1Part1(lines);
    }
}
