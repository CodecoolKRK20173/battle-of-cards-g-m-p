package com.codecool.player;

import java.util.Random;

import com.codecool.screens.Display;

public class Computer extends Player{

    Random random;
    Display display;

    public Computer(String name) {
        super(name);
        random = new Random();
        display = new Display();
    }

    public StatsType getStatsType(String cardImage) {
        int amountOfTypes = 3;
        switch (random.nextInt(amountOfTypes)) {
            case 0:
                display.printCardsHand(cardImage, super.getName(), "Stats1");
                return StatsType.STATS1;
            case 1:
                display.printCardsHand(cardImage, super.getName(), "Stats2");
                return StatsType.STATS2;
            default:
                display.printCardsHand(cardImage, super.getName(), "Stats3");
                return StatsType.STATS3;
        }
    }
}