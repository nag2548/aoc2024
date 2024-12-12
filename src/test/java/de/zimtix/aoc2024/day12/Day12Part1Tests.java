package de.zimtix.aoc2024.day12;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day12Part1Tests extends PuzzleTest {
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
        return 1930L;
    }

    @Override
    protected Object getExpectedRealResult() {
        return 1930L;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day12Part1(lines);
    }
}
