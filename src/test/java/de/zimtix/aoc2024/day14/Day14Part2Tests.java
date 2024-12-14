package de.zimtix.aoc2024.day14;

import de.zimtix.FileInputTest;
import de.zimtix.aoc2024.Puzzle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day14Part2Tests implements FileInputTest {
    @Test
    void real() {
        List<String> lines = readLines("day14/real.txt");
        Puzzle cut = new Day14Part2(lines, 103, 101);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(null);
    }
}
