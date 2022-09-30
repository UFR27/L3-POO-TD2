package fr.pantheonsorbonne.cri;

public class App {
    public static void main(String... args) {
        Player p1 = new Player("Nicolas");
        Player p2 = new Player("Elio");
        Player p3 = new Player("Flavio");

        //give the players some cards
        p1.setHand(Deck.newRandomHand());
        p2.setHand(Deck.newRandomHand());
        p3.setHand(Deck.newRandomHand());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        //returns the cards the players want to discard and get new ones
        Card[] cardsP1 = p1.getCardsToDiscard();
        p1.addCards(Deck.getRandomCards(cardsP1.length));
        Card[] cardsP2 = p2.getCardsToDiscard();
        p2.addCards(Deck.getRandomCards(cardsP2.length));
        Card[] cardsP3 = p3.getCardsToDiscard();
        p3.addCards(Deck.getRandomCards(cardsP3.length));

        System.out.println("After discard");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        //check who wins
        Player winner = null;
        if (p1.beats(p2) && p1.beats(p3)) {
            winner = p1;
        } else if (p2.beats(p1) && p2.beats(p3)) {
            winner = p2;
        } else if (p3.beats(p1) && p3.beats(p3)) {
            winner = p3;

        }
        if (winner != null) {
            System.out.println("Winner is: " + winner);
        } else {
            System.out.println("there is a draw");
        }
    }
}