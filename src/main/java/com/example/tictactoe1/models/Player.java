package com.example.tictactoe1.models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    String name;
    Symbol symbol;
    //Long id;
    // private idCounter = 0;

    private Scanner scanner;

    // To Do: write ID generation logic
    public Player(String name, Symbol symbol) {
        //this.id = idCounter + 1;
        this.name = name;
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public int[] inputMove(Board board){
        int row, col;
        while (true) {
            System.out.println("Enter row (0-based index): ");
            row = scanner.nextInt();
            System.out.println("Enter column (0-based index): ");
            col = scanner.nextInt();

            // Validate input bounds before returning
            if (row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize()) {
                break;
            }
            System.out.println("Invalid input! Please enter a valid row and column.");
        }
        return new int[]{row, col};
    }


    //Getter and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
