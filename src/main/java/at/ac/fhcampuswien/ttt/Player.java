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

    public void makeMove(TicTacToe game, Scanner scanner) {
        System.out.printf("makeMove %s ", this);
        scanner.nextInt();
    }
}
