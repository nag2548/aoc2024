package de.zimtix.aoc2024.day4;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day4Part1 extends Day4 {
    private static final String XMAS = "XMAS";

    private int result;
    private String[][] array;
    private final Set<Pair<Integer, Integer>> processedHorizontals = new HashSet<>();
    private final Set<Pair<Integer, Integer>> processedVerticals = new HashSet<>();

    public Day4Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        result = 0;

        array = lines.stream()
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        for (int i = 0; i < array.length - XMAS.length() + 1; i++) {
            for (int j = 0; j < array[i].length - XMAS.length() + 1; j++) {
                searchBlock(i, j);
            }
        }

        return result;
    }

    private void searchBlock(int i, int j) {
        searchHorizontal(i, j);
        searchVertical(i, j);
        searchDiagonal(i, j);
    }

    private void searchHorizontal(int i, int j) {
        for (int k = 0; k < XMAS.length(); k++) {
            if (processedHorizontals.contains(Pair.of(i + k, j))) {
                continue;
            }
            processedHorizontals.add(Pair.of(i + k, j));

            StringBuilder sb = new StringBuilder();
            String[] row = array[i + k];
            for (int l = 0; l < XMAS.length(); l++) {
                sb.append(row[j + l]);
            }
            checkLine(sb.toString());
        }
    }

    private void searchVertical(int i, int j) {
        for (int k = 0; k < XMAS.length(); k++) {
            if (processedVerticals.contains(Pair.of(i, j + k))) {
                continue;
            }
            processedVerticals.add(Pair.of(i, j + k));

            StringBuilder sb = new StringBuilder();
            for (int l = 0; l < XMAS.length(); l++) {
                sb.append(array[i + l][j + k]);
            }
            checkLine(sb.toString());
        }
    }

    private void searchDiagonal(int i, int j) {
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for (int k = 0; k < XMAS.length(); k++) {
            sbLeft.append(array[i + k][j + k]);
            sbRight.append(array[i + k][j + XMAS.length() - 1 - k]);
        }
        checkLine(sbLeft.toString());
        checkLine(sbRight.toString());
    }

    private void checkLine(String line) {
        if (StringUtils.equalsAny(XMAS, line, StringUtils.reverse(line))) {
            result++;
        }
    }
}
