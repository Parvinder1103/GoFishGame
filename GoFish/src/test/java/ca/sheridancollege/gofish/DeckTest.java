/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.gofish;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PARVINDER KAUR
 */
public class DeckTest {
    
    @Test
    public void testConstructor() {
        // Arrange
        Deck deck = new Deck();
        
        // Act
        int deckSize = deck.size();
        
        // Assert
        assertEquals(52, deckSize);
    }
    
    @Test
    public void testShuffle() {
        // Arrange
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        
        // Act
        deck2.shuffle();
        
        // Assert
        assertNotEquals(deck1, deck2);
    }
    
    @Test
    public void testDeal() {
        // Arrange
        Deck deck = new Deck();
        int initialSize = deck.size();
        
        // Act
        Card card = deck.deal();
        int newSize = deck.size();
        
        // Assert
        assertNotNull(card);
        assertEquals(initialSize - 1, newSize);
    }

    
    @Test
    public void testIsEmpty() {
        // Arrange
        Deck deck = new Deck();
        
        // Act & Assert
        assertFalse(deck.isEmpty());
        
        // Empty the deck
        int size = deck.size();
        for (int i = 0; i < size; i++) {
            deck.deal();
        }
        
        assertTrue(deck.isEmpty());
    }
    
    @Test
    public void testSize() {
        // Arrange
        Deck deck = new Deck();
        
        // Act
        int size = deck.size();
        
        // Assert
        assertEquals(52, size);
    }
    
}
