package fr.pantheonsorbonne.cri.utils;


import fr.pantheonsorbonne.cri.enums.CardValue;
import fr.pantheonsorbonne.cri.enums.Combination;

import java.util.Objects;

/*
public record RankedCombination(Combination combination, CardValue value) {
}*/


public class RankedCombination {
    private final Combination combination;
    private final CardValue value;

    public RankedCombination(Combination combination, CardValue value) {
        this.combination = combination;
        this.value = value;
    }

    public Combination combination() {
        return combination;
    }

    public CardValue value() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(combination, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankedCombination)) return false;
        RankedCombination that = (RankedCombination) o;
        return combination == that.combination && value == that.value;
    }
}
