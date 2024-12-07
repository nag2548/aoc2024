package de.zimtix.aoc2024.day7;

import de.zimtix.aoc2024.Puzzle;

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
        return test(numbers.getFirst(), 1, equation.testValue(), numbers);
    }

    protected boolean test(BigInteger currentValue, int nextIndex, BigInteger testValue, List<BigInteger> numbers) {
        if (currentValue.compareTo(testValue) == 0 && nextIndex == numbers.size()) {
            return true;
        }

        if (nextIndex >= numbers.size()) {
            return false;
        }

        BigInteger nextValue = numbers.get(nextIndex);
        for (BiFunction<BigInteger, BigInteger, BigInteger> operator : operators) {
            BigInteger newValue = operator.apply(currentValue, nextValue);
            boolean lastValue = test(newValue, nextIndex + 1, testValue, numbers);

            if (lastValue) {
                return true;
            }
        }

        return false;
    }

    protected abstract List<BiFunction<BigInteger, BigInteger, BigInteger>> getOperators();
}
