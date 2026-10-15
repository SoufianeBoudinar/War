public class Player {
    private int player_id;
    private Hand hand;
    private Table table;
    private DiscardPile discardPile;

    public Player(Table table, Hand hand, DiscardPile discardPile,int player) {
        this.table = table;
        this.hand = hand;
        this.discardPile = discardPile;
        this.player_id = player;
    }

    public void tableToDiscard(){
        int tablesize = table.tableSize() - 1;
        for (int i = tablesize; i >= 0; i--) {
            discardPile.toDiscard(table.fromTable(i));
        }
    }

    public void discardToHand(){
        int discardsize = discardPile.discardSize() - 1;
        for (int i = discardsize; i >= 0; i--) {
            hand.toHand(discardPile.fromDiscard());
        }
    }

    public void seeHand(){
        hand.showHand();
    }

    public void playCard() {


        if(hand.isEmpty() && discardPile.isEmpty()) {
            return;
        } else if(hand.isEmpty()) {
            discardToHand();
        }

        table.toTable(hand.fromHand());

        System.out.println("Player " + player_id +  " hand size:" + hand.handSize() + ", discard size: " + discardPile.discardSize());
    }
}
