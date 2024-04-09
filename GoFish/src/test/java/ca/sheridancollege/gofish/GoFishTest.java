/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.gofish;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PARVINDER KAUR
 */
public class GoFishTest {
    
    @Test
    public void testPlay() {
        // Arrange
        GoFish goFish = new GoFish();
        ByteArrayInputStream in = new ByteArrayInputStream("ACE\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Act
        goFish.play();
        String output = outContent.toString().trim();
        
        // Assert
        assertTrue(output.contains("Player Score"));
    }
    
    @Test
    public void testDealHands() {
        // Arrange
        GoFish goFish = new GoFish();
        
        // Act
        goFish.play();
        int playerHandSize = goFish.playerHand.size();
        int computerHandSize = goFish.computerHand.size();
        
        // Assert
        assertEquals(7, playerHandSize);
        assertEquals(7, computerHandSize);
    }
    
    @Test
    public void testGetRankValue() {
        // Arrange
        GoFish goFish = new GoFish();
        
        // Act
        int value = goFish.getRankValue("ACE");
        
        // Assert
        assertEquals(0, value);
    }
    
    @Test
    public void testPlayerTurn_BonusTurn() {
        // Arrange
        GoFish goFish = new GoFish();
        goFish.playerHand.add(new Card(Rank.ACE, Suit.CLUBS));
        goFish.computerHand.add(new Card(Rank.ACE, Suit.HEARTS));

        // Act
        boolean bonusTurn = goFish.playerTurn();

        // Assert
        assertTrue(bonusTurn);
    }
    
    @Test
    public void testGetRankFromUser() {
        // Arrange
        GoFish goFish = new GoFish();
        ByteArrayInputStream in = new ByteArrayInputStream("ACE\n".getBytes());
        System.setIn(in);
        
        // Act
        Rank rank = goFish.getRankFromUser();
        
        // Assert
        assertEquals(Rank.ACE, rank);
    }
    @Test
    public void testPlay_PlayerWins() {
        // Arrange
        GoFish goFish = new GoFish();
        // Simulate a game where the player wins
        ByteArrayInputStream in = new ByteArrayInputStream("ACE\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        goFish.play();
        String output = outContent.toString().trim();

        // Assert
        assertTrue(output.contains("Congratulations! You win!"));
    }

    @Test
    public void testPlay_ComputerWins() {
        // Arrange
        GoFish goFish = new GoFish();
        // Simulate a game where the computer wins
        ByteArrayInputStream in = new ByteArrayInputStream("ACE\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        // Set player score to 0 and computer score to 13
        goFish.playerScore = 0;
        goFish.computerScore = 13;
        goFish.play();
        String output = outContent.toString().trim();

        // Assert
        assertTrue(output.contains("Sorry, the computer wins!"));
    }


    @Test
    public void testPlayerTurn_NoBonusTurn() {
        // Arrange
        GoFish goFish = new GoFish();
        goFish.playerHand.add(new Card(Rank.ACE, Suit.CLUBS));
        goFish.computerHand.add(new Card(Rank.TWO, Suit.HEARTS));

        // Act
        boolean bonusTurn = goFish.playerTurn();

        // Assert
        assertFalse(bonusTurn);
    }

    @Test
    public void testComputerTurn_BonusTurn() {
        // Arrange
        GoFish goFish = new GoFish();
        goFish.computerHand.add(new Card(Rank.ACE, Suit.HEARTS));
        goFish.playerHand.add(new Card(Rank.ACE, Suit.CLUBS));

        // Act
        boolean bonusTurn = goFish.computerTurn();

        // Assert
        assertTrue(bonusTurn);
    }

    @Test
    public void testComputerTurn_NoBonusTurn() {
        // Arrange
        GoFish goFish = new GoFish();
        goFish.computerHand.add(new Card(Rank.ACE, Suit.HEARTS));
        goFish.playerHand.add(new Card(Rank.TWO, Suit.CLUBS));

        // Act
        boolean bonusTurn = goFish.computerTurn();

        // Assert
        assertFalse(bonusTurn);
    }
    
}
