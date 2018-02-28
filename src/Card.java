import java.util.Comparator;

public class Card implements Comparable<Card>{
    public enum Suit {Clubs, Spades, Hearts, Diamonds};
    public enum Value {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace};
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    public String getId(){
        return this.toString();
    }

    @Override
    public String toString(){
        return this.value + " of " + this.suit;
    }

    @Override
    public int compareTo(Card card){
        if(this.suit.compareTo(card.getSuit())==0){
            return this.value.compareTo(card.getValue());
        }
        return this.suit.compareTo(card.getSuit());
    }
}
