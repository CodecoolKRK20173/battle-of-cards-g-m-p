package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import com.codecool.player.*;
import com.codecool.screens.Display;

public class Battle {

    Display display;

    public Battle() {
        display = new Display();
    }

    public void makeTurn(List<Player> players) {
        List<Card> cards = new ArrayList<>();
        List<Integer> amountOfCards = new ArrayList<>();
        for (Player player : players){
            amountOfCards.add(player.getAmountOfCards());
            cards.add(player.throwCard());
        }
        
        StatsType statsType = players.get(0).getStatsType(cards.get(0).getCardImage(amountOfCards.get(0)));
        Card bestCard = cards.get(0);

        for (int i = 1; i < players.size(); i++) {
            display.printCardsHand(cards.get(i).getCardImage(amountOfCards.get(i)), players.get(i).getName());
            display.pressEnterToContinue();
            if (cards.get(i).compareCard(bestCard, statsType))
                bestCard = cards.get(i);
        }

        int winnerIndex = cards.indexOf(bestCard);
        
        display.battleScreen(cards, players.get(winnerIndex).getName());

        for (Card card : cards)
            players.get(winnerIndex).addCard(card);

    }

}