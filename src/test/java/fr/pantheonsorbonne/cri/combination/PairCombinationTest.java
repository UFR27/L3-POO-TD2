package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Player;
import fr.pantheonsorbonne.cri.enums.CardValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairCombinationTest {

    @Test
    void isMatch() {
        {
            Combination pairCombination = new PairCombination(new Player("toto", "4C", "4H", "3S", "5C", "6C").getHand());
            assertTrue(pairCombination.isMatch());
        }

        {
            Combination pairCombination = new PairCombination(new Player("toto", "4C", "3H", "3S", "5C", "6C").getHand());
            assertTrue(pairCombination.isMatch());
        }
        {
            Combination pairCombination = new PairCombination(new Player("toto", "4C", "1H", "3S", "5C", "6C").getHand());
            assertFalse(pairCombination.isMatch());
        }
    }

    @Test
    void getCombinationRanking() {
        {
            Combination pairCombination = new PairCombination(new Player("toto", "4C", "1H", "3S", "5C", "6C").getHand());
            assertEquals(null, pairCombination.getCombinationRanking());
        }

        {
            Combination pairCombination = new PairCombination(new Player("toto", "4C", "3H", "3S", "5C", "6C").getHand());
            assertEquals(CardValue.THREE, pairCombination.getCombinationRanking());
        }
    }
}