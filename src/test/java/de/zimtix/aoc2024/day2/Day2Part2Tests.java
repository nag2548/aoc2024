package de.zimtix.aoc2024.day2;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day2Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day2/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day2/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 4;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 561;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day2Part2(lines);
    }
}
