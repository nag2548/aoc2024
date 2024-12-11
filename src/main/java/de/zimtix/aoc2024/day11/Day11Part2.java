package de.zimtix.aoc2024.day11;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day11Part2 extends Day11 {
    public Day11Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        Map<Long, Long> stoneMap = new HashMap<>();
        List<Long> stones = Arrays.stream(StringUtils.split(lines.getFirst(), " "))
                .map(Long::parseLong)
                .toList();

        for (Long stone : stones) {
            stoneMap.merge(stone, 1L, Long::sum);
        }

        for (int i = 0; i < 75; i++) {
            Map<Long, Long> newStoneMap = new HashMap<>();

            for (Map.Entry<Long, Long> entry : stoneMap.entrySet()) {
                long stone = entry.getKey();
                long count = entry.getValue();

                if (stone == 0L) {
                    newStoneMap.merge(1L, count, Long::sum);
                } else if (String.valueOf(stone).length() % 2 == 0) {
                    String str = String.valueOf(stone);
                    int mid = str.length() / 2;
                    String left = str.substring(0, mid);
                    String right = str.substring(mid);

                    long leftNum = Long.parseLong(left);
                    long rightNum = Long.parseLong(right);

                    newStoneMap.merge(leftNum, count, Long::sum);
                    newStoneMap.merge(rightNum, count, Long::sum);
                } else {
                    newStoneMap.merge(stone * 2024L, count, Long::sum);
                }
            }

            stoneMap = newStoneMap;
        }

        return stoneMap.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
