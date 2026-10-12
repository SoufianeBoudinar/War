public class Joker extends Card {

    public Joker(int cindex) {
        super(suits, colors, ranks);
        this.id = count + 1;
        this.color = colors[cindex];

        if (color.contentEquals("Red")) {
            this.suit = suits[5];
        } else if (color.contentEquals("Black")) {
            this.suit = suits[4];
        }

        this.rank = 14;
        this.type = "J";
        count++;
    }
}
