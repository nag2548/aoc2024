package de.zimtix.aoc2024.day5;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day5Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day5/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day5/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 123;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 6767;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day5Part2(lines);
    }
}
