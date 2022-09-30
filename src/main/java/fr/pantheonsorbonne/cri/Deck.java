package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.enums.CardColor;
import fr.pantheonsorbonne.cri.enums.CardValue;

import java.util.Random;

/**
 * Represents a Deck of cards
 */
public class Deck {

    private final static Random random = new Random();
    private static int deckSize = CardValue.values().length * CardColor.values().length;
    private final static Card[] deck = new Card[deckSize];

    static {
        int cardCount = deckSize;
        //generate all cards
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                deck[cardCount-- - 1] = new Card(color, value);
            }
        }
        //shuffle them
        for (int i = 0; i < deckSize; i++) {
            int randomIndexToSwap = random.nextInt(deckSize);
            Card temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;

        }
    }

    /**
     * disallow instantiation
     */
    private Deck() {
    }

    /**
     * @return a run random set of card of size Player.HAND_SIZE
     */
    public static Card[] newRandomHand() {
        return getRandomCards(Player.HAND_SIZE);

    }

    /**
     * return an array of random cards
     *
     * @param length the size of the array
     * @return
     */
    public static Card[] getRandomCards(int length) {
        Card[] result = new Card[length];
        for (int i = 0; i < length; i++) {
            result[i] = newRandomCard();
        }
        return result;
    }

    private static Card newRandomCard() {
        return deck[deckSize-- - 1];
    }
}
