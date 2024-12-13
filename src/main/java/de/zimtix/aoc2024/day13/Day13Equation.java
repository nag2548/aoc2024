package de.zimtix.aoc2024.day13;

import java.math.BigDecimal;

public class Day13Equation {
    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal result;

    public Day13Equation(BigDecimal a, BigDecimal b, BigDecimal result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public void multiply(BigDecimal value) {
        this.a = this.a.multiply(value);
        this.b = this.b.multiply(value);
        this.result = this.result.multiply(value);
    }

    public void subtract(Day13Equation other) {
        this.a = this.a.subtract(other.getA());
        this.b = this.b.subtract(other.getB());
        this.result = this.result.subtract(other.getResult());
    }
}
