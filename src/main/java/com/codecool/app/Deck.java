package com.codecool.app;

import java.util.List;

import com.codecool.parser.CardParser;
import com.codecool.player.*;

public class Deck {
    private List<Card> deck;

    Deck(){
        getCardfromXML();
    }
    
    public void addCardToDeck(Card card) {
        deck.add(card);
    }
    private void getCardfromXML() {
        CardParser cardsParser = new CardParser();
        deck = cardsParser.parse();
    }

    private void dealCard() {
        
    }
}