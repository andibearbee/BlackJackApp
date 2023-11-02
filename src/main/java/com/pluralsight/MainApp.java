package com.pluralsight;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


import static com.pluralsight.Hand.players;
import static com.pluralsight.Hand.playerNum;

public class MainApp {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/PlayersandHands.csv", true));

            Deck deck = new Deck();
            Hand dealerHand = new Hand();
            deck.shuffle();

            System.out.print("Welcome to Black Jack!" + "\n" +
                    "Rules are as follows: \n" +
                    "One: 2-7 Players per round. \n" +
                    "Two: Each player will be dealt 2 cards. \n " +
                    "The first round of dealt cards will be face down while the second will be placed face up next to the previously dealt card. \n" +
                    "The value of cards 2-10 reflect their number, whereas Face cards are 10. \n " +
                    "An Ace can be either 1 or 11 and determined by the player each hand. \n" +
                    "Please enter the number of players at the table. (Remember to choose a number between 2 and 7.) ");
            int numOfPlayers = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numOfPlayers && numOfPlayers <= 7; i++) {
                Hand playerHand = new Hand();
                System.out.println("What is the name of Player " + (i + 1) + "?");
                String playerName = scanner.nextLine();
                players.add(playerName);
                playerHand.deal(deck.deal());
                playerHand.deal(deck.deal());

                int handValue = playerHand.getValue();
                System.out.println("This hand is worth " + handValue);

                writer.write(playerName + "|" + handValue);
                writer.newLine();
            }

            writer.close();


            // deal 2 cards to every player. One face down and one face up
            for (int i = 1; i < 8; i++) {
                // get a card from the deck
                Card card = deck.deal();
                // deal that card to the hand
                dealerHand.deal(card);
            }


        }
        catch (IOException error) {
            error.printStackTrace();
        }
        }
    }



