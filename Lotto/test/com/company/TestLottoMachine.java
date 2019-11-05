package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLottoMachine {
    public static final Logger logger = LoggerFactory.getLogger(TestLottoMachine.class);
    LottoMachine lottoMachine;

    @BeforeEach
    public void beforeEach() {
        Supplier<LottoMachine> supplier = LottoMachine::createMachine;
        lottoMachine = supplier.get();
    }

    @Test
    public void create() {
        assertEquals(45, lottoMachine.numberListSize());
        logger.debug(lottoMachine.toString());
    }

    @Test
    public void winningNumberBalls() {
        Ticket winningTicket = lottoMachine.printWinningTicket();
        logger.debug("winningTicket : " + winningTicket.toString());
        assertEquals(6, winningTicket.size());
    }

    @Test
    public void buyTicket() {
        List<Ticket> ticket = lottoMachine.printTicket(2000);
        assertEquals(2, ticket.size());
    }

    @Test
    public void matchTicket() {
        Ticket winningTicket = lottoMachine.testWinningTicket();
        List<Ticket> ticketList = lottoMachine.testTicket(3000);
        assertEquals(3, lottoMachine.match(winningTicket, ticketList));
    }

    @Test
    public void manualTicket() {
        String input = "2 3 4 5 1 6";
        assertEquals(Ticket.maker(Arrays.asList(new NumberBall(1), new NumberBall(2), new NumberBall(3), new NumberBall(4), new NumberBall(5), new NumberBall(6))),
                lottoMachine.printManualTicket(input));
    }
}
