package de.zimtix.aoc2024.day7;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.math.BigInteger;
import java.util.List;

class Day7Part1Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day7/sample.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day7/real.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return BigInteger.valueOf(3749L);
    }

    @Override
    protected Object getExpectedRealResult() {
        return BigInteger.valueOf(4555081946288L);
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day7Part1(lines);
    }
}
