package de.zimtix.aoc2024.day1;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day1Part1 extends Puzzle {
    public Day1Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        List<List<String>> input = lines.stream()
                .map(l -> Arrays.stream(StringUtils.split(l, ' '))
                        .map(StringUtils::trim)
                        .toList())
                .toList();

        List<Integer> firstList = input.stream().map(i -> Integer.parseInt(i.getFirst())).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> secondList = input.stream().map(i -> Integer.parseInt(i.getLast())).collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(firstList);
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
