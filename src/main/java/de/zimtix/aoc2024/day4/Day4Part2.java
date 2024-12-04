package de.zimtix.aoc2024.day4;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Day4Part2 extends Day4 {
    private static final String MAS = "MAS";

    private int result;
    private String[][] array;

    public Day4Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        result = 0;

        array = lines.stream()
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        for (int i = 0; i < array.length - MAS.length() + 1; i++) {
            for (int j = 0; j < array[i].length - MAS.length() + 1; j++) {
                searchBlock(i, j);
            }
        }

        return result;
    }

    private void searchBlock(int i, int j) {
        searchDiagonal(i, j);
    }

    private void searchDiagonal(int i, int j) {
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for (int k = 0; k < MAS.length(); k++) {
            sbLeft.append(array[i + k][j + k]);
            sbRight.append(array[i + k][j + MAS.length() - 1 - k]);
        }
        if (checkLine(sbLeft.toString()) && checkLine(sbRight.toString())) {
            result++;
        }
    }

    private boolean checkLine(String line) {
        return StringUtils.equalsAny(MAS, line, StringUtils.reverse(line));
    }
}
