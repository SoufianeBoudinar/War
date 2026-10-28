package cards;

public class Number extends Card {

    private final int[][] values = {{2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};
    private int value;


    public Number(int sindex, int vindex) {
        super(sindex);
        this.id = count + 1;
        this.value = values[0][vindex];
        this.type = String.valueOf(value);

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
