package de.zimtix.aoc2024.day13;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day13Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day13/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day13/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 480;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 37297;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day13Part1(lines);
    }
}
