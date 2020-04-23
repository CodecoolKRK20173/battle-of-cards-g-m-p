package com.codecool.screens;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.codecool.parser.CardParser;
import com.codecool.player.*;
import main.java.com.codecool.screens.Menu;

public class Display {

    Scanner scan = new Scanner(System.in);
    Menu menu = new Menu();
    
    

    public String startScreen() {
        clearScreen();
        menu.draw();
        String userInput = scan.nextLine();
        return userInput;
    }
    
    public void battleScreen(List<Card> cards, List<Player> players, String winnerName) {
        clearScreen();
        for (int i = 0; i < cards.size(); i++)
            System.out.printf("\nPlayer: %s%s\n\n", players.get(i).getName(), cards.get(i).getCardImage());
        System.out.printf("\nThis battle wins: %s\n", winnerName);
        pressEnterToContinue();
    }
    public void cardScreen(){
        clearScreen();
        CardParser cp = new CardParser();
        for(Card card : cp.parse()){
            System.out.println(card.getCardImage());

        }
        System.out.println("press any key to continue");
        scan.nextLine();
    }
    public void infoScreen(){
        clearScreen();
        System.out.println("Welcome to our game! rules are about comparison each other cards by HEALTH, STREANGTH, MAGIC");
        System.out.println();
        System.out.println("you can select one of abilities, and then check if you win!");
        System.out.println();
        System.out.println("create or delate your cards by providing 'new'/'delete'");
        System.out.println();
        System.out.println("check your deck by providing 'cards'");
        System.out.println();
        System.out.println();
        System.out.println("created By: \n Grzegorz Maleta \n Piotr Król \n Milosz Buchacz");
        System.out.println();
        System.out.println("press any key to exit");
        scan.nextLine();
    }

    public StatsType statisticsSelection(String cardImage, String nameOfPlayer) {
        printCardsHand(cardImage, nameOfPlayer);
        while(true) {
            System.out.println("\nProvide number of attribute you want to fight with:\n" +
                    "    1. stats1\n    1. stats2\n    1. stats3\n");
            switch (scan.nextLine()) {
                case "1":
                    return StatsType.STATS1;
                case "2":
                    return StatsType.STATS2;
                case "3":
                    return StatsType.STATS3;
                default:
                    System.out.println("That's not a proper number!");
                    break;
            }
        }
    }

    public void printCardsHand(String cardImage, String nameOfPlayer) {
        clearScreen();
        System.out.println(cardImage);
        System.out.println(String.format("Player: %s", nameOfPlayer));
    }

    public void printCardsHand(String cardImage, String nameOfPlayer, String chosenType) {
        printCardsHand(cardImage, nameOfPlayer);
        System.out.printf("Chosen type: %s\n", chosenType);
        pressEnterToContinue();
    }
    
    public void pressEnterToContinue() {
        System.out.println("\nPress ENTER to continue\n");
        scan.nextLine();
    }

    public int choseAmountToDeal(int amountOfCards, int amountOfPlayers) {
        clearScreen();
        int maxAmount = Math.floorDiv(amountOfCards, amountOfPlayers);
        int amount = 0;
        do{
            System.out.printf("\nProvide how many cards you want give each player: (from 1 to %s)\n\n", maxAmount);
            try{
                amount = Integer.parseInt(scan.nextLine());
                if(amount <= 0 || amount >= maxAmount) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println("That's not a proper number!");
            }

        }while(amount <= 0 || amount > maxAmount);
        return amount;
    }

    public void informationAboutDefeat(String nameOfLoser) {
        clearScreen();
        System.out.printf("\n\n\n    Player: %s just lost the game!\n\n", nameOfLoser);
        pressEnterToContinue();
    }

    public List<Player> providePlayers() {
        clearScreen();
        int maxNumberOfPlayers = 4;
        List<Player> players = new ArrayList<>();
        for (int numeral = 1; numeral<=maxNumberOfPlayers; numeral++)
            addPlayer(players, players.size() >= 2, numeral);
        return players;
    }

    private void addPlayer(List<Player> players, boolean isNotRequired, int numeral) {
        boolean playerIsNotChosen = true;
        while(playerIsNotChosen) {
            System.out.printf("Provide number of %d player:\n\n1. Person\n2.Computer\n%s",
                    numeral, isNotRequired ? "3. None\n":"");
            switch (scan.nextLine()) {
                case "1":
                    System.out.println("Provide name of player:");
                    players.add(new Person(scan.nextLine()));
                    playerIsNotChosen = false;
                    break;
                case "2":
                    players.add(new Computer(String.format("Computer%s", numeral)));
                    playerIsNotChosen = false;
                    break;
                case "3":
                    if (isNotRequired) {
                        playerIsNotChosen = false;
                    }
                default:
                    System.out.println("\nThat's not a proper number!\n");
                    break;
            }
        }
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}