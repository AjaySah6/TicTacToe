package com.example.tictactoe1.strategy;

import com.example.tictactoe1.models.Board;
import com.example.tictactoe1.models.Move;
import com.example.tictactoe1.models.Player;

public class DiagWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWin(Board board, Move lastMove) {

        Player player = lastMove.getPlayer();

        return checkRightDiagonal(player, board) || checkLeftDiagonal(player, board);
    }

    //Top left to bottom right

    private boolean checkRightDiagonal(Player player, Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            if(board.getCell(i,i).getPlayer()==null ||
                    board.getCell(i,i).getPlayer().getSymbol().getCharacter() != player.getSymbol().getCharacter()){
                return false;
            }
        }
        return true;
    }


    // Bottom left to top right

    private boolean checkLeftDiagonal(Player player, Board board) {

        int n = board.getSize();

        for(int r = n-1; r >= 0; r--){
            if(board.getCell(r,n-r-1).getPlayer() == null ||
                    board.getCell(r,n-r-1).getPlayer().getSymbol().getCharacter()!= player.getSymbol().getCharacter()){
                return false;
            }
        }
        return true;
    }
}
