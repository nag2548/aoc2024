package de.zimtix.aoc2024.day1;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.List;

public class Day1Part1 extends Day1 {
    public Day1Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        Pair<List<Integer>, List<Integer>> listPair = extractLists();

        List<Integer> firstList = listPair.getLeft();
        Collections.sort(firstList);
        List<Integer> secondList = listPair.getRight();
        Collections.sort(secondList);

        int result = 0;
        for (int i = 0; i < firstList.size(); i++) {
            Integer first = firstList.get(i);
            Integer second = secondList.get(i);
            result += Math.abs(first - second);
        }

        return result;
    }
}
