package de.zimtix.aoc2024.day7;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;

import static java.lang.Long.parseLong;
import static java.math.BigInteger.valueOf;

public class Day7Part2 extends Day7 {
    public Day7Part2(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        return getSum();
    }

    @Override
    protected List<BiFunction<BigInteger, BigInteger, BigInteger>> getOperators() {
        return List.of(
                BigInteger::add,
                BigInteger::multiply,
                (a, b) -> {
                    String newNumber = a.toString() + b.toString();
                    return valueOf(parseLong(newNumber));
                }
        );
    }
}
