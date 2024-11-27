package de.zimtix.aoc2024.day1;

import de.zimtix.aoc2024.Puzzle;
import de.zimtix.aoc2024.PuzzleTest;

import java.util.List;

class Day1Part2Tests extends PuzzleTest {
    @Override
    protected String getSampleInputFile() {
        return "day1/sample_part2.txt";
    }

    @Override
    protected String getRealInputFile() {
        return "day1/real_part2.txt";
    }

    @Override
    protected Object getExpectedSampleResult() {
        return null;
    }

    @Override
    protected Object getExpectedRealResult() {
        return null;
    }

    @Override
    protected Puzzle getComponent(List<String> lines) {
        return new Day1Part2(lines);
    }
}
