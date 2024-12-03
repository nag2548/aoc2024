package de.zimtix.aoc2024.day3;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day3Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day3/sample2.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day3/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 48;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 56275602;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day3Part2(lines);
    }
}
