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

       return bestHand == null || bestHand.getPoints() < 100 ? null : bestHand;

    }
}
