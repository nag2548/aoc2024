package de.zimtix.aoc2024.day9;

import de.zimtix.aoc2024.Puzzle;

import java.util.ArrayList;
import java.util.List;

public abstract class Day9 extends Puzzle {
    protected static final String POINT = ".";

    public Day9(List<String> lines) {
        super(lines);
    }

    protected List<String> buildLongLine(String line) {
        List<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < line.length(); i = i + 2) {
            int left = Integer.parseInt(String.valueOf(line.charAt(i)));
            while (left > 0) {
                list.add(String.valueOf(index));
                left--;
            }

            if (i + 1 < line.length()) {
                int right = Integer.parseInt(String.valueOf(line.charAt(i + 1)));
                while (right > 0) {
                    list.add(POINT);
                    right--;
                }
            }
            index++;
        }

        return list;
    }

    protected long getChecksum(List<String> defragmentedDisks) {
        long result = 0;
        for (int i = 0; i < defragmentedDisks.size(); i++) {
            String line = defragmentedDisks.get(i);
            if (!POINT.equals(line)) {
                result += Long.parseLong(line) * i;
            }
        }
        return result;
    }
}
