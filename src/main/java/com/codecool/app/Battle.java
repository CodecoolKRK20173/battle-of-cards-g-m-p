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
        List<Player> fighters = new ArrayList<>();
        fighters.addAll(players);
        
        StatsType statsType = players.get(0).getStatsType(players.get(0).getTopCard()
                .getCardImage());

        List<Card> cardsInTurn = new ArrayList<>();
        List<Card> clipBoard = new ArrayList<>();

        do {
            for (int i = 0; i < fighters.size(); i++) {
                try{
                    display.printCardsHand(fighters.get(i).getTopCard().getCardImage(fighters.get(i).getAmountOfCards()),
                        fighters.get(i).getName());
                    cardsInTurn.add(fighters.get(i).getTopCard());
                } catch (IndexOutOfBoundsException e) {
                    display.printCardsHand("You have got no cards!\nYou lose extra rund!", fighters.get(i).getName());
                    fighters.remove(i);
                }
                display.pressEnterToContinue();
            }

            List<Card> bestCards = getBestCards(cardsInTurn, statsType);

            String winnerName = "DRAW";
            if (bestCards.size() == 1) {
                for (Player fighter : fighters) {
                    if (fighter.getTopCard() == bestCards.get(0)) {
                        winnerName = fighter.getName();
                    }
                }
            }

            display.battleScreen(cardsInTurn, fighters, winnerName);

            for (int i = 0; i<fighters.size(); i++) {
                clipBoard.add(fighters.get(i).throwCard());
                if (!(bestCards.contains(clipBoard.get(clipBoard.size() - 1)))) {
                    fighters.remove(i);
                    i--;
                }
            }
            cardsInTurn.removeAll(cardsInTurn);

        }while (fighters.size() != 1);

        for (Card card : clipBoard) {
            fighters.get(0).addCard(card);
        }

    }

    private List<Card> getBestCards(List<Card> cardsInTurn, StatsType statsType) {
        List<Card> bestCards = new ArrayList<>();
        bestCards.add(cardsInTurn.get(0));
        for (int i = 1; i<cardsInTurn.size(); i++) {
            switch (bestCards.get(0).compareCard(cardsInTurn.get(i), statsType)) {
                case BETTER:
                    bestCards.removeAll(bestCards);
                case SAME:
                    bestCards.add(cardsInTurn.get(i));
                default:
                    break;
            }
        }
        return bestCards;
    }

}