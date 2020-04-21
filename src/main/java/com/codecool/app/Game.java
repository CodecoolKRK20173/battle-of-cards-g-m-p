package com.codecool.app;

import com.codecool.player.*;

public class Game{
    

    Player player1;
    Player player2;
    Battle battle;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        battle = new Battle();
    }

    public Player gameLoop() {
        while(nobodyWon()) {
            battle.makeTurn(player1, player2);
            if (!(nobodyWon()))
                break;
            battle.makeTurn(player2, player1);
        }
        return getWinner();
    }

    private boolean nobodyWon() {
        if (player1.getAmountOfCards() == 0 || player2.getAmountOfCards() == 0)
            return true; // TODO item
        return true;
    }

    private Player getWinner() {
        if (player1.getAmountOfCards() == 0)
            return player2;
        return player1;
    }

    

}