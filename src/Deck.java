import java.util.Stack;

public class Deck {
    private Stack<Card> deck;
    protected int decksize;

    public Deck() {
        deck = new Stack<>();
        makeDeck();
        decksize = deck.size();
    }


    // Fill up deck with cards loops and addCard method
    private void makeDeck() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++){
                Number number = new Number(j, i);
                addCard(number);
            }
        }

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++){
                Court court = new Court(j, i);
                addCard(court);
            }
        }

        for (int i = 0; i < 4; i++){
            Ace ace = new Ace(i);
            addCard(ace);
        }

        for (int i = 0; i < 2; i++){
            Joker joker = new Joker(i);
            addCard(joker);
        }
    }

    // Add card to deck
    public void addCard(Card card) {
        deck.push(card);
    }

    // Display every element in deck
    public void displayDeck(){
        for (int i = decksize - 1; i >= 0; i--) {
            deck.elementAt(i).displayCard();
        }
    }

    // Shuffle using Fisher–Yates (Knuth) shuffle
    public void shuffleDeck() {
        Card buffer = new Card();  // Hold temp cards
        int random = 0;
        for (int i = decksize - 1; i >= 0; i--) {
            random = (int) (Math.random() * i); // Generate number between 0-53
            buffer = deck.get(random);
            deck.set(random, deck.get(i));
            deck.set(i, buffer);
        }
    }


    public void dealCards(Hand hand1, Hand hand2) {
        int lastindex = decksize - 1;
        int middleindex = (lastindex) / 2;

        for (int i = lastindex; i > middleindex; i--) {
            hand1.toHand(deck.get(i));
        }

        for (int i = middleindex; i >= 0; i--){
            hand2.toHand(deck.get(i));
        }
    }
}
