package de.zimtix.aoc2024.day3;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day3Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day3/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day3/real.txt";
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
        return new Day3Part1(lines);
    }
}
