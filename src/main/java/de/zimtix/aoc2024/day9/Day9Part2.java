package de.zimtix.aoc2024.day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9Part2 extends Day9 {
    public Day9Part2(List<String> lines) {
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
        int left;
        int right = disks.size() - 1;

        while (right > 0) {
            String rightString = disks.get(right);
            while (right > 0 && POINT.equals(rightString)) {
                rightString = disks.get(--right);
            }

            List<String> righties = new ArrayList<>();
            righties.add(rightString);
            int rightiesIndex = right;
            while (rightiesIndex > 0 && disks.get(rightiesIndex - 1).equals(rightString)) {
                righties.add(disks.get(--rightiesIndex));
            }

            int rightiesSize = righties.size();
            left = getLeft(disks, rightiesIndex, rightiesSize);

            if (left != -1) {
                if (left < right) {
                    for (String ignored : righties) {
                        Collections.swap(disks, left, right);
                        left++;
                        right--;
                    }
                }
            } else {
                right = rightiesIndex - 1;
            }
        }

        return disks;
    }

    private int getLeft(List<String> disks, int maxIndex, int rightSize) {
        int left = 0;
        String leftString;
        while (left < disks.size() && left < maxIndex) {
            leftString = disks.get(left);
            while (!POINT.equals(leftString) && left < maxIndex) {
                leftString = disks.get(++left);
            }

            if (POINT.equals(leftString)) {
                boolean allPoint = true;
                for (int i = left + 1; i < left + rightSize; i++) {
                    if (!POINT.equals(disks.get(i)) || i >= maxIndex) {
                        allPoint = false;
                        break;
                    }
                }

                if (allPoint) {
                    return left;
                } else {
                    left++;
                }
            }
        }

        return -1;
    }
}
