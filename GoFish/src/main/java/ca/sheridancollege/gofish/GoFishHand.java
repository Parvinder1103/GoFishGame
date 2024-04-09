/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.gofish;

/**
 *
 * @author PARVINDER KAUR
 */
import java.util.ArrayList;
import java.util.List;

public class GoFishHand {
    private final List<Card> cards;

    public GoFishHand() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public boolean containsRank(Rank rank) {
        for (Card card : cards) {
            if (card.getRank() == rank) {
                return true;
            }
        }
        return false;
    }

    public boolean give(Rank rank, GoFishHand receivingHand) {
        boolean given = false;
        List<Card> toRemove = new ArrayList<>();
        for (Card card : cards) {
            if (card.getRank() == rank) {
                given = true;
                receivingHand.add(card);
                toRemove.add(card);
            }
        }
        cards.removeAll(toRemove);
        return given;
    }

    public int removeSets() {
        int sets = 0;
        for (Rank rank : Rank.values()) {
            int count = 0;
            for (Card card : cards) {
                if (card.getRank() == rank) {
                    count++;
                }
            }
            while (count >= 4) {
                removeRank(rank);
                count -= 4;
                sets++;
            }
        }
        return sets;
    }

    private void removeRank(Rank rank) {
        cards.removeIf(card -> card.getRank() == rank);
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}

