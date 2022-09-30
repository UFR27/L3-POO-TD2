package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Card;
import fr.pantheonsorbonne.cri.enums.CardValue;

public class PairCombination extends SimpleCombination {

    private CardValue highestCard;

    /**
     * Build a combination from a batch of card
     *
     * @param hand
     */
    public PairCombination(Card[] hand) {
        super(hand);
    }

    /**
     * check if there are at least 2 of the same cards
     *
     * @return
     */
    @Override
    public boolean isMatch() {
        for (int i = 0; i < this.hand.length; i++) {
            for (int j = i + 1; j < this.hand.length; j++) {
                if (this.hand[i].getValue().equals(this.hand[j].getValue())) {
                    if (highestCard == null || highestCard.getRank() < this.hand[i].getValue().getRank()) {
                        highestCard = this.hand[i].getValue();
                    }

                }
            }
        }
        return highestCard != null;
    }

    public CardValue getCombinationRanking() {
        if (this.isMatch()) {
            return highestCard;
        } else {
            return null;
        }
    }
}
