package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Card;

public class AllDifferentCombination extends Combination {
    /**
     * Build a combination from a batch of card
     *
     * @param hand
     */
    public AllDifferentCombination(Card[] hand) {
        super(hand);
    }

    @Override
    public boolean isMatch() {
        for (int i = 0; i < hand.length; i++) {
            for (int j = i + 1; j < hand.length; j++) {
                if (this.hand[i].equals(this.hand[j])) {
                    return false;
                }
            }
        }
        return true;


    }

}
