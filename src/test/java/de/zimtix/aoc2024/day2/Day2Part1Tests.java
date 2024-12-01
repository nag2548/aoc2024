package de.zimtix.aoc2024.day2;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day2Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day2/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day2/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 2;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 516;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day2Part1(lines);
    }
}
