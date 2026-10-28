package game;

import cards.Card;

import java.util.Stack;

public class Hand {
    private Stack<Card> hand;
    public Hand(){
        hand = new Stack<>();
    }

    public void toHand(Card card){
        hand.push(card);
    }

    public Card fromHand() {
        return hand.pop();
    }

    public boolean isEmpty() {
        return hand.empty();
    }

    public void showHand() {
        hand.peek().displayCard();
    }

    public void showHandAdmin(){
        int hand_size = hand.size() - 1;
        for (int i = hand_size; i >= 0; i--) {
            hand.elementAt(i).displayCard();
        }
    }

    public int handSize() {
        return hand.size();
    }
}
