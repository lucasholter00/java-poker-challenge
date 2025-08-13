package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Poker {
    String[] hand1;
    String[] hand2;
    Map<String, Integer> pointMap;
    public Poker(String[] hand1, String[] hand2){
        this.hand1 = hand1;
        this.hand2 = hand2;


        pointMap = new HashMap<>();
        for(int i = 2; i <= 10; i++) { //For all numerical card values
            pointMap.put(String.valueOf(i), i);
        }
        pointMap.put("J", 11);
        pointMap.put("Q", 12);
        pointMap.put("K", 13);
        pointMap.put("A", 14);
    }

    private int calculatePairPointsTwoCards(String[] strs){
        if(strs[0].equals(strs[1])){
            return pointMap.get(strs[0]);
        } else {
            return 0;
        }
    }

    // Core
    public String[] winningPair() {
        int pntH1 = calculatePairPointsTwoCards(this.hand1);
        int pntH2 = calculatePairPointsTwoCards(this.hand2);

        if(pntH1 > pntH2){
            return this.hand1;
        } else if(pntH2 > pntH1){
            return this.hand2;
        } else{
            return new String[] {};
        }

        // Implement the winningPair logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
    }

    // Extension 1
    public String[] winningPairFromArray(String[][] hands) {
        // Implement the winningPairFromArray logic here and return the array containing the winning pair to make the tests pass.
        // You can replace the following return value with something appropriate
        return new String[]{"Replace me", "with something else"};
    }

    // Extension 2
    public String[] winningThreeCardHand(String[][] hands) {
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
