package com.codecool.app;

import com.codecool.player.*;

public class Battle {
    

    public void makeTurn(Player player1, Player player2) {
        //display card to chose the right stats or something like that
        StatsEnum chosenStat = player1.selectStat();

        Card player1Card = player1.throwCard();
        Card player2Card = player2.throwCard();

       
        if(player1Card.compareCard(player2Card, chosenStat)) {
            player1.addCard(player1Card);
            player1.addCard(player2Card);
            //show the winner
        } else {
            player2.addCard(player2Card);
            player1.addCard(player1Card);
            //show the winner
        }

    }



}