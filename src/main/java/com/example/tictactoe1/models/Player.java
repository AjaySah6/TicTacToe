package com.example.tictactoe1.models;

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

    public Move inputMove(Board board){
        System.out.println("Enter row for making move, 0 based index");
        int row = scanner.nextInt();
        System.out.println("Enter column for making move, 0 based index");
        int col = scanner.nextInt();

        Cell cell = board.getCell(row,col);
        cell.setPlayer(this);

        return new Move(this, cell);
        // after user have entered his move, we can validate the input
        // If we create a bot, the bot class should also have makeMove();
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
