package de.zimtix.aoc2024;

import java.util.List;

public abstract class Puzzle {
    protected final List<String> lines;

    public Puzzle(List<String> lines) {
        this.lines = lines;
    }

    public abstract <T> T getResult();
}
