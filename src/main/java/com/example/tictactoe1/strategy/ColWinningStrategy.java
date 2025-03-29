package com.example.tictactoe1.strategy;

import com.example.tictactoe1.models.Board;
import com.example.tictactoe1.models.Move;
import com.example.tictactoe1.models.Player;

public class ColWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWin(Board board, Move lastMove){

        int col = lastMove.getCell().getCol();
        Player player = lastMove.getPlayer();

        for (int r = 0; r < board.getSize(); r++) {
            if (board.getCell(r, col).getPlayer() == null ||
            board.getCell(r, col).getPlayer().getSymbol().getCharacter() != player.getSymbol().getCharacter()) {
                return false;
            }
        }
        return true;
    }
}
