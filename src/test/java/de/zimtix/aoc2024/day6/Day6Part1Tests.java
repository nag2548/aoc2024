package de.zimtix.aoc2024.day6;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day6Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day6/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day6/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 41;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 4602;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day6Part1(lines);
    }
}
