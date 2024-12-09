package de.zimtix.aoc2024.day9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day9Part2 extends Day9 {
    private int maxIndex = -1;
    private Map<Integer, Integer> indexCountMap = new HashMap<>();

    public Day9Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        String line = lines.getFirst();

        String disk = buildLongLine(line);
        String defragmentedLine = swapNumbers(disk);
        return getChecksum("00992111777.44.333....5555.6666.....8888..");
    }

    private String buildLongLine(String line) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < line.length(); i = i + 2) {
            int left = Integer.parseInt(String.valueOf(line.charAt(i)));
            indexCountMap.put(index, left);
            while (left > 0) {
                sb.append(index);
                left--;
            }

            if (i + 1 < line.length()) {
                int right = Integer.parseInt(String.valueOf(line.charAt(i + 1)));
                while (right > 0) {
                    sb.append(".");
                    right--;
                }
            }
            index++;
        }

        maxIndex = index - 1;
        return sb.toString();
    }

    private String swapNumbers(String line) {
        int left = 0;
        int right = line.length() - 1;
        char[] charArray = line.toCharArray();
        int lastIndex = maxIndex;

        while (left < right) {
            char rightChar = charArray[right];
            while (!Character.isDigit(rightChar)) {
                rightChar = charArray[--right];
            }
            String rightNumber = String.valueOf(rightChar);
            while (!rightNumber.equals(String.valueOf(lastIndex))) {
                rightNumber = charArray[--right] + rightNumber;
            }
            int count = indexCountMap.get(lastIndex) - 1;
            indexCountMap.put(lastIndex, count);
            if (count == 0) {
                lastIndex--;
            }

            left = new String(charArray).indexOf(".".repeat(rightNumber.length()));

            for (int i = 0; i < rightNumber.length(); i++) {
                char tmp = charArray[right];
                charArray[right] = charArray[left];
                charArray[left] = tmp;
                left++;
                right--;
            }

            left = new String(charArray).indexOf(".");
        }

        return new String(charArray);
    }

    private long getChecksum(String defragmentedLine) {
        long result = 0;
        for (int i = 0; i < defragmentedLine.length(); i++) {
            char c = defragmentedLine.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Integer.parseInt(String.valueOf(c));
                result += (long) i * digit;
            }
        }
        return result;
    }
}
