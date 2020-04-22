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

    public void dealCards(Player... players) {
        while (deck.size() > players.length){
            for (Player player : players) {
                    player.addCard(deck.get(0));
                    deck.remove(0);
            }
        }
    }
}