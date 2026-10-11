public class Joker extends Card {

    public Joker(int cindex) {
        super(suits, colors, ranks);
        this.color = colors[cindex];
        this.rank = 14;
        this.type = "J";
        count++;
    }
}
