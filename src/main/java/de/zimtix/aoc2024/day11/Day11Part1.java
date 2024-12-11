package de.zimtix.aoc2024.day11;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day11Part1 extends Day11 {
    public Day11Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        List<Long> stones = Arrays.stream(StringUtils.split(lines.getFirst(), " ")).map(Long::parseLong).toList();

        int times = 25;
        while (times > 0) {
            List<Long> newStones = new ArrayList<>();
            for (Long stone : stones) {
                if (stone == 0) {
                    newStones.add(1L);
                } else if (String.valueOf(stone).length() % 2 == 0) {
                    String stoneString = String.valueOf(stone);
                    int mid = stoneString.length() / 2;
                    newStones.add(Long.parseLong(stoneString.substring(0, mid)));
                    newStones.add(Long.parseLong(stoneString.substring(mid)));
                } else {
                    newStones.add(stone * 2024);
                }
            }
            stones = newStones;
            times--;
        }

        return stones.size();
    }
}
