package com.codecool.app;

import com.codecool.player.*;

public class Main {

    public static void main() {
        

        Deck deck = new Deck();        
    
        Player player1 = new Person();
        Player player2 = new Person();
        Game game = new Game(player1, player2);
        game.gameLoop();


        
    }

}