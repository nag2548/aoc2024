package de.zimtix.aoc2024.day15;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Day15Node {
    private final Pair<Day15LargeField, Day15LargeField> current;
    private final List<Day15Node> next = new ArrayList<>();
    private final Day15Node parent;

    public Day15Node(Pair<Day15LargeField, Day15LargeField> current, Day15Node parent) {
        this.current = current;
        this.parent = parent;
    }

    public Day15Node(Pair<Day15LargeField, Day15LargeField> current) {
        this(current, null);
    }

    public Pair<Day15LargeField, Day15LargeField> getCurrent() {
        return current;
    }

    public List<Day15Node> getNext() {
        return next;
    }

    public Day15Node getParent() {
        return parent;
    }

    public Day15Node addNext(Pair<Day15LargeField, Day15LargeField> next) {
        Day15Node newNode = new Day15Node(next, this);
        this.next.add(newNode);
        return newNode;
    }

    public boolean allLeavesAreBoxes() {
        if (next.isEmpty() && (Day15Part2.isBox(current.getLeft()) || Day15Part2.isBox(current.getRight()))) {
            return true;
        }
        if (!next.isEmpty()) {
            return next.stream().allMatch(Day15Node::allLeavesAreBoxes);
        }
        return false;
    }

    public boolean allLeavesAreGround(Day15Direction movement) {
        if (next.isEmpty()) {
            if (movement == Day15Direction.UP || movement == Day15Direction.DOWN) {
                return Day15Part2.isGround(current.getLeft()) && Day15Part2.isGround(current.getRight());
            }
            if (movement == Day15Direction.LEFT) {
                return Day15Part2.isGround(current.getRight());
            }
            return Day15Part2.isGround(current.getLeft());
        }
        if (!next.isEmpty()) {
            return next.stream().allMatch(day15Node -> day15Node.allLeavesAreGround(movement));
        }
        return false;
    }

    public List<Day15Node> getLeaves() {
        if (next.isEmpty()) {
            return List.of(new Day15Node(current, parent));
        } else {
            return next.stream().map(Day15Node::getLeaves).flatMap(Collection::stream).collect(Collectors.toList());
        }
    }
}
