package cards;

public class Ace extends Card {

    public Ace(int sindex) {
        super(sindex);
        this.id = count + 1;
        this.suit = suits[sindex];
        this.rank = 13;
        this.type = "A";

        count++;
    }
}
