package game;

import cards.Ace;
import cards.Card;
import cards.Court;
import cards.Joker;
import cards.Number;

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
                addCard(new Number(j, i));
            }
        }

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++){
                addCard(new Court(j, i));
            }
        }

        for (int i = 0; i < 4; i++){
            addCard(new Ace(i));
        }

        for (int i = 0; i < 2; i++){
            addCard(new Joker(i));
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
            buffer = deck.get(random); // Put random card in buffer
            deck.set(random, deck.get(i)); // Replace random card with selected card
            deck.set(i, buffer); // Put random card in place of previous selected card location
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
