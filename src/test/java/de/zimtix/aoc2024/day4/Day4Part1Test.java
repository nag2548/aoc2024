package de.zimtix.aoc2024.day4;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day4Part1Test extends PuzzleTest {
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
        return null;
    }

    @Override
    protected Object getExpectedRealResult() {
        return null;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day4Part1(lines);
    }
}
