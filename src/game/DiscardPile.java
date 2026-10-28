package game;

import cards.Card;

import java.util.Stack;

public class DiscardPile {
    private Stack<Card> discard_pile;

    public DiscardPile() {
        this.discard_pile = new Stack<>();
    }

    public void toDiscard(Card card) {
        discard_pile.push(card);
    }

    public Card fromDiscard() {
        return discard_pile.pop();
    }
    public boolean isEmpty() {
        return discard_pile.empty();
    }

    public void showDiscardPile() {
        int table_size = discard_pile.size() - 1;
        for (int i = table_size; i >= 0; i--) {
            discard_pile.elementAt(i).displayCard();
        }
    }

    public int discardSize() {
        return discard_pile.size();
    }
}
