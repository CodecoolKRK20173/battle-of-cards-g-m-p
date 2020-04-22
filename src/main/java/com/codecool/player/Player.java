package com.codecool.player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    private List<Card> hand;
    private String name;

    public Player(String name){
        hand = new ArrayList<>();
        this.name = name;
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    public Card throwCard(int index){
        return hand.get(index);
    }

    public int getAmountOfCards(){
        return hand.size();
    }

    public String getName() {
        return name;
    }

    public abstract StatsType getStatsType(String cardImage);


}


