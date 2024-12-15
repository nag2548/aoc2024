package de.zimtix.aoc2024.day15;

import de.zimtix.FileInputTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day15Part2Tests implements FileInputTest {
    @Test
    void sample2() {
        List<String> lines = readLines("day15/sample2.txt");
        Day15Part2 cut = new Day15Part2(lines);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(9021);
    }

    @Test
    void real() {
        List<String> lines = readLines("day15/real.txt");
        Day15Part2 cut = new Day15Part2(lines);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(1441031);
    }
}
