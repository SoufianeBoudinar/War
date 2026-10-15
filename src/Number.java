public class Number extends Card {
    private final int[][] values = {{2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};
    private int value;


    public Number(int sindex, int vindex) {
        super(suits, colors, ranks);
        this.id = count + 1;
        this.suit = suits[sindex];
        this.value = values[0][vindex];
        this.type = String.valueOf(value);

        //Assign color based on suit
        if (suit.contentEquals("Hearts") || suit.contentEquals("Diamonds")) {
            this.color = colors[0];
        } else {
            this.color = colors[1];
        }

        //Assign rank based on value
        for (int i = 0; i < values[0].length; i++) {
            if (value == values[0][i]) {
                this.rank = values[1][i];
                break;
            }
        }
        count++;
    }
}
