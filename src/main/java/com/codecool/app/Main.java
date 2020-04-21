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
                    System.out.println(display.getCardImage(10));
                    Player player1 = new Person();
                    Player player2 = new Person();
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