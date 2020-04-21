package com.codecool.player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    private List<Card> hand;

    public Player(){
        hand = new ArrayList<>();
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    public Card throwCard(int index){
        return hand.get(index);
    }

    // public Stats selectStat(Card card, Stats stat ){
    //     return card.getStats(stat);
    // }

    public int getAmountOfCards(){
        return hand.size();
    }

    public abstract String getName();
}


