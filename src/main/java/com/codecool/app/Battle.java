package com.codecool.app;

import com.codecool.player.*;
import com.codecool.screens.Display;

public class Battle {

    Display display;

    public Battle() {
        display = new Display();
    }
    

    public void makeTurn(Player player1, Player player2) {
       
        Card player1Card = player1.throwCard(0);
        Card player2Card = player2.throwCard(0);

        StatsType statsType = display.statisticsSelection(display.getCardImage(10), "asdfasdf");
        display.printCardsHand(display.getCardImage(10), "nameOfPlayer");
        display.pressEnterToContinue();
       
        // if(player1Card.compareCard(player2Card, chosenStat)) {
        //     player1.addCard(player1Card);
        //     player1.addCard(player2Card);
        //     //show the winner
        // } else {
        //     player2.addCard(player2Card);
        //     player1.addCard(player1Card);
        //     //show the winner
        // }

    }



}