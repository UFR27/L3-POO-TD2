package fr.pantheonsorbonne.cri.combination;

import fr.pantheonsorbonne.cri.Card;
import fr.pantheonsorbonne.cri.enums.CardValue;

/**
 * a simple batch of Cards
 */
public class Combination {
    protected final Card[] hand;

    /**
     * Build a combination from a batch of card
     *
     * @param hand
     */
    public Combination(final Card[] hand) {
        this.hand = hand;
    }

    /**
     * tell of the batch of card actually match the combination
     *
     * @return
     */
    public boolean isMatch() {
        return true;
    }

    /**
     * Get the highest ranking for a card from the combination
     * Here, we just return the highest card of the batch
     *
     * @return
     */
    public CardValue getCombinationRanking() {

        CardValue cardValueMax = CardValue.TWO;
        for (Card card : this.hand) {
            if (card.getValue().getRank() > cardValueMax.getRank()) {
                cardValueMax = card.getValue();
            }
        }
        return cardValueMax;
    }
}
