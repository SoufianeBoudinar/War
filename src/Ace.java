public class Ace extends Card {

    public Ace(int sindex) {
        super(suits, colors, ranks);
        this.suit = suits[sindex];
        this.rank = 13;
        this.type = "A";

        if (suit.contentEquals("Hearts") || suit.contentEquals("Diamonds")) {
            this.color = colors[0];
        } else {
            this.color = colors[1];
        }

        count++;
    }
}
