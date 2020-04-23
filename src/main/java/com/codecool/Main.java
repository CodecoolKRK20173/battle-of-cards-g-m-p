package com.codecool;

import java.util.List;

import com.codecool.app.*;
import com.codecool.player.*;
import com.codecool.screens.Display;

public class Main {
    public static void main(String[] args) {
        
        Display display = new Display();
        boolean isRunning = true;

        while(isRunning) {
            switch (display.startScreen()) {
                case "start":
                    List<Player> players = display.providePlayers();
                    Deck deck = new Deck();
                    deck.shuffleCards();
                    deck.dealCards(players);
                    Game game = new Game(players);
                    game.gameLoop();
                    break;
                case "quit":
                    isRunning = false;
                    break;
            }
        }  
    }

}