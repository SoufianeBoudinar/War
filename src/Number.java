public class Number extends Card {
    private final int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int value;

    public Number(int sindex, int cindex, int rindex, int vindex) {
        super(suits,colors,ranks);
        this.suit = suits[sindex];
        this.color = colors[cindex];
        this.rank = ranks[rindex];
        this.value = values[vindex];
    }


    public void displayNumber(){
        System.out.println(suit + "\n" + color + "\n" + rank + "\n" + value);
    }
}
