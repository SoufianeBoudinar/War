public class Card {
    protected static final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs","Standard Joker", "Colored Joker"};
    protected static final String[] colors = {"Red", "Black"};
    protected static final int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,14};
    protected String suit = "";
    protected String color;
    protected int rank;
    protected String type;
    protected static int count = 0;
    protected int id;

    public Card(String[] suit, String[] color, int[] rank) {}

    public Card() {}

    public int getRank () {
        return rank;
    }

    public void displayCard() {
        String symbol = "";
        String red;
        String black;
        String end = "  \u001B[0m\n";
        String heart = "\u2665";
        String diamond = "\u2666";
        String spade = "\u2660";
        String club = "\u2663";

        if (type.contentEquals("10")){
            red = "\u001B[48;5;15;38;5;160m ";
            black = "\u001B[48;5;15;38;5;16m ";
        }
        else {
            red = "\u001B[48;5;15;38;5;160m  ";
            black = "\u001B[48;5;15;38;5;16m  ";
        }

        switch (suit){
            case "Hearts" ->  symbol = red + type + heart + end;
            case "Diamonds" -> symbol = red + type + diamond + end;
            case "Spades" -> symbol = black + type + spade + end;
            case "Clubs" -> symbol = black + type + club + end;
            case "Standard Joker" -> symbol = black + type + " " + end;
            case "Colored Joker" -> symbol = red + type + " " + end;
        }
        System.out.println(symbol);
    };
    // Use this to see color intensity in your terminal
    // for i in {0..255}; do printf "\x1b[48;5;${i}m %3d \x1b[0m" "$i"; if [ $((($i + 1) % 16)) -eq 0 ]; then echo; fi; done
}
