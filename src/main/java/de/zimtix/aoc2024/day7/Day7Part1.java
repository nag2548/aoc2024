package de.zimtix.aoc2024.day7;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;

public class Day7Part1 extends Day7 {
    public Day7Part1(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        return getSum();
    }

    @Override
    protected List<BiFunction<BigInteger, BigInteger, BigInteger>> getOperators() {
        return List.of(BigInteger::add, BigInteger::multiply);
    }
}
