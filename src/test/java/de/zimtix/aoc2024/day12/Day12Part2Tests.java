package de.zimtix.aoc2024.day12;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day12Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day12/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day12/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return 1206L;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 886364L;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day12Part2(lines);
    }
}
