package com.booleanuk.extension;

import java.util.*;

public class Hand {
    List<String> cards;
    Map<String, Integer> cardPointMap;
    Map<String, Integer> handPointMap;
    List<Integer> tieBreak;

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
        this.handPointMap.put("TP", 200); //two Pair
        this.handPointMap.put("T", 300); //Three of a kind
        this.handPointMap.put("FH", 400); //Full house
        this.handPointMap.put("F", 500); //Four of a kind

        List<String> cardList = new ArrayList<>(this.cards);

        this.points = calcPoints(cardList);

        this.tieBreak = new ArrayList<>();

        while(!cardList.isEmpty()){
            tieBreak.add(calcPoints(cardList));
        }



    }



    private int calcPoints(List<String> cards){
        int points = 0;

        Map<String, Integer> countMap = countCards(cards);

        int highestSameCard = 0;
        int secondHighestSameCard = 0;
        String highestCardType = "";
        String secondHighestCardType = "";
        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            int count = entry.getValue();
            if(count > highestSameCard){

                secondHighestSameCard = highestSameCard;
                secondHighestCardType = highestCardType;
                highestSameCard = count;
                highestCardType = entry.getKey();
            }
        }

        boolean isFlush = true;
        for(int i = 1; i < cards.size(); i++){
            isFlush = isFlush && cards.get(i).getSuit().equals(cards.get(0).getSuit());
        }
        if(isFlush){
            points += this.handPointMap.get("F");
        }

        List<Integer> vals = new ArrayList<>();
        for(String card : cards){
            vals.add(this.handPointMap.get(card));
        }

        Collections.sort(vals);

        if(highestSameCard == 4){
            points += this.handPointMap.get("T"); //Four of a kind
            removeCardTypeCount(highestCardType ,highestSameCard, cards);
        }
        else if(highestSameCard == 3 && secondHighestSameCard >= 2){
            points += this.handPointMap.get("FH"); //Full house

            removeCardTypeCount(highestCardType ,highestSameCard, cards);
            removeCardTypeCount(secondHighestCardType ,secondHighestSameCard, cards);

        }
        else if(highestSameCard == 3){
            points += this.handPointMap.get("T"); //Triple
            removeCardTypeCount(highestCardType ,highestSameCard, cards);
        }
        else if(highestSameCard >= 2 && secondHighestSameCard >= 2){
            points += this.handPointMap.get("TP"); //Two pair
            removeCardTypeCount(highestCardType ,highestSameCard, cards);
        }
        else if(highestSameCard == 2){
            points += this.handPointMap.get("P"); //Pair
            removeCardTypeCount(highestCardType ,highestSameCard, cards);
        }

        if (highestSameCard == 1){
            removeCardTypeCount(highestCardType, highestSameCard, cards);
        }

        points += this.cardPointMap.get(highestCardType);
        return points;
    }

    private void removeCardTypeCount(String type, int count, List<String> list){
        int i = count;
        while(i > 0){
            list.remove(type);
            i--;
        }

    }

    private Map<String, Integer> countCards(List<String> cards){
        Map<String, Integer> countMap = new HashMap<>();
        for(String card : cards){
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

    public List<Integer> getTieBreak() {
        return tieBreak;
    }
}
