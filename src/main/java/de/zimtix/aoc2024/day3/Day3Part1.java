package de.zimtix.aoc2024.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part1 extends Day3 {
    private static final Pattern PATTERN = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

    public Day3Part1(List<String> lines) {
        super(lines);
    }

    @Override
    protected int getLineResult(String line) {
        int lineResult = 0;
        Matcher matcher = PATTERN.matcher(line);
        while (matcher.find()) {
            lineResult += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }
        return lineResult;
    }
}
