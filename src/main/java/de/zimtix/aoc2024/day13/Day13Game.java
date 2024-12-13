package de.zimtix.aoc2024.day13;

public class Day13Game {
    private Day13Button a;
    private Day13Button b;
    private Day13Button prize;

    public Day13Game(Day13Button a, Day13Button b, Day13Button prize) {
        this.a = a;
        this.b = b;
        this.prize = prize;
    }

    public Day13Button getA() {
        return a;
    }

    public void setA(Day13Button a) {
        this.a = a;
    }

    public Day13Button getB() {
        return b;
    }

    public void setB(Day13Button b) {
        this.b = b;
    }

    public Day13Button getPrize() {
        return prize;
    }

    public void setPrize(Day13Button prize) {
        this.prize = prize;
    }
}
