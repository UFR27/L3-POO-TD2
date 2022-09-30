package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.enums.CardColor;
import fr.pantheonsorbonne.cri.enums.CardValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    @Test
    void setHand() {
        Player p = new Player("toto");
        final Card card = new Card(CardColor.CLUB, CardValue.ACE);
        p.setHand(new Card[]{card});
        assertEquals(1, p.getHand().length);
        assertEquals(card, p.getHand()[0]);

    }

    @Test
    void getCardsToDiscard() {
        Player p = new Player("toto");
        final Card card1 = new Card(CardColor.CLUB, CardValue.ACE);
        final Card card2 = new Card(CardColor.DIAMOND, CardValue.ACE);
        final Card card3 = new Card(CardColor.SPADE, CardValue.ACE);
        final Card dummy1 = new Card(CardColor.SPADE, CardValue.SEVEN);
        final Card dummy2 = new Card(CardColor.SPADE, CardValue.EIGHT);
        p.setHand(new Card[]{card1, card2, card3, dummy1, dummy2});
        Card[] cardsToDiscard = p.getCardsToDiscard();
        assertEquals(2, cardsToDiscard.length);
        for (int i = 0; i < 2; i++) {
            assertTrue(cardsToDiscard[i] == dummy1 || cardsToDiscard[i] == dummy2);
        }
    }

    @Test
    void addCards() {
        Player p = new Player("toto");
        final Card card1 = new Card(CardColor.CLUB, CardValue.ACE);
        final Card card2 = new Card(CardColor.DIAMOND, CardValue.ACE);
        final Card card3 = new Card(CardColor.SPADE, CardValue.ACE);
        final Card dummy1 = new Card(CardColor.SPADE, CardValue.SEVEN);
        final Card dummy2 = new Card(CardColor.SPADE, CardValue.EIGHT);
        p.setHand(new Card[]{card1, card2, card3});
        p.addCards(new Card[]{dummy1, dummy2});
        for (Card card : p.getHand()) {
            assertTrue(card == card1 ||
                    card == card2 ||
                    card == card3 ||
                    card == dummy1 ||
                    card == dummy2
            );
        }
        assertEquals(5, p.getHand().length);
    }

    @Test
    void beatsSameCombinationHigherCard() {
        {
            Player p1 = new Player("toto", "KD", "KS", "KH", "7S", "8S");
            Player p2 = new Player("toto", "JD", "JS", "JH", "7S", "8S");
            assertTrue(p1.beats(p2));
        }
    }

    @Test
    void beatsLowerCombination() {
        {
            Player p1 = new Player("toto", "KD", "KS", "KH", "7S", "8S");
            Player p2 = new Player("toto", "JD", "JS", "QH", "7S", "8S");
            assertTrue(p1.beats(p2));
        }
    }

    @Test
    void beatsDraw() {
        {
            Player p1 = new Player("toto", "KD", "KS", "9H", "7S", "8S");
            Player p2 = new Player("toto", "KH", "KC", "QH", "7S", "8S");
            assertFalse(p1.beats(p2));
            assertFalse(p2.beats(p1));
        }
    }


}