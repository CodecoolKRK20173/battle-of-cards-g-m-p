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

    public void dealCards(Player player1, Player player2) {
        player1.addCard(deck.get(0));
        player2.addCard(deck.get(1));
        player2.addCard(deck.get(2));
        
    }
}