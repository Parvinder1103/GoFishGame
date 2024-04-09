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
public class GoFishHandTest {
    
    @Test
    public void testAdd() {
        GoFishHand hand = new GoFishHand();
        Card card = new Card(Rank.ACE, Suit.SPADES);
        hand.add(card);
        assertFalse(hand.isEmpty());
        assertEquals(1, hand.size());
    }
    
    @Test
    public void testIsEmpty() {
        GoFishHand hand = new GoFishHand();
        assertTrue(hand.isEmpty());
        hand.add(new Card(Rank.TWO, Suit.HEARTS));
        assertFalse(hand.isEmpty());
    }
    
    @Test
    public void testContainsRank() {
        GoFishHand hand = new GoFishHand();
        hand.add(new Card(Rank.THREE, Suit.CLUBS));
        hand.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        assertTrue(hand.containsRank(Rank.THREE));
        assertFalse(hand.containsRank(Rank.ACE));
    }
    
    @Test
    public void testGive() {
        GoFishHand giverHand = new GoFishHand();
        giverHand.add(new Card(Rank.FOUR, Suit.HEARTS));
        giverHand.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        giverHand.add(new Card(Rank.FOUR, Suit.SPADES));
        
        GoFishHand receiverHand = new GoFishHand();
        
        boolean given = giverHand.give(Rank.FOUR, receiverHand);
        
        assertTrue(given);
        assertEquals(0, giverHand.size());
        assertEquals(3, receiverHand.size());
    }
    
    @Test
    public void testRemoveSets() {
        GoFishHand hand = new GoFishHand();
        hand.add(new Card(Rank.FIVE, Suit.CLUBS));
        hand.add(new Card(Rank.FIVE, Suit.HEARTS));
        hand.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        hand.add(new Card(Rank.FIVE, Suit.SPADES));
        
        int setsRemoved = hand.removeSets();
        
        assertEquals(1, setsRemoved);
        assertTrue(hand.isEmpty());
    }
    
}
