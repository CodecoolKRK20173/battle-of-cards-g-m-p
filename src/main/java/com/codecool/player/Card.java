package com.codecool.player;

public class Card {
    private String name;
    private int health = 0;
    private int strength = 0;
    private int magic= 0;

    public Card(String name, int health, int strength, int magic){
      this.name = name;
      this.health = health;
      this.strength = strength;
      this.magic = magic;
    }
    
    // public Stats getStats(Stats stat) {
		//   return null;
	// }
        
}
