package de.zimtix.aoc2024.day5;

import java.util.List;

public class Day5Part1 extends Day5 {
    public Day5Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        int result = 0;
        for (List<Integer> pages : pagesList) {
            boolean isValid = checkPages(pages);
            if (isValid) {
                result += pages.get(pages.size() / 2);
            }
        }

        return result;
    }

    private boolean checkPages(List<Integer> pages) {
        return checkForBadPage(pages) == null;
    }
}
