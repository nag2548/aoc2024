package de.zimtix.aoc2024.day10;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day10Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day10/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day10/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return -1;
    }

    @Override
    protected Object getExpectedRealResult() {
        return -1;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day10Part2(lines);
    }
}
