package de.zimtix.aoc2024.day14;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day14Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day14/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day14/real.txt";
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
        return new Day14Part1(lines);
    }
}
