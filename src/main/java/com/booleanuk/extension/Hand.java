package com.booleanuk.extension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand {
    List<String> cards;
    Map<String, Integer> cardPointMap;
    Map<String, Integer> handPointMap;
    int points;

    public Hand(List<String> cards){
        this.cards = cards;

        this.cardPointMap = new HashMap<>();
        this.handPointMap = new HashMap<>();

        for(int i = 2; i <= 10; i++) { //For all numerical card values
            this.cardPointMap.put(String.valueOf(i), i);
        }
        this.cardPointMap.put("J", 11);
        this.cardPointMap.put("Q", 12);
        this.cardPointMap.put("K", 13);
        this.cardPointMap.put("A", 14);

        this.handPointMap.put("P", 100); //Pair
        this.handPointMap.put("T", 200); //Three of a kind

        this.points = calcPoints();
    }

    private int calcPoints(){
        int points = 0;

        Map<String, Integer> countMap = countCards();

        int highestSameCard = 0;
        String highestCardType = "";
        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            int count = entry.getValue();
            if(count > highestSameCard){
                highestSameCard = count;
                highestCardType = entry.getKey();
            }
        }

        if(highestSameCard == 3){
            points += this.handPointMap.get("T"); //Tripple
        }
        else if(highestSameCard == 2){
            points += this.handPointMap.get("P"); //Pair
        }

        if(highestSameCard > 1){
            points += this.cardPointMap.get(highestCardType);
        }

        return points;
    }

    private Map<String, Integer> countCards(){
        Map<String, Integer> countMap = new HashMap<>();
        for(String card : this.cards){
            countMap.putIfAbsent(card, 0);
            countMap.put(card, countMap.get(card)+1);
        }
        return countMap;
    }

    public List<String> getCards() {
        return cards;
    }

    public Map<String, Integer> getCardPointMap() {
        return cardPointMap;
    }

    public Map<String, Integer> getHandPointMap() {
        return handPointMap;
    }

    public int getPoints() {
        return points;
    }
}
