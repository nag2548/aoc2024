package de.zimtix.aoc2024.day8;

import de.zimtix.aoc2024.Puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public abstract class Day8 extends Puzzle {
    private final Map<String, List<Day8Coordinate>> antennaMap = new HashMap<>();
    private final Set<Day8Coordinate> uniqueAntinodes = new HashSet<>();

    public Day8(List<String> lines) {
        super(lines);
    }

    @Override
    public Object getResult() {
        init();

        for (List<Day8Coordinate> antennaPositions : antennaMap.values()) {
            getAntinodes(antennaPositions);
        }
        return uniqueAntinodes.size();
    }

    private void init() {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) != '.') {
                    antennaMap.computeIfAbsent(String.valueOf(line.charAt(j)), k -> new ArrayList<>()).add(new Day8Coordinate(i, j));
                }
            }
        }
    }

    private void getAntinodes(List<Day8Coordinate> antennaPositions) {
        for (int i = 0; i < antennaPositions.size() - 1; i++) {
            for (int j = i + 1; j < antennaPositions.size(); j++) {
                Day8Coordinate a = antennaPositions.get(i);
                Day8Coordinate b = antennaPositions.get(j);
                int distanceX = b.x() - a.x();
                int distanceY = b.y() - a.y();
                collectAntinodes(a, distanceX, distanceY, (first, second) -> first - second);
                collectAntinodes(b, distanceX, distanceY, Integer::sum);
            }
        }
    }

    protected void putIfInBounds(Day8Coordinate antinode) {
        if (isInBounds(antinode)) {
            uniqueAntinodes.add(antinode);
        }
    }

    protected boolean isInBounds(Day8Coordinate antinode) {
        return antinode.x() >= 0 && antinode.y() >= 0 && antinode.x() < lines.size() && antinode.y() < lines.getFirst().length();
    }

    protected abstract void collectAntinodes(Day8Coordinate coordinate, int x, int y, BiFunction<Integer, Integer, Integer> operation);
}
