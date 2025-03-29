package com.example.tictactoe1.models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;  // Default state
    }

    // Check if cell is empty
    public boolean isEmpty() {
        return this.cellState == CellState.EMPTY;
    }

    // Getter and Setter Methods
    public void setPlayer(Player player) {
        this.player = player;
        if (this.player == null) {
            this.cellState = CellState.EMPTY;
        } else {
            this.cellState = CellState.FILLED;
        }

        //this.cellState = (player == null) ? CellState.EMPTY : CellState.FILLED;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
        if (cellState == CellState.EMPTY) {
            this.player = null; // Ensure consistency
        }
    }

    public CellState getCellState() {
        return this.cellState;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public String toString() {
        return "Cell[row=" + row + ", col=" + col + ", state=" + cellState + ", player=" + (player != null ? player.getName() : "None") + "]";
    }
}
