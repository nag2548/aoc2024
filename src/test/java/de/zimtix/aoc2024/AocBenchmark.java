package de.zimtix.aoc2024;

import de.zimtix.FileInputTest;
import de.zimtix.aoc2024.day5.Day5Part2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AocBenchmark implements FileInputTest {
    @Disabled
    @Test
    public void launchBenchmark() throws Exception {
        Options opt = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.SingleShotTime)
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(3)
                .measurementTime(TimeValue.seconds(1))
                .measurementIterations(3)
                .threads(2)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Thread)
    public static class BenchmarkState implements FileInputTest {
        List<String> lines;

        @Setup(Level.Trial)
        public void initialize() {
            lines = readLines("day5/real.txt");
        }
    }

    @Benchmark
    public void benchmark1(BenchmarkState state) {
        Day5Part2 cut = new Day5Part2(state.lines);
        cut.getResult();
    }
}
