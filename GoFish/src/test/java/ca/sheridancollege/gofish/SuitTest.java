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
public class SuitTest {
    
    @Test
    public void testValues() {
        // Arrange
        Suit[] expectedValues = {
            Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES
        };

        // Act
        Suit[] actualValues = Suit.values();

        // Assert
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    public void testToString() {
        // Arrange
        String expectedToString = "CLUBS";

        // Act
        String actualToString = Suit.CLUBS.toString();

        // Assert
        assertEquals(expectedToString, actualToString);
    }
    
}
