package com.example.tictactoe1.strategy;

import com.example.tictactoe1.models.Board;
import com.example.tictactoe1.models.Move;
import com.example.tictactoe1.models.Player;

//public interface WinningStrategy {
//    boolean checkWin(int row, int col, Player player, Board board);
//}
public interface WinningStrategy {
    boolean checkWin(Board board, Move lastMove);
}
