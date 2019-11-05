package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class NumberBall {
    public static final Logger logger = LoggerFactory.getLogger(NumberBall.class);

    private final int number;

    NumberBall(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberBall that = (NumberBall) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int isBig(NumberBall o2) {
        return this.number - o2.number;
    }

    public int isSmall(NumberBall o2) {
        return o2.number - this.number;
    }
}
