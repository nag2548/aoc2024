package de.zimtix.aoc2024.day5;

import de.zimtix.aoc2024.Puzzle;

import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
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
                pagesList.add(pages.reversed());
            }
        }
    }

    protected int checkForBadPage(List<Integer> pages) {
        for (int i = 0; i < pages.size(); i++) {
            List<Integer> rulesForPage = rules.get(pages.get(i));
            if (rulesForPage == null) {
                continue;
            }

            List<Integer> nextPages = pages.subList(min(i + 1, pages.size() - 1), pages.size());
            if (nextPages.stream().anyMatch(rulesForPage::contains)) {
                return i;
            }
        }
        return -1;
    }
}
