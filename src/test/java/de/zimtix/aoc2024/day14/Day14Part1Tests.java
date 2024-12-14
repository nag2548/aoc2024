package de.zimtix.aoc2024.day14;

import de.zimtix.FileInputTest;
import de.zimtix.aoc2024.Puzzle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day14Part1Tests implements FileInputTest {
    @Test
    void sample() {
        List<String> lines = readLines("day14/sample.txt");
        Puzzle cut = new Day14Part1(lines, 7, 11);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(12);
    }

    @Test
    void real() {
        List<String> lines = readLines("day14/real.txt");
        Puzzle cut = new Day14Part1(lines, 103, 101);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(233709840);
    }
}
