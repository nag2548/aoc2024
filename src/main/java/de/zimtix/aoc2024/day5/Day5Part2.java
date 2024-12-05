package de.zimtix.aoc2024.day5;

import java.util.ArrayList;
import java.util.List;

public class Day5Part2 extends Day5 {
    public Day5Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        int result = 0;
        for (List<Integer> pages : pagesList) {
            int badPage = checkForBadPage(pages);
            if (badPage != -1) {
                List<Integer> reorderedPages = reorderPages(pages);
                result += reorderedPages.get(reorderedPages.size() / 2);
            }
        }

        return result;
    }

    private List<Integer> reorderPages(List<Integer> pages) {
        List<Integer> reorderedPages = new ArrayList<>(pages);

        while (true) {
            int badIndex = checkForBadPage(reorderedPages);
            if (badIndex == -1) {
                break;
            }
            Integer removedPage = reorderedPages.remove(badIndex);
            reorderedPages.add(removedPage);
        }

        return reorderedPages;
    }
}
