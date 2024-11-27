package de.zimtix.aoc2024;

import de.zimtix.FileInputTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class PuzzleTest implements FileInputTest {
    @Test
    void sample() {
        List<String> lines = readLines(getSampleInputFile());
        Puzzle cut = getComponent(lines);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(getExpectedSampleResult());
    }

    @Test
    void real() {
        List<String> lines = readLines(getRealInputFile());
        Puzzle cut = getComponent(lines);

        Object result = cut.getResult();

        assertThat(result).isEqualTo(getExpectedRealResult());
    }

    protected abstract String getSampleInputFile();

    protected abstract String getRealInputFile();

    protected abstract Object getExpectedSampleResult();

    protected abstract Object getExpectedRealResult();

    protected abstract Puzzle getComponent(List<String> lines);
}
