package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExerciseTest {
    @Test
    public void shouldReturnAnEmptyArrayWhenNoPair() {
        Poker poker = new Poker(new String[]{"Q", "6"}, new String[]{"J", "K"});
        String[] result = poker.winningPair();
        Assertions.assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void shouldReturnHighestPairSimple() {
        Poker poker = new Poker(new String[]{"9", "9"}, new String[]{"7", "7"});
        String[] result = poker.winningPair();
        Assertions.assertArrayEquals(new String[]{"9", "9"}, result);
    }

    @Test
    public void shouldReturnHighestPair() {
        Poker poker = new Poker(new String[]{"K", "3"}, new String[]{"K", "K"});
        String[] result = poker.winningPair();
        Assertions.assertArrayEquals(new String[]{"K", "K"}, result);
    }

    @Test
    public void shouldReturnHighestPairMoreComplex() {
        Poker poker = new Poker(new String[]{"K", "K"}, new String[]{"A", "A"});
        String[] result = poker.winningPair();
        Assertions.assertArrayEquals(new String[]{"A", "A"}, result);
    }
}
