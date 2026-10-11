public class Card {
    protected static final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    protected static final String[] colors = {"Red", "Black"};
    protected static final int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    protected String suit;
    protected String color;
    protected int rank;

    public Card(String[] suit, String[] color, int[] rank) {}

    public void displayCard(){}
}
