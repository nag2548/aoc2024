package de.zimtix.aoc2024.day3;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Part2 extends Day3 {
    private static final Pattern PATTERN = Pattern.compile("(mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\))");
    private static final String DO = "do()";
    private static final String DONT = "don't()";

    public Day3Part2(List<String> lines) {
        super(lines);
    }

    @Override
    protected int getLineResult(String line) {
        int lineResult = 0;
        Matcher matcher = PATTERN.matcher(line);
        boolean isEnabled = true;
        while (matcher.find()) {
            if (DO.equals(matcher.group(1))) {
                isEnabled = true;
            } else if (DONT.equals(matcher.group(1))) {
                isEnabled = false;
            } else {
                if (isEnabled) {
                    lineResult += Integer.parseInt(matcher.group(2)) * Integer.parseInt(matcher.group(3));
                }
            }
        }
        return lineResult;
    }
}
