package com.codecool.app;

import java.util.List;

import com.codecool.parser.CardParser;
import com.codecool.player.*;
import com.codecool.screens.Display;


import main.java.com.codecool.screens.Start;

public class Main {

    public static void main(String[] args) {
        
        Display display = new Display();
        CardParser cardParser = new CardParser();
        boolean isRunning = true;

        while(isRunning) {
            switch (display.startScreen()) {
                case "start":
                    List<Player> players = display.providePlayers();
                    Deck deck = new Deck();
                    deck.dealCards(players);
                    Game game = new Game(players);
                    game.gameLoop();
                    break;
                case "cards":
                    display.cardScreen();
                    break;
                case "new":
                    cardParser.addCard();
                    break;
                case "delete":
                    cardParser.deleteCard();
                    break;
                case "info":
                    display.infoScreen();
                    break;
                case "quit":
                    isRunning = false;
                    break;
            }
        }  
    }

}