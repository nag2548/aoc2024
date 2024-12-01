package de.zimtix.aoc2024.day1;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day1Part2 extends Puzzle {
    public Day1Part2(List<String> lines) {
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

        int result = 0;
        for (Integer first : firstList) {
            long occurrences = secondList.stream().filter(i -> Objects.equals(i, first)).count();
            result += (int) (occurrences * first);
        }

        return result;
    }
}
