package de.zimtix.aoc2024.day7;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.math.BigInteger;
import java.util.List;

class Day7Part2Tests extends PuzzleTest {
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
        return BigInteger.valueOf(11387L);
    }

    @Override
    protected Object getExpectedRealResult() {
        return BigInteger.valueOf(227921760109726L);
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day7Part2(lines);
    }
}
