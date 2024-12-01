package de.zimtix.aoc2024.day2;

import java.util.List;

import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.split;

public class Day2Part1 extends Day2 {
    public Day2Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        List<List<Integer>> levelList = lines.stream()
                .map(l -> stream(split(l, ' ')).map(Integer::parseInt).toList())
                .toList();

        int safeReport = 0;

        for (List<Integer> levels : levelList) {
            if (isSafe(levels)) {
                safeReport++;
            }
        }

        return safeReport;
    }
}
