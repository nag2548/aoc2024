package de.zimtix.aoc2024.day13;

import java.math.BigDecimal;

public class Day13Button {
    private BigDecimal x;
    private BigDecimal y;

    public Day13Button(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }
}
