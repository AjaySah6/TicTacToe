//package com.example.tictactoe1;
//
//import com.example.tictactoe1.controller.GameController;
//import com.example.tictactoe1.models.Game;
//import com.example.tictactoe1.models.GameState;
//import com.example.tictactoe1.models.Player;
//import com.example.tictactoe1.models.Symbol;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//public class MainGame {
//    public static void main(String[] args) {
//        GameController gameController = new GameController();
//        Scanner scanner = new Scanner(System.in);
//
//        // Set board dimension
//        int dimension = 3;
//
//        // Create players
//        List<Player> players = new ArrayList<>();
//        players.add(new Player("Player1", new Symbol('X')));
//        players.add(new Player("Player2", new Symbol('O')));
//
//        // Start game
//        Game game = gameController.startGame(players, dimension);
//
//        while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
//            gameController.printBoard(game);
//            gameController.makeMove(game);
//        }
//
//        // Game ended
//        System.out.println("Game is finished");
//        GameState gameState = gameController.checkState(game);
//
//        if (gameState == GameState.DRAW) {
//            System.out.println("Game is Draw");
//        } else if (gameState == GameState.WIN) {
//            System.out.println("Game won by " + gameController.getWinner(game).getName());
//        }
//
//        scanner.close();
//    }
//}
