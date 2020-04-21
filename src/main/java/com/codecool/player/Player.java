package com.codecool.player;

import java.util.ArrayList;
import java.util.List;

public abstract class Player{
    private List<Card> hand;

    Player(){
        hand = new ArrayList<>();
    }
    
    protected void addCard(Card card) {
        hand.add(card);
    }
    protected Card throwCard(int index){
        return hand.get(index);
    }

    protected Stat selectStat(Card card, Stat stat){
        return card.getStat(stat);
    }

    protected int getAmountOfCards(){
        return hand.size();
    }
}


