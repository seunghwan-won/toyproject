package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ticket {
    private static final Logger logger = LoggerFactory.getLogger(Ticket.class);

    private final List<NumberBall> ticket;

    private Ticket(List<NumberBall> numberList) {
        this.ticket = numberList;
    }

    public static Ticket maker(List<NumberBall> numberList) {
        return new Ticket(numberList.stream().limit(6).collect(Collectors.toList()));
    }


    public int size() {
        return ticket.size();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket=" + ticket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return ticket.containsAll(ticket1.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    public Integer getOne() {
        return 1;
    }
}
