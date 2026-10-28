package cards;

public class Joker extends Card {

    public Joker(int cindex) {
        this.id = count + 1;
        this.color = colors[cindex];
        this.rank = 14;
        this.type = "J";

        //Assign suit based on color
        if (color.contentEquals("Red")) {
            this.suit = suits[5];
        } else if (color.contentEquals("Black")) {
            this.suit = suits[4];
        }
        count++;
    }
}
