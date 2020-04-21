package com.codecool.app;

import com.codecool.player.*;
import com.codecool.screens.Display;

public class Main {

    public static void main(String[] args) {
        
        Display display = new Display();
        boolean isRunning = true;

        while(isRunning) {
            switch (display.startScreen()) {
                case "start":
                    Player player1 = new Person();
                    Player player2 = new Person();
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