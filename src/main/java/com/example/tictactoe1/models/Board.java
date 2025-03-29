package com.example.tictactoe1.models;


import com.example.tictactoe1.Exceptions.InvalidMoveException;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Board {

    private int size;
    private Cell[][] board;

    public Board(int size){
        this.size = size;
        board = new Cell[size][size]; //This creates the 2D array of Cell references, but does NOT create any actual Cell objects yet.


        for (int i = 0; i<size; i++){
            for (int j = 0; j < size; j++){
                board[i][j] = new Cell(i, j); // Initialize each cell
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++){

                Cell cell = board[i][j];
                if(cell == null || cell.getPlayer() == null){
                    System.out.print("|_|"); // Placeholder for empty cells
                }else {
                    System.out.print("|"+cell.getPlayer().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return this.size;
    }

    public Cell getCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new InvalidMoveException("Invalid cell position: (" + row + ", " + col + ")");
        }
        return board[row][col]; // ✅ Returns the existing cell
    }

    public void showingCellState() {
        System.out.println("Printing cell state \uD83D\uDD25 ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = board[i][j];
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("| " + CellState.EMPTY + " |"); // Placeholder for empty cells
                } else {
                    // Display the player's symbol if the cell is occupied
                    System.out.print("| " + cell.getPlayer().getSymbol() + " ");
                }
            }
            System.out.println("|"); // End of row
        }
        System.out.println(); // Add an empty line for better readability
    }

}
