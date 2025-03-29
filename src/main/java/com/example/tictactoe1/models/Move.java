package com.example.tictactoe1.models;

import lombok.Getter;
import lombok.Setter;

public class Move {

    private Player player;

    private Cell cell; // cell already contain row, col, player (player already have symbol)

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }
    public Symbol getSymbol() {
        return player.getSymbol();
    }
    public Cell getCell() {
        return this.cell;
    }
    public Player getPlayer() {
        return this.player;
    }
}
