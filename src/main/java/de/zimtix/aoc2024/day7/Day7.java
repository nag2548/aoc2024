package de.zimtix.aoc2024.day7;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;

import static java.lang.Long.parseLong;
import static java.math.BigInteger.valueOf;
import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.split;
import static org.apache.commons.lang3.StringUtils.splitByWholeSeparator;

public abstract class Day7 extends Puzzle {
    private List<Day7Equation> equations;
    private final List<BiFunction<BigInteger, BigInteger, BigInteger>> operators = getOperators();

    public Day7(List<String> lines) {
        super(lines);
    }

    protected BigInteger getSum() {
        init();

        BigInteger result = valueOf(0);
        for (Day7Equation equation : equations) {
            if (matchesTestValue(equation)) {
                result = result.add(equation.testValue());
            }
        }
        return result;
    }

    private void init() {
        equations = lines.stream()
                .map(line -> {
                    String[] split = splitByWholeSeparator(line, ": ");
                    List<BigInteger> numbers = stream(split(split[1], " ")).map(i -> valueOf(parseLong(i))).toList();
                    return new Day7Equation(valueOf(parseLong(split[0])), numbers);
                })
                .toList();
    }

    private boolean matchesTestValue(Day7Equation equation) {
        List<BigInteger> numbers = equation.numbers();
        Pair<BigInteger, Boolean> result = test(Pair.of(numbers.getFirst(), false), 1, equation.testValue(), numbers);
        return result.getLeft().equals(equation.testValue()) && result.getRight();
    }

    protected Pair<BigInteger, Boolean> test(Pair<BigInteger, Boolean> currentValue, int nextIndex, BigInteger testValue, List<BigInteger> numbers) {
        if (currentValue.getLeft().compareTo(testValue) == 0 && nextIndex == numbers.size()) {
            return Pair.of(currentValue.getLeft(), true);
        }

        if (nextIndex >= numbers.size()) {
            return Pair.of(currentValue.getLeft(), false);
        }

        BigInteger nextValue = numbers.get(nextIndex);
        for (BiFunction<BigInteger, BigInteger, BigInteger> operator : operators) {
            BigInteger newValue = operator.apply(currentValue.getLeft(), nextValue);
            Pair<BigInteger, Boolean> lastValue = test(Pair.of(newValue, currentValue.getRight()), nextIndex + 1, testValue, numbers);

            if (lastValue.getRight()) {
                return lastValue;
            }
        }

        return Pair.of(currentValue.getLeft(), false);
    }

    protected abstract List<BiFunction<BigInteger, BigInteger, BigInteger>> getOperators();
}
