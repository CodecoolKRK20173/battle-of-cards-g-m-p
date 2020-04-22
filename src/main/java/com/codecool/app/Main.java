package com.codecool.app;

import java.util.List;
import com.codecool.player.*;
import com.codecool.screens.Display;

public class Main {

    public static void main(String[] args) {
        
        Display display = new Display();
        boolean isRunning = true;

        while(isRunning) {
            switch (display.startScreen()) {
                case "start":
                    int number = display.choseAmountToDeal(52, 3);
                    System.out.println(number);
                    display.pressEnterToContinue();
                    List<Player> players = display.providePlayers();
                    Player player1 = players.get(0);
                    Player player2 = players.get(1);
                    Deck deck = new Deck();
                    deck.dealCards(player1, player2);
                    Game game = new Game(player1, player2);
                    game.gameLoop();
                    break;
                case "quit":
                    isRunning = false;
                    break;
            }
        }  
    }

}