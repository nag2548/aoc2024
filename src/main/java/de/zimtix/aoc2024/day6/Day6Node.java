package de.zimtix.aoc2024.day6;

public class Day6Node {
    private final Day6State state;
    private Day6Node next;

    public Day6Node(Day6State state) {
        this.state = state;
    }

    public Day6State getState() {
        return state;
    }

    public Day6Node getNext() {
        return next;
    }

    public void setNext(Day6Node next) {
        this.next = next;
    }
}
