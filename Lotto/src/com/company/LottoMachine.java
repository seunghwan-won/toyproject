package com.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class LottoMachine {
    public static final Logger logger = LoggerFactory.getLogger(LottoMachine.class);
    private final List<NumberBall> numberList;

    private LottoMachine() {
        this.numberList = Stream.iterate(1, i -> i + 1).map(i -> new NumberBall(i)).limit(45).collect(Collectors.toList());
    }

    public static LottoMachine createMachine() {
        return new LottoMachine();
    }

    public Integer numberListSize() {
        return numberList.size();
    }

    @Override
    public String toString() {
        return "LottoMachine{" +
                "numberList=" + numberList +
                '}';
    }

    public Ticket printWinningTicket() {
        Collections.shuffle(numberList);
        logger.debug("shuffle : " + numberList.toString());
        return Ticket.maker(numberList);
    }

    public List<Ticket> printTicket(int money) {
        if (money == 0) throw new RuntimeException();
        int count = money / LottoInterface.DEFAULT_PRICE;
        if ((money % LottoInterface.DEFAULT_PRICE) != 0) throw new RuntimeException();
        numberList.sort((o1, o2) -> o1.isBig(o2));
        logger.debug("acs : " + numberList.toString());
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(numberList);
            ticketList.add(Ticket.maker(numberList));
            numberList.sort((o1, o2) -> o1.isBig(o2));
        }
        return ticketList;
    }

    public Ticket testWinningTicket() {
        this.numberList.sort((o1, o2) -> o1.isBig(o2));
        List<NumberBall> temp = numberList.stream().limit(6).collect(Collectors.toList());
        Collections.reverse(temp);
        return Ticket.maker(temp);
    }

    public List<Ticket> testTicket(int money) {
        int count = money / LottoInterface.DEFAULT_PRICE;
        numberList.sort((o1, o2) -> o1.isBig(o2));
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ticketList.add(Ticket.maker(numberList));
        }
        return ticketList;
    }

    public Integer match(Ticket winningTicket, List<Ticket> ticketList) {
        return ticketList.stream().filter((t) -> t.equals(winningTicket)).mapToInt(Ticket::getOne).sum();
    }

    public Ticket printManualTicket(String scanner) {
        return Ticket.maker(Arrays.stream(scanner.split(" ")).map((i) -> new NumberBall(parseInt(i))).collect(Collectors.toList()));
    }
}
