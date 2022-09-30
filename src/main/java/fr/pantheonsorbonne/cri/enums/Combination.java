package fr.pantheonsorbonne.cri.enums;

/**
 * List the possible combinations of a hand
 */
public enum Combination {
    NOTHING(0),
    PAIR(1),
    THREE_OF_A_KIND(5),
    FOUR_OF_A_KIND(10);

    private final int rank;

    Combination(int value) {
        this.rank = value;
    }

    /**
     * Retrieves an int value which can be used to compare the combination between them.
     * <p>
     * The higher the rank, the best the combination
     *
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
}
