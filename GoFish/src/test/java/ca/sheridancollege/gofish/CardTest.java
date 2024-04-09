/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.gofish;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PARVINDER KAUR
 */
public class CardTest {
    
    @Test
    public void testGetRank() {
        // Arrange
        Rank expectedRank = Rank.ACE;
        Card card = new Card(expectedRank, Suit.HEARTS);
        
        // Act
        Rank actualRank = card.getRank();
        
        // Assert
        assertEquals(expectedRank, actualRank);
    }
    
    @Test
    public void testGetSuit() {
        // Arrange
        Suit expectedSuit = Suit.DIAMONDS;
        Card card = new Card(Rank.TWO, expectedSuit);
        
        // Act
        Suit actualSuit = card.getSuit();
        
        // Assert
        assertEquals(expectedSuit, actualSuit);
    }
    
    @Test
    public void testToString() {
        // Arrange
        Card card = new Card(Rank.KING, Suit.CLUBS);
        String expectedString = "KING of CLUBS";
        
        // Act
        String actualString = card.toString();
        
        // Assert
        assertEquals(expectedString, actualString);
    }
    
}
