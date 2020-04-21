package com.codecool.screens;

import java.util.Scanner;

import com.codecool.player.StatsType;

public class Display {

    Scanner scan = new Scanner(System.in);

    public String startScreen() {
        clearScreen();
        System.out.println("\n\n\n    Provide \"start\" to run game\n\n    Provide \"quit\" to quit\n\n");
        String userInput = scan.nextLine();
        return userInput;
    }

    public void displayBattleScreen(String player1Name, String player2Name, String player1CardImage, String player2CardImage) {
        clearScreen();
        System.out.printf(String.format("\nPlayer: %s\n\n%s\nPlayer: %s\n\n%s\nThis battle wins: %s\n", 
                player1Name, player1CardImage, player2Name, player2CardImage, player1Name));
        pressEnterToContinue();
    }

    public StatsType statisticsSelection(String cardImage, String nameOfPlayer) {
        clearScreen();
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
                    System.out.println("That's not appropriate number!");
                    break;
            }
        }
    }

    public void printCardsHand(String cardImage, String nameOfPlayer) {
        System.out.println(cardImage);
        System.out.println(String.format("Player: %s", nameOfPlayer));
    }

    public void pressEnterToContinue() {
        System.out.println("\nPress ENTER to continue\n");
        scan.nextLine();
    }

    public String getCardImage(int amountOfCards) {
        int cardWidth = 50;
        String cardImage = String.format(" %s%s\n %s%s\\\n%s%-50s|\n%s%s|\n%s%-50s|\n%s%-50s|\n%s%-50s|\n %s%s/\n",
                " ".repeat(amountOfCards), "_".repeat(cardWidth-2),
                "/".repeat(amountOfCards), " ".repeat(cardWidth-2),
                "|".repeat(amountOfCards), "cardName",
                "|".repeat(amountOfCards), "-".repeat(cardWidth),
                "|".repeat(amountOfCards), 5,
                "|".repeat(amountOfCards), 5,
                "|".repeat(amountOfCards), 5,
                "\\".repeat(amountOfCards), "_".repeat(cardWidth-2));
        return cardImage;

    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}