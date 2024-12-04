package de.zimtix.aoc2024.day4;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day4Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day4/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day4/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 9;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 2046;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day4Part2(lines);
    }
}
