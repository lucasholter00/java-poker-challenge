package com.booleanuk.extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Extension2Test {
    @Test
    public void shouldReturnAnEmptyArray() {

        List<Hand> hands = List.of(new Hand(List.of("K", "5")), new Hand(List.of("3", "7")),
                                   new Hand(List.of("K", "J", "4")));

        Poker poker = new Poker(hands);

        Hand result = poker.winningHand();
        Assertions.assertNull(result);
    }

    @Test
    public void compareTwoHandsOfThree() {
        List<Hand> hands = List.of(new Hand(List.of("5", "5", "3")), new Hand(List.of("7", "7", "7")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertEquals(List.of("7","7","7"), result.getCards());
    }

    @Test
    public void compareMultipleHandsOfThree() {
        List<Hand> hands = List.of(new Hand(List.of("7", "2", "7")), new Hand(List.of("A", "A", "A")),
                                   new Hand(List.of("5", "5", "3")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertEquals(List.of("A", "A", "A"), result.getCards());
    }

    @Test
    public void threeOfAKindBeatsTwoOfAKind() {
        List<Hand> hands = List.of(new Hand(List.of("7", "2", "7")), new Hand(List.of("5", "5", "5")),
                                   new Hand(List.of("4", "5")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertEquals(List.of("5", "5", "5"), result.getCards());
    }

    @Test
    public void pairsBeatDisparateThreeOfAKind() {
        List<Hand> hands = List.of(new Hand(List.of("J", "J")), new Hand(List.of("9", "9")),
                                   new Hand(List.of("6", "6", "4")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertEquals(List.of("J", "J"), result.getCards());
    }

    @Test
    public void pairInAThreeCanWin() {
        List<Hand> hands = List.of(new Hand(List.of("10", "10", "J")), new Hand(List.of("9", "9")),
                                   new Hand(List.of("6", "5", "4")));
        Poker poker = new Poker(hands);
        Hand result = poker.winningHand();
        Assertions.assertEquals(List.of("10", "10", "J"), result.getCards());
    }
}
