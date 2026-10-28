import game.*;

public class Main {
    Deck deck = new Deck();
    Table table = new Table();
    Hand hand1 = new Hand();
    Hand hand2 = new Hand();
    DiscardPile discardPile1 = new DiscardPile();
    DiscardPile discardPile2 = new DiscardPile();
    Player player1 = new Player(table, hand1, discardPile1, 1);
    Player player2 = new Player(table, hand2, discardPile2, 2);

    public boolean iswar = false;
    public boolean matchend = false;
    public int winner;
    public int warwinner = 0;
    public int warcount = 0;
    int wartable4_result;


    // Decide war winner
    // Check hand and discardPile, if both are empty then declare war end
    public void warWinner() {
        if (hand1.isEmpty() && discardPile1.isEmpty()) {
            warwinner = 2;
            iswar = false;
            warcount++; // Make sure decideTable doesn't run in do while loop
            System.out.println("War winner: player " + warwinner);
        } else if (hand2.isEmpty() && discardPile2.isEmpty()) {
            warwinner = 1;
            iswar = false;
            warcount++;
            System.out.println("War winner: player " + warwinner);
        }
    }

    // Decide match winner
    // Check hand and discardPile, if both are empty then declare match end
    public void decideWinner() {
        if (hand1.isEmpty() && discardPile1.isEmpty()) {
            winner = 2;
            matchend = true;
        } else if (hand2.isEmpty() && discardPile2.isEmpty()) {
            winner = 1;
            matchend = true;
        }
    }

    // Manage war logic
    public void war(){

        // Only works if war is declared (iswar = true)
        if (iswar) {
            System.out.println("========War==========");

            // Play 3 cards in row for both players without deciding table
            for (int i = 0; i < 3; i++) {
                // Declare war end and war result if any player has empty hand & discardPile
                warWinner();
                // Break loop
                if (!iswar) {
                    return;
                }

                System.out.println("===========\nWar table "+ (i+1) +"\n===========");
                player1.playCard();
                player2.playCard();
                table.showTable();
            }

            // War table 4 and the war decider if both players had enough cards
            System.out.println("===========\nWar table 4\n===========");
            player1.playCard();
            player2.playCard();
            table.showTable();

            // Put table into war tabe 4 winner's disacrdPile
            // Return tableResult into wartable4_result
            wartable4_result = decideTable();

            // Check weither hand & discardPile is empty or not
            // In case another war is decided but a player has no card in hand
            warWinner();

            // Put discardPile into hand of war winner and ends war if there is a war winner
            // Very important else do while loop runs again
            // Also decides war winner if warWinner doesnt run
            switch (wartable4_result) {
                case 1 -> {
                    player1.discardToHand();
                    warwinner = 1;
                    iswar = false; // Declares war end if there is a war winner
                }
                case 2 -> {
                    player2.discardToHand();
                    warwinner = 2;
                    iswar = false;
                }
            }
        }
    }

    // Choose which discardPile to put table to
    public int decideTable() {
        int result;
        result = table.tableResult();

        // Declares war if cards equal
        if (result == 0) {
            iswar = true;
            warcount++; // Make sure decideTable doesn't run in do while loop
            return result;
        }
        // Put table to discardPile of round winner
        switch (result) {
            case 1 -> player1.tableToDiscard();
            case 2 -> player2.tableToDiscard();
        }
        return result;
    }

    void main() {
        // Set game
        deck.shuffleDeck();
        deck.dealCards(hand1, hand2);

        // Game loop
        for (int i  = 0; i < 3000; i++){

            // Decide match winner
            decideWinner();
            // Break loop if matchend is true
            if(matchend)
                break;

            System.out.println("======Table "+ i +"=======");
            player1.playCard();
            player2.playCard();
            table.showTable();

            // War checker
            do {
                // Only works if no wars are currently ongoing
                if (warcount == 0)
                    decideTable();
                war();
            } while(iswar);
            // Reset warcount so decideTable works if no war
            warcount = 0;
        }

        System.out.println("=======Match end=======\nResults:");
        System.out.println("Winner: Player " + winner);
        System.out.println("Player 1: hand size: "+hand1.handSize()+", pile size: "+discardPile1.discardSize());
        System.out.println("Player 2: hand size: "+hand2.handSize()+", pile size: "+discardPile2.discardSize());
        System.out.println("=======================");

    }
}
