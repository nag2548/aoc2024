package de.zimtix.aoc2024.day8;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day8Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day8/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day8/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 14;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 413;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day8Part1(lines);
    }
}
