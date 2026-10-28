package game;

import cards.Card;

import java.util.Stack;

public class Table {
    private Stack<Card> table;

    public Table() {
        table = new Stack<>();
    }

    // Show table result
    public int tableResult() {
        int last_rank = table.peek().getRank();
        int be_last_rank = table.elementAt(table.size() - 2).getRank();
        if (last_rank > be_last_rank) {
            return 1;
        } else if (last_rank < be_last_rank) {
            return 2;
        }else {
            return 0;
        }
    }

    // Show all table
    public void showTable() {
        int table_size = table.size() - 1;
        for (int i = table_size; i >= 0; i--) {
            table.elementAt(i).displayCard();
        }
    }

    // Show last item in table
    public  void showTable(int index) {
        table.pop().displayCard();
    }

    // Return table size
    public int tableSize() {
        return table.size();
    }

    // Push to table
    public void toTable(Card card){
        table.push(card);
    }

    // Get from anywhere in table
    public Card fromTable(int index) {
        Card card = table.elementAt(index);
        table.removeElementAt(index);
        return card;
    }

    //Get last item from table
    public Card fromTable() {
        return table.pop();
    }

}
