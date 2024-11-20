package at.ac.fhcampuswien.ttt;

import java.util.Scanner;

public class Player {

    String name;
    char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String toString() {
        return this.name + " " + this.symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(TicTacToe game, Scanner scanner)
    {
        boolean success = false;
        do {
            System.out.printf("%s make your move (choose a number): ", this.name);
            int posi= scanner.nextInt();
            success= posiGueltig(posi) ? game.placeTic(this, zeileFuer(posi),spalteFuer(posi)): false;
        } while(!success);
    }

    private boolean posiGueltig(int posi) {
        return (posi >0) && (posi <= TicTacToe.ROWS*TicTacToe.COLS);
    }
    private int zeileFuer(int posi) {
        return (posi-1) / TicTacToe.ROWS;
    }
    private int spalteFuer(int posi) {
        return (posi-1) % TicTacToe.COLS;
    }

}
