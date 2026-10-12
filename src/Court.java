public class Court extends Card {
    private final String[][] faces = {{"K", "Q", "J"}, {"12", "11", "10"}};
    private String face;

    public Court(int sindex,  int findex) {
        super(suits, colors, ranks);
        this.id = count + 1;
        this.suit = suits[sindex];
        this.face = faces[0][findex];
        this.type = faces[0][findex];

        if (suit.contentEquals("Hearts") || suit.contentEquals("Diamonds")) {
            this.color = colors[0];
        } else {
            this.color = colors[1];
        }

        for (int i = 0; i < faces[0].length; i++){
            if (face.contentEquals(faces[0][i])) this.rank = Integer.parseInt(faces[1][i]);
        }

        count++;
    }
}