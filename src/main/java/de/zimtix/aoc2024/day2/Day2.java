package de.zimtix.aoc2024.day2;

import de.zimtix.aoc2024.Puzzle;

import java.util.List;

public abstract class Day2 extends Puzzle {
    public Day2(List<String> lines) {
        super(lines);
    }

    protected int findFaultyIndex(List<Integer> levels) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < levels.size(); i++) {
            int diff = levels.get(i) - levels.get(i - 1);
            int delta = Math.abs(diff);

            if (delta < 1 || delta > 3) {
                return i - 1;
            }

            if (diff > 0) {
                isDecreasing = false;
            }
            if (diff < 0) {
                isIncreasing = false;
            }
            if (!isIncreasing && !isDecreasing) {
                return i - 1;
            }
        }

        return -1;
    }
}
