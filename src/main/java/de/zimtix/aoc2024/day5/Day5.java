package de.zimtix.aoc2024.day5;

import de.zimtix.aoc2024.Puzzle;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.split;

public abstract class Day5 extends Puzzle {
    protected Map<Integer, List<Integer>> rules;
    protected List<List<Integer>> pagesList;

    public Day5(List<String> lines) {
        super(lines);
    }

    protected void init() {
        rules = new HashMap<>();
        pagesList = new ArrayList<>();

        boolean isRule = true;
        for (String line : lines) {
            if (isEmpty(line)) {
                isRule = false;
                continue;
            }

            if (isRule) {
                String[] split = split(line, '|');
                rules.computeIfAbsent(parseInt(split[0]), k -> new ArrayList<>()).add(parseInt(split[1]));
            } else {
                List<Integer> pages = Arrays.stream(split(line, ',')).map(Integer::parseInt).toList();
                pagesList.add(pages);
            }
        }
    }

    protected Pair<Integer, Integer> checkForBadPage(List<Integer> pages) {
        return checkForBadPage(pages, 0);
    }

    protected Pair<Integer, Integer> checkForBadPage(List<Integer> pages, int startIndex) {
        for (int i = startIndex; i < pages.size(); i++) {
            List<Integer> rulesForPage = rules.get(pages.get(i));
            if (rulesForPage == null) {
                continue;
            }

            List<Integer> previousPages = pages.subList(0, i);
            OptionalInt pageIndexWithViolatedRule =
                    IntStream.range(0, previousPages.size()).filter(j -> rulesForPage.contains(previousPages.get(j))).findFirst();
            if (pageIndexWithViolatedRule.isPresent()) {
                return Pair.of(i, pageIndexWithViolatedRule.getAsInt());
            }
        }
        return null;
    }
}
