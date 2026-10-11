import java.util.Stack;

public class Deck {
    private Stack<Card> deck;
    private boolean isempty = false;
    private int count;

    public Deck() {
        deck = new Stack<>();
        makeDeck();
    }

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

    public void addCard(Card card) {
        deck.add(card);
    }

    public void displayDeck() {
        for (int i = 0; i < deck.size(); i++) {
            deck.elementAt(i).displayCard();
        }
    }

    public void shuffleCards() {
    }

    public void dealCards() {

    }
}
