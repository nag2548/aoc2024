package de.zimtix.aoc2024.day13;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.splitByWholeSeparator;

public abstract class Day13 extends Puzzle {
    private final List<Day13Game> games = new ArrayList<>();

    public Day13(List<String> lines) {
        super(lines);
    }

    protected void init(long priceAddition) {
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            int count = 3;
            List<String> gameLines = new ArrayList<>(count);
            while (count > 0) {
                String line = iterator.next();
                if (StringUtils.isBlank(line)) {
                    continue;
                }
                gameLines.add(line);
                count--;
            }
            Day13Button a = createButton(gameLines.getFirst(), "Button A: ", "+");
            Day13Button b = createButton(gameLines.get(1), "Button B: ", "+");
            Day13Button prize = createButton(gameLines.get(2), "Prize: ", "=");
            prize.setX(prize.getX().add(BigDecimal.valueOf(priceAddition)));
            prize.setY(prize.getY().add(BigDecimal.valueOf(priceAddition)));
            games.add(new Day13Game(a, b, prize));
        }
    }

    protected long getTokens() {
        long tokens = 0;
        for (Day13Game game : games) {
            Pair<BigDecimal, BigDecimal> aAndB = solveGame(game);
            BigDecimal resultA = aAndB.getLeft();
            BigDecimal resultB = aAndB.getRight();
            if (isIntegerValue(resultA) && isIntegerValue(resultB)) {
                tokens += resultA.longValue() * 3;
                tokens += resultB.longValue();
            }
        }

        return tokens;
    }

    private Day13Button createButton(String line, String linePrefix, String splitCharacter) {
        String substring = line.substring(linePrefix.length());
        String[] split = splitByWholeSeparator(substring, ", ");
        int x = Integer.parseInt(splitByWholeSeparator(split[0], splitCharacter)[1]);
        int y = Integer.parseInt(splitByWholeSeparator(split[1], splitCharacter)[1]);
        return new Day13Button(BigDecimal.valueOf(x), BigDecimal.valueOf(y));
    }

    private Pair<BigDecimal, BigDecimal> solveGame(Day13Game game) {
        Day13Button a = game.getA();
        Day13Button b = game.getB();
        Day13Button prize = game.getPrize();

        Day13Equation first = new Day13Equation(a.getX(), b.getX(), prize.getX());
        Day13Equation second = new Day13Equation(a.getY(), b.getY(), prize.getY());

        BigDecimal firstA = first.getA();
        BigDecimal secondA = second.getA();
        first.multiply(secondA);
        second.multiply(firstA);

        second.subtract(first);

        BigDecimal resultB = second.getResult().divide(second.getB(), MathContext.DECIMAL128);

        BigDecimal firstB = first.getB();
        first.setB(firstB.multiply(resultB));
        BigDecimal firstResult = first.getResult();
        first.setResult(firstResult.subtract(first.getB()));
        BigDecimal resultA = first.getResult().divide(first.getA(), MathContext.DECIMAL128);

        return Pair.of(resultA, resultB);
    }

    private boolean isIntegerValue(BigDecimal bd) {
        return bd.stripTrailingZeros().scale() <= 0;
    }
}
