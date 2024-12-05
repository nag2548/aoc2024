package de.zimtix.aoc2024.day5;

import org.apache.commons.lang3.tuple.Pair;

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
            if (checkForBadPage(pages) != null) {
                List<Integer> reorderedPages = reorderPages(pages);
                result += reorderedPages.get(reorderedPages.size() / 2);
            }
        }

        return result;
    }

    private List<Integer> reorderPages(List<Integer> pages) {
        List<Integer> reorderedPages = new ArrayList<>(pages);

        int index = 0;
        while (true) {
            Pair<Integer, Integer> pagePair = checkForBadPage(reorderedPages, index);
            if (pagePair == null) {
                break;
            }

            int badPageIndex = pagePair.getLeft();
            int violatedPageIndex = pagePair.getRight();
            int removedPage = reorderedPages.remove(badPageIndex);
            reorderedPages.add(violatedPageIndex, removedPage);
            index = violatedPageIndex + 1;
        }

        return reorderedPages;
    }
}
