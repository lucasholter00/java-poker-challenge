package com.booleanuk.extension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poker {
    List<Hand> hands;

    public Poker(List<Hand> hands){
        this.hands = hands;
    }

    public Hand winningHand(){
        Hand bestHand = null;

        for(Hand hand : this.hands){
            if(bestHand == null){
                bestHand = hand;
            }
            if(hand.getPoints() > bestHand.getPoints()){
                bestHand = hand;
            }
        }

        return bestHand == null || bestHand.getPoints() == 0 ? null : bestHand;

    }

    // Extension 2
    public String[] winningThreeCardHand() {

        // Implement the winningThreeCardHand logic here and return the array containing the winning hand to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{"Replace me", "with something else"};
    }

    // Extension 3
    public String extensionThreeMethods() {
        // Completely replace this method with suitable methods to solve Extension 3
        // You will also need to add the relevant tests to Extension3Test.java
        return "Replace this method with your own methods and tests";
    }
}
