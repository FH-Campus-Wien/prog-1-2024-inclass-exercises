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
    this.prettyPrintGameBoard();
    do {
        p1.makeMove(this,sc);
        this.prettyPrintGameBoard();
        if(spielIstOffen()) {
            p2.makeMove(this, sc);
            this.prettyPrintGameBoard();
        }
    } while(spielIstOffen());

    Player winner= winner();
    System.out.printf(winner==null?
            "Nobody wins!":
            winner.getName()+ " has won the game!"
    );
}

private Player winner() {
    if (checkIfWon(p1)) {
        return p1;
    } else if (checkIfWon(p2)) {
        return p2;
    } else {
        return null;
    }
}

private boolean spielIstOffen() {
    return (!spielFeldVoll() && winner() == null);
}

private boolean spielFeldVoll() {
    for(int i=0; i<ROWS; i++) {
        for(int j=0; j<COLS; j++) {
            if(!belegt(i,j)) {
                return false;
            }
        }
    }
    return true;
}

public boolean placeTic(Player p, int row, int col) {
    if (!belegt(row,col)){
        gameBoard[row][col]=p.getSymbol();
        return true;
    } else {
        return false;
    }
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

private String symbol(int i, int j){
    return String.valueOf(gameBoard[i][j]);
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

public boolean checkIfWon(Player p)
{
    for (int i = 0; i < ROWS; i++) {
        if (rowFilledWith(i,p.getSymbol())) {
            return true;
        }
    }
    for (int i = 0; i < COLS; i++) {
        if (columnFilledWith(i,p.getSymbol())) {
            return true;
        }
    }
    return (diagonale1FilledWith(p.getSymbol()) || diagonale2FilledWith(p.getSymbol()));
}

private boolean rowFilledWith(int row ,char symbol) {
    for (int i = 0; i < COLS; i++) {
        if (gameBoard[row][i] != symbol) {
            return false;
        }
    }
    return true;
}
private boolean columnFilledWith(int column ,char symbol) {
    for (int i = 0; i < ROWS; i++) {
        if (gameBoard[i][column] != symbol) {
            return false;
        }
    }
    return true;
}

private boolean diagonale1FilledWith(char symbol) {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            if (gameBoard[i][j] != symbol) {
                return false;
            }
        }
    }
    return true;
}

private boolean diagonale2FilledWith(char symbol) {
        for(int i = 0; i< ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                if (gameBoard[i][COLS-j-1] != symbol) {
                    return false;
                }
            }
        }
    return true;
}

}
