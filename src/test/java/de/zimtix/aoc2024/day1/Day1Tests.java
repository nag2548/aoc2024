package de.zimtix.aoc2024.day1;

import de.zimtix.FileInputTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

class Day1Tests implements FileInputTest {
    @Test
    void sample() {
        List<String> lines = readLines("day1/sample.txt");
        Day1 cut = new Day1(lines);

        String result = cut.getResult();

        assertNull(result);
    }
}
