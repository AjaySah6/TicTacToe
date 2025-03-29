package com.example.tictactoe1.controller;

import com.example.tictactoe1.models.Game;
import com.example.tictactoe1.models.GameState;
import com.example.tictactoe1.models.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameController {

    public Game startGame(List<Player>players, int dimensions){
        Game game = new Game(players, dimensions);
        return game;
    }

    //You have defined @Getter on gameState, which means Lombok will generate a getter method named getGameState(), not getGameStatus().
    public GameState checkStatus(Game game){
        return game.getGameState();
    }
    public void makeMove(Game game){
        game.makeMove();
    }

    public Player getWinner(Game game) {
        return game.getWinner(); // coming from Game Class
    }
    public GameState checkState(Game game) {
        return game.getGameState();
    }
    public void printBoard(Game game){
        game.printBoard();
    }

}
