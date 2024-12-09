package de.zimtix.aoc2024.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9Part1 extends Day9 {
    public static final String POINT = ".";

    public Day9Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        String line = lines.getFirst();

        List<String> disk = buildLongLine(line);
        List<String> defragmentedLine = swapNumbers(disk);
        return getChecksum(defragmentedLine);
    }

    private List<String> buildLongLine(String line) {
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

    private List<String> swapNumbers(List<String> disks) {
        int left = 0;
        int right = disks.size() - 1;

        while (left < right) {
            String leftString = disks.get(left);
            while (!POINT.equals(leftString)) {
                leftString = disks.get(++left);
            }

            String rightString = disks.get(right);
            while (POINT.equals(rightString)) {
                rightString = disks.get(--right);
            }

            if (left < right) {
                Collections.swap(disks, left, right);
                left++;
                right--;
            }
        }

        return disks;
    }

    private long getChecksum(List<String> defragmentedDisks) {
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
