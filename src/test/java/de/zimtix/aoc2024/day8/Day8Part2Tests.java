package de.zimtix.aoc2024.day8;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day8Part2Tests extends PuzzleTest {
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
        return 34;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 1417;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day8Part2(lines);
    }
}
