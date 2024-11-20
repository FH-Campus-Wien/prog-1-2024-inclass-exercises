package at.ac.fhcampuswien.ttt;

import java.util.Scanner;

public class TicTacToe {

public static final int ROWS=3;
public static final int COLS=3;

private char[][] gameBoard=new char[ROWS][COLS];
private Player p1, p2;

public static void main(String[] args) {
    try {
        TicTacToe ttt = new TicTacToe(new Player("Max", 'X'), new Player("Moritz", 'Y'));
        ttt.playGame();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public TicTacToe(Player p1, Player p2) {
    this.p1=p1;
    this.p2=p2;
}

public void playGame()
{
    Scanner sc=new Scanner(System.in);
    this.prettyPrintGameBoard(); // added
    do {
        p1.makeMove(this,sc);
        this.prettyPrintGameBoard();
        if(spielIstOffen()) {
            p2.makeMove(this, sc);
            this.prettyPrintGameBoard();
        }
    }
    while(spielIstOffen());
}

private boolean spielIstOffen() {
    System.out.println("spielIstOffen");
    return true;
}

public boolean placeTic(Player p, int row, int col) {
    System.out.printf("placeTic %p %d %d %n", p, row, col);
    return true;
}

public void prettyPrintGameBoard() // implemented
{
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            System.out.print(belegt(i,j) ? symbol(i,j) : position(i,j));
            if (!letzteSpalte(j)) {
                System.out.print(" | ");
            }
        }
        System.out.println();
        if(!letzteZeile(i)) {
           System.out.println("--+---+--");
        }
    }
}

private boolean belegt(int i, int j) {
    return gameBoard[i][j]!=0;
}

private char symbol(int i, int j){
    return gameBoard[i][j];
}

private int position(int i, int j) {
    return i*COLS+1+j;
}

private boolean letzteSpalte(int i) {
    return i == COLS-1;
}
private boolean letzteZeile(int i) {
        return i == ROWS-1;
}

public boolean checkIfWon(Player p) {
    System.out.printf("checkIfWon %p %n",p);
    return false;
}

}
