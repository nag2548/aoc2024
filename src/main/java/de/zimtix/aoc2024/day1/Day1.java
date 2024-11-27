package de.zimtix.aoc2024.day1;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Day1 extends Puzzle {
    public Day1(List<String> lines) {
        super(lines);
    }

    protected Pair<List<Integer>, List<Integer>> extractLists() {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (String line : lines) {
            List<Integer> numbers = Arrays.stream(StringUtils.split(line, ' ')).map(StringUtils::trim).map(Integer::parseInt).toList();
            firstList.add(numbers.get(0));
            secondList.add(numbers.get(1));
        }
        return Pair.of(firstList, secondList);
    }
}
