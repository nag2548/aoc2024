package de.zimtix.aoc2024.day1;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Day1Part2 extends Day1 {
    public Day1Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        Pair<List<Integer>, List<Integer>> listPair = extractLists();
        List<Integer> firstList = listPair.getLeft();
        List<Integer> secondList = listPair.getRight();
        Map<Integer, Long> secondListOccurrenceMap = secondList.stream()
                .collect(groupingBy(identity(), counting()));

        int result = 0;
        for (Integer first : firstList) {
            result += (int) (secondListOccurrenceMap.getOrDefault(first, 0L) * first);
        }

        return result;
    }
}
