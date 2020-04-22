package com.codecool.player;

import com.codecool.screens.Display;

public class Person extends Player{

    Display display;

    public Person(String name){
        super(name);
        display = new Display();
    }
    
    public StatsType getStatsType(String cardImage) {
        return display.statisticsSelection(cardImage, this.getName());
    }

}