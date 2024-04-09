/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.sheridancollege.gofish;

import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author PARVINDER KAUR APRIL 2024
 */
public class GoFish {

    public final GoFishHand computerHand;
    public final GoFishHand playerHand;
    private final Deck deck;
    public int playerScore;
    public int computerScore;
    private final Scanner scanner;

    public GoFish() {
        computerHand = new GoFishHand();
        playerHand = new GoFishHand();
        deck = new Deck();
        playerScore = 0;
        computerScore = 0;
        scanner = new Scanner(System.in);
    }

    public void play() {
        dealHands();
        while (playerScore + computerScore < 13) {
            while (playerScore + computerScore < 13 && playerTurn()) {}
            while (playerScore + computerScore < 13 && computerTurn()) {}
        }
        System.out.println("Computer Score: " + computerScore);
        System.out.println("Player Score: " + playerScore);
        if (playerScore > computerScore) {
            System.out.println("Congratulations! You win!");
        } else if (playerScore < computerScore) {
            System.out.println("Sorry, the computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private void dealHands() {
        for (int i = 0; i < 7; i++) {
            computerHand.add(deck.deal());
            playerHand.add(deck.deal());
        }
    }

    public boolean playerTurn() {
        if (playerHand.isEmpty() && !deck.isEmpty()) {
            playerHand.add(deck.deal());
        }
        System.out.println("Computer Hand: " + computerHand.size() + " cards");
        System.out.println("Your Hand: " + playerHand);
        Rank rank = getRankFromUser(); // Change to Rank type
        boolean bonusTurn = computerHand.give(rank, playerHand);
        if (!bonusTurn) {
            System.out.println("Go fish!");
            Card drawnCard = deck.deal();
            playerHand.add(drawnCard);
            System.out.println("You drew: " + drawnCard);
            if (drawnCard.getRank() == rank) {
                bonusTurn = true;
            }
        }
        int sets = playerHand.removeSets();
        playerScore += sets;
        if (sets > 0) {
            System.out.println("You completed " + sets + " sets!");
            System.out.println("Player Score: " + playerScore);
        }
        return bonusTurn;
    }

    public Rank getRankFromUser() {
        System.out.print("Enter the rank you want to ask for: ");
        String input = scanner.nextLine().toUpperCase();
        for (Rank rank : Rank.values()) {
            if (rank.name().equals(input)) {
                return rank;
            }
        }
        return null; // Or handle invalid input appropriately
    }
    

    public int getRankValue(String input) {
        for (Rank rank : Rank.values()) {
            if (rank.name().equals(input)) {
                return rank.ordinal();
            }
        }
        return -1;
    }

    public boolean computerTurn() {
        if (computerHand.isEmpty() && !deck.isEmpty()) {
            computerHand.add(deck.deal());
        }
        System.out.println("Computer Hand: " + computerHand);
        System.out.println("Your Hand: " + playerHand.size() + " cards");
        int rank = (int) (Math.random() * 13);
        boolean bonusTurn = playerHand.give(Rank.values()[rank], computerHand);
        if (!bonusTurn) {
            System.out.println("Go fish!");
            Card drawnCard = deck.deal();
            computerHand.add(drawnCard);
            System.out.println("Computer drew: " + drawnCard);
            if (drawnCard.getRank().ordinal() == rank) {
                bonusTurn = true;
            }
        }
        int sets = computerHand.removeSets();
        computerScore += sets;
        if (sets > 0) {
            System.out.println("Computer completed " + sets + " sets!");
            System.out.println("Computer Score: " + computerScore);
        }
        return bonusTurn;
    }
}


