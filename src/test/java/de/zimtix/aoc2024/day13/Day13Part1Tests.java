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
        return 480L;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 37297L;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day13Part1(lines);
    }
}
