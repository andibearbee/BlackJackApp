package com.pluralsight;

public class MainApp {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand1 = new Hand();
// deal 5 cards
        for(int I = 0; I < 5; i++) {
// get a card from the deck
            Card card = deck.deal();
// deal that card to the hand
            hand1.deal(card)
        }
        int handValue = hand1.getValue();
        System.out.println("This hand is worth " + handValue);
    }
}
