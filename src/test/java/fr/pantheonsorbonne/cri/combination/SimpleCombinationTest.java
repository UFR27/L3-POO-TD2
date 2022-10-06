package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Deck;
import fr.pantheonsorbonne.cri.Player;
import fr.pantheonsorbonne.cri.enums.CardValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleCombinationTest {

    @Test
    void isMatch() {
        Combination simpleCombination = new Combination(Deck.newRandomHand());
        assertTrue(simpleCombination.isMatch());
    }

    @Test
    void getCombinationRanking() {
        Player p = new Player("toto", "2C", "3H", "1S");
        Combination simpleCombination = new Combination(p.getHand());
        assertEquals(CardValue.ACE, simpleCombination.getCombinationRanking());

    }

    @Test
    void getCombinationRankingPair() {
        Player p = new Player("toto", "KC", "1C", "1S");
        Combination simpleCombination = new Combination(p.getHand());
        assertEquals(CardValue.ACE, simpleCombination.getCombinationRanking());

    }
}