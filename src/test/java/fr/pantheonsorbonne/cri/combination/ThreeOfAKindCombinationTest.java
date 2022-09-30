package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Player;
import fr.pantheonsorbonne.cri.enums.CardValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeOfAKindCombinationTest {

    @Test
    void isMatch() {
        {
            SimpleCombination pairCombination = new PairCombination(new Player("toto", "4C", "4H", "4S", "5C", "6C").getHand());
            assertTrue(pairCombination.isMatch());
        }

        {
            SimpleCombination pairCombination = new PairCombination(new Player("toto", "4C", "3H", "3S", "3C", "6C").getHand());
            assertTrue(pairCombination.isMatch());
        }
        {
            SimpleCombination pairCombination = new ThreeOfAKindCombination(new Player("toto", "4C", "1H", "4S", "5C", "6C").getHand());
            assertFalse(pairCombination.isMatch());
        }
    }

    @Test
    void getCombinationRanking() {
        {
            SimpleCombination pairCombination = new ThreeOfAKindCombination(new Player("toto", "4C", "1H", "3S", "4S", "3D").getHand());
            assertEquals(null, pairCombination.getCombinationRanking());
        }

        {
            SimpleCombination pairCombination = new ThreeOfAKindCombination(new Player("toto", "4C", "3H", "3S", "5C", "3C").getHand());
            assertEquals(CardValue.THREE, pairCombination.getCombinationRanking());
        }
    }
}