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
            Player playerToMove = players.get(0);
            players.remove(playerToMove);
            players.add(playerToMove);
            checkIfSomebodyLose();
        }
        losers.addAll(players);
        // TODO display.endScreen(losers);
    }

    private boolean nobodyWon() {
        if (players.size() <= 1)
            return false;
        return true;
    }

    private void checkIfSomebodyLose() {
        for (int i = 0; i<players.size(); i++) {
            if (players.get(i).getAmountOfCards() == 0) {
                losers.add(players.get(i));
                display.informationAboutDefeat(players.get(i).getName());
                players.remove(i);
                i--;
            }
        }
    }

}