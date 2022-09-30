package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.enums.CardColor;
import fr.pantheonsorbonne.cri.enums.CardValue;

public class Card {

    private final CardColor color;
    private final CardValue value;


    public Card(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    /**
     * For a String representation of a card, return the card
     *
     * @param str
     * @return the card
     * @throws RuntimeException if the String representation is Invaliid
     */
    public static Card valueOf(String str) {
        CardValue value;
        CardColor color;
        if (str.length() == 3) {//it's a 10
            value = CardValue.valueOfStr(str.substring(0, 2));
            color = CardColor.valueOfStr(str.substring(2, 3));
        } else {
            value = CardValue.valueOfStr(str.substring(0, 1));
            color = CardColor.valueOfStr(str.substring(1, 2));
        }
        return new Card(color, value);

    }

    /**
     * Get the color of the card
     *
     * @return
     */
    public CardColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        int rank = this.getValue().ordinal();
        if (rank > 10) {
            rank++;
        }
        return new String(Character.toChars(this.color.getCode() + rank));
    }

    /**
     * get the value of the card
     *
     * @return
     */
    public CardValue getValue() {
        return value;
    }
}
