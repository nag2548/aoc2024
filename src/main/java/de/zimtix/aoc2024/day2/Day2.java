package de.zimtix.aoc2024.day2;

import de.zimtix.aoc2024.Puzzle;

import java.util.List;

public abstract class Day2 extends Puzzle {
    public Day2(List<String> lines) {
        super(lines);
    }

    protected boolean isSafe(List<Integer> levels) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < levels.size(); i++) {
            int diff = levels.get(i) - levels.get(i - 1);

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            if (diff > 0) {
                isDecreasing = false;
            }
            if (diff < 0) {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}
