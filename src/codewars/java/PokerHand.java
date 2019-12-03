package codewars.java;

public class PokerHand {
    public enum Result { TIE, WIN, LOSS }
    public Card[] cards;
    PokerHand(String hand) {
        cards = new Card[5];
        int index = 0;
        for(String card: hand.split(" ")) {
            cards[index++] = new Card(card);
        }
    }

    public Result compareWith(PokerHand hand) {
        return Result.TIE;
    }
    class Card {
        String value, suit;
        public Card(String card) {
            String[] cards = card.split("");
            value = cards[0]; suit = cards[1];
        }
    }
}
