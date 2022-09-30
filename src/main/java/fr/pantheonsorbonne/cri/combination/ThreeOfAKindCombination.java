package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Card;
import fr.pantheonsorbonne.cri.enums.CardValue;

public class ThreeOfAKindCombination extends SimpleCombination {

    private CardValue highestCard;

    /**
     * Build a combination from a batch of card
     *
     * @param hand
     */
    public ThreeOfAKindCombination(Card[] hand) {
        super(hand);
    }

    public boolean isMatch() {

        for (int i = 0; i < this.hand.length; i++) {
            int counter = 1;
            for (int j = i + 1; j < this.hand.length; j++) {
                if (this.hand[i].getValue().equals(this.hand[j].getValue())) {
                    counter++;
                }
            }
            if (counter >= 3) {
                if (highestCard == null || highestCard.getRank() < this.hand[i].getValue().getRank()) {
                    highestCard = this.hand[i].getValue();
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

