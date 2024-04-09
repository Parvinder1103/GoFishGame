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
public class RankTest {
    
    @Test
    public void testValues() {
        // Arrange
        Rank[] expectedValues = {
            Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX,
            Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING
        };

        // Act
        Rank[] actualValues = Rank.values();

        // Assert
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    public void testToString() {
        // Arrange
        String expectedToString = "ACE";

        // Act
        String actualToString = Rank.ACE.toString();

        // Assert
        assertEquals(expectedToString, actualToString);
    }
    
}
