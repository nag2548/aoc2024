package de.zimtix.aoc2024.day2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.split;

public class Day2Part2 extends Day2 {
    public Day2Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        List<List<Integer>> levelList = lines.stream()
                .map(l -> stream(split(l, ' ')).map(Integer::parseInt).toList())
                .toList();

        int safeCount = 0;

        for (List<Integer> levels : levelList) {
            if (isSafe(levels) || isSafeWithOneRemoval(levels)) {
                safeCount++;
            }
        }

        return safeCount;
    }

    private boolean isSafeWithOneRemoval(List<Integer> levels) {
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> newLevels = new ArrayList<>(levels.size() - 1);

            for (int j = 0; j < levels.size(); j++) {
                if (j != i) {
                    newLevels.add(levels.get(j));
                }
            }

            if (isSafe(newLevels)) {
                return true;
            }
        }

        return false;
    }
}
