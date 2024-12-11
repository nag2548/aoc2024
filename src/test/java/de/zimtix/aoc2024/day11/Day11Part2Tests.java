package de.zimtix.aoc2024.day11;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day11Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day11/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day11/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 65601038650482L;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 234568186890978L;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day11Part2(lines);
    }
}
