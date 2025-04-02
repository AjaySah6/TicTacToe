package com.example.tictactoe1;
import com.example.tictactoe1.controller.GameController;
import com.example.tictactoe1.models.Game;
import com.example.tictactoe1.models.GameState;
import com.example.tictactoe1.models.Player;
import com.example.tictactoe1.models.Symbol;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Tictactoe1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Tictactoe1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        // Set board dimension
        int dimension = 3;

        while (true) { // Loop to keep playing until the player decides to stop

            // Create players
            List<Player> players = new ArrayList<>();
            players.add(new Player("Player1", new Symbol('X')));
            players.add(new Player("Player2", new Symbol('O')));

            // Start a new game
            Game game = gameController.startGame(players, dimension);

            while (gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
                gameController.printBoard(game);
                gameController.makeMove(game);
            }

            // Game ended
            System.out.println("Game is finished");
            GameState gameState = gameController.checkState(game);

            if (gameState == GameState.DRAW) {
                System.out.println("Game is a Draw.");
            } else if (gameState == GameState.WIN) {
                System.out.println("Game won by " + gameController.getWinner(game).getName());
            }

            // Ask if the player wants to play again
            System.out.print("Do you want to play again? (Y/N): ");
            String response = scanner.next().trim().toUpperCase();

            if (!response.equals("Y")) {
                System.out.println("Thanks for playing! Goodbye.");
                break; // Exit the loop and terminate the program
            }
        }
        scanner.close();
    }
}
