public class Hand extends Deck {
    private int[] players = {1, 2};
    private int player;
    private boolean isempty;
    private int handsize;

    public Hand(int player){
        this.player = players[player];
    }
}
