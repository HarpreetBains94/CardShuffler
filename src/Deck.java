import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
        this.newDeck();
    }

    public void show(){
        for(Card card:this.deck){
            System.out.println(card.getId());
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Picks two cards and swaps them. This process is
     * repeated 500 times.
     *
     */
    public void shuffle(){
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i<=500;i++){
            int swap1 = random.nextInt((this.deck.size()-1));
            int swap2 = random.nextInt((this.deck.size()-1));
            Card card1 = this.deck.get(swap1);
            Card card2 = this.deck.get(swap2);
            this.deck.set(swap1, card2);
            this.deck.set(swap2,card1);

        }
    }

    /**
     * Removes the given number of cards from the deck
     * and returns them as an array.
     */
    public ArrayList<Card> draw(int i){
        this.shuffle();
        ArrayList<Card> drawnCards = new ArrayList<>();
        for (int j = 0; j<i && j<this.deck.size();j++){
            Card drawnCard = this.deck.get(j);
            drawnCards.add(drawnCard);
            this.deck.remove(drawnCard);

        }
        return drawnCards;
    }

    public static ArrayList<Card> sort(ArrayList<Card> cards){
        Collections.sort(cards, new CardComparator());
        return cards;
    }

    /**
     * Loops through Suits and Values to make an
     * Arraylist of 52 cards.
     */
    public void newDeck(){
        for(Card.Suit suit: Card.Suit.values()){
            for(Card.Value value: Card.Value.values()){
                this.deck.add(new Card(suit,value));
            }
        }
    }
}
