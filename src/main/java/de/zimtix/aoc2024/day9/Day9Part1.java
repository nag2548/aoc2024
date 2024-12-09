package de.zimtix.aoc2024.day9;

import java.util.Collections;
import java.util.List;

public class Day9Part1 extends Day9 {
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
}
