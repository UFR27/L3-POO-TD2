package fr.pantheonsorbonne.cri;

import fr.pantheonsorbonne.cri.enums.CardColor;
import fr.pantheonsorbonne.cri.enums.CardValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void valueOf() {
        {
            final String strRepresentation = "1H";
            assertEquals(CardValue.ACE, Card.valueOf(strRepresentation).getValue());
            assertEquals(CardColor.HEART, Card.valueOf(strRepresentation).getColor());
        }

        {
            final String strRepresentation = "10S";
            assertEquals(CardValue.TEN, Card.valueOf(strRepresentation).getValue());
            assertEquals(CardColor.SPADE, Card.valueOf(strRepresentation).getColor());
        }

        {
            final String strRepresentation = "QD";
            assertEquals(CardValue.QUEEN, Card.valueOf(strRepresentation).getValue());
            assertEquals(CardColor.DIAMOND, Card.valueOf(strRepresentation).getColor());
        }


    }
}