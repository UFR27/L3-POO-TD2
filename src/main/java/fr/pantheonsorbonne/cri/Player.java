package fr.pantheonsorbonne.cri;


import fr.pantheonsorbonne.cri.enums.CardValue;
import fr.pantheonsorbonne.cri.enums.Combination;
import fr.pantheonsorbonne.cri.utils.RankedCombination;

import java.util.Arrays;

/**
 * a Player of Poker
 */
public class Player {

    /**
     * the number of card each player have in her hand
     */
    public static final int HAND_SIZE = 5;
    private final String name;
    private final Card[] hand = new Card[HAND_SIZE];

    /**
     * builds a player, passing possibly the cards in her hand
     *
     * @param name  the name of the players
     * @param cards optional variable number of cards
     */
    public Player(String name, String... cards) {
        this.name = name;
        int index = 0;
        for (String card : cards) {
            this.hand[index++] = Card.valueOf(card);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("\t");
        for (Card card : hand) {
            if (sb.length() != 0)
                sb.append(" ");
            sb.append(card.toString());
        }
        return sb.toString();
    }

    protected Card[] getHand() {
        //if we were more advanced, it would be a line
        //return Arrays.stream(hand).filter(c -> c != null).collect(Collectors.toList()).toArray(new Card[0]);

        int count = 0;
        for (Card card : hand) {
            if (card != null) {
                count++;
            }
        }
        final Card[] res = new Card[count];
        for (Card card : hand) {
            if (card != null) {
                res[count-- - 1] = card;
            }
        }

        return res;
    }

    /**
     * replace the current hand of the players by this set of cards.
     *
     * @param newRandomHand
     */
    public void setHand(Card[] newRandomHand) {
        for (int i = 0; i < newRandomHand.length; i++) {
            hand[i] = newRandomHand[i];
        }

    }

    /**
     * remove some cards from the player's hand and return them.
     * The card correspond to the optimal strategy
     *
     * @return
     */
    public Card[] getCardsToDiscard() {
        Card[] result = new Card[hand.length];

        CardValue cardToKeep;
        switch (this.getCombination().combination()) {
            case NOTHING:
                cardToKeep = getHighestCardValue();
                break;
            case PAIR:
            case THREE_OF_A_KIND:
            case FOUR_OF_A_KIND:
                cardToKeep = this.getCombination().value();
                break;
            default:
                return result;

        }
        return removeCardsNotEqualsTo(cardToKeep);
    }

    private RankedCombination getCombination() {
        int combinationMax = 1;
        CardValue cardValueMax = CardValue.values()[CardValue.values().length - 1];
        for (int i = 0; i < hand.length; i++) {
            int countCard = 1;
            for (int j = i + 1; j < hand.length; j++) {
                if (hand[i].getValue().equals(hand[j].getValue())) {
                    countCard++;
                }
            }
            if (countCard > combinationMax) {
                combinationMax = countCard;
                cardValueMax = hand[i].getValue();
            }
        }
        Combination resultCombination;
        switch (combinationMax) {
            case 1:
                resultCombination = Combination.NOTHING;
                break;
            case 2:
                resultCombination = Combination.PAIR;
                break;
            case 3:
                resultCombination = Combination.THREE_OF_A_KIND;
                break;
            case 4:
                resultCombination = Combination.FOUR_OF_A_KIND;
                break;
            default:
                resultCombination = null;

        }
        return new RankedCombination(resultCombination, cardValueMax);
    }

    private CardValue getHighestCardValue() {
        CardValue highest = CardValue.values()[CardValue.values().length - 1];
        for (Card card : this.hand) {
            if (card.getValue().ordinal() < card.getValue().ordinal()) {
                highest = card.getValue();
            }
        }
        return highest;

    }

    private Card[] removeCardsNotEqualsTo(CardValue cardValue) {
        int resultCardCount = 0;
        Card[] handToDiscard = new Card[hand.length];
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getValue() != cardValue) {
                handToDiscard[resultCardCount++] = hand[i];
                hand[i] = null;
            }
        }

        return Arrays.copyOf(handToDiscard, resultCardCount);
    }

    /**
     * add a card in the players' hand
     *
     * @param randomCards
     */
    public void addCards(Card[] randomCards) {
        int j = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == null) {
                hand[i] = randomCards[j++];
            }
        }
    }

    /**
     * @param otherPlayer
     * @return true of the our hand is better that the other player's hand
     */
    public boolean beats(Player otherPlayer) {
        if (this.getCombination().combination().getRank() > otherPlayer.getCombination().combination().getRank()) {
            return true;
        } else if (this.getCombination().combination().getRank() == otherPlayer.getCombination().combination().getRank()) {
            return this.getCombination().value().getRank() > otherPlayer.getCombination().value().getRank();
        }
        return false;
    }


}
