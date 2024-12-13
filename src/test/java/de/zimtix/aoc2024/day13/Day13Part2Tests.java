package de.zimtix.aoc2024.day13;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day13Part2Tests extends PuzzleTest {
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
        return 875318608908L;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 83197086729371L;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day13Part2(lines);
    }
}
