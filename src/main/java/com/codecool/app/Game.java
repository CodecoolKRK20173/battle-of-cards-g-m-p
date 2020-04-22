package com.codecool.app;

import java.util.ArrayList;
import java.util.List;
import com.codecool.screens.Display;
import com.codecool.player.*;

public class Game{
    

    List<Player> players;
    List<Player> losers;
    Battle battle;
    Display display;

    public Game(List<Player> players) {
        this.players = players;
        losers = new ArrayList<>();
        battle = new Battle();
        display = new Display();
    }

    public void gameLoop() {
        while(nobodyWon()) {
            battle.makeTurn(players);
            checkIfSomebodyLose();
            Player playerToMove = players.get(0);
            players.remove(playerToMove);
            players.add(playerToMove);
        }
        losers.addAll(players);
        // TODO display.endScreen(losers);
    }

    private boolean nobodyWon() {
        if (players.size() == 1)
            return false;
        return true;
    }

    private void checkIfSomebodyLose() {
        for (Player player : players) {
            if (player.getAmountOfCards() == 0) {
                players.remove(player);
                losers.add(player);
                display.informationAboutDefeat(player.getName());
            }
        }
    }

}