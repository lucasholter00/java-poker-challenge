package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Extension1Test {
    @Test
    public void shouldReturnAnEmptyArray() {
        List<Hand> hands = List.of(new Hand(List.of("K", "5")), new Hand(List.of("3", "7")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertNull(result);
    }

    @Test
    public void highestOfTwoPairsWins() {
        List<Hand> hands = List.of(new Hand(List.of("K", "K")), new Hand(List.of("A", "A")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        System.out.println(hands.get(0).getPoints() + " " + hands.get(1).getPoints());
        Assertions.assertEquals(List.of("A", "A"), result.getCards());
    }

    @Test
    public void highestPairInListWins() {
        List<Hand> hands = List.of(new Hand(List.of("4", "3")), new Hand(List.of("6", "6")),
                            new Hand(List.of("7", "7")), new Hand(List.of("3", "3")));

        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertEquals(List.of("7", "7"), result.getCards());
    }

    @Test
    public void noWinnerFromList() {

        List<Hand> hands = List.of(new Hand(List.of("K", "5")), new Hand(List.of("3", "7")),
                new Hand(List.of("4", "3")), new Hand(List.of("2", "6")),
                new Hand(List.of("K", "7")), new Hand(List.of("A", "3")));

        Poker poker = new Poker(hands);

        Hand result = poker.winningHand();
        Assertions.assertNull(result);
    }
}