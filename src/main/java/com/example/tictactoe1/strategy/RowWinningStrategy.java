package com.example.tictactoe1.strategy;

import com.example.tictactoe1.models.Board;
import com.example.tictactoe1.models.Move;
import com.example.tictactoe1.models.Player;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, Move lastMove) {

        int row = lastMove.getCell().getRow();
        Player player = lastMove.getPlayer();

        for (int c = 0; c < board.getSize(); c++) {
            if (board.getCell(row,c).getPlayer() == null ||
            board.getCell(row,c).getPlayer().getSymbol().getCharacter() != player.getSymbol().getCharacter()){
                return false;
            }
        }
        return true;
    }
}
