import java.util.ArrayList;

public class Tester {

    /**
     * Test Deck constructor
     */
    public static void createDeckTest(){
        Deck deck = new Deck();
        deck.show();
    }

    /**
     * Test test is deck becomes adequately shuffled
     */
    public static void shuffleTest(){
        Deck deck = new Deck();
        deck.shuffle();
        for (Card card: deck.getDeck()){
            System.out.println(card.getId());
        }
    }

    /**
     * Tests that cards can be taken from the deck
     * and that they are removed from the original deck.
     */
    public static void drawTest(){
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> drawnCards = deck.draw(5);
        System.out.println("Drawn Cards: " + drawnCards.size());
        System.out.println("Cards in Deck: " + deck.getDeck().size());
        System.out.println("Cards Drawn: ");
        for(Card card:drawnCards){
            System.out.println(card.getId());
        }
        System.out.println("Cards left in deck: ");
        for(Card card: deck.getDeck()){
            System.out.println(card.getId());
        }

    }

    /**
     * Same as draw test but sorts the returned deck
     */
    public static void drawSortTest(){
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> drawnCards = deck.draw(5);
        System.out.println("Drawn Cards: " + drawnCards.size());
        System.out.println("Cards in Deck: " + deck.getDeck().size());
        System.out.println("Cards Drawn: ");
        ArrayList<Card> sortedCards = Deck.sort(drawnCards);
        for(Card card:sortedCards){
            System.out.println(card.getId());
        }
    }
}
