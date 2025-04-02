package com.example.tictactoe1.models;

import com.example.tictactoe1.strategy.*; // to import everything inside strategy package


import java.util.ArrayList;
import java.util.List;


public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameState;
    public List<WinningStrategy> winningStrategy;
    private int nextMovePlayerIndex = 0;

    private Player winner;

    public Game(List<Player> players, int dimensions) {
        this.players = players;
        this.board = new Board(dimensions);
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;

        // Automatically initialize strategies here
        this.winningStrategy = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagWinningStrategy()
        );
    }

    // Since all the model class is having business logic,
    // we will add the implementation of makeModel in model class ex- Player, Bot

    public void makeMove()  {
        Player currentMovePlayer = players.get(nextMovePlayerIndex); // returns current player
        System.out.println("It is " + currentMovePlayer.getName() + "'s turn. Please make your move. ");

        // the input of row and col has to be validated first and then move should be stored

        int[] moveCoordinates = currentMovePlayer.inputMove(board); // creating an integer array and then using it to store the row and column values
        int row = moveCoordinates[0];
        int col = moveCoordinates[1];

        // Validate the move BEFORE modifying the board
        if (!validateCellState(row, col)) {
            System.out.println("Move is invalid. Try again!");
            return;
        }

        // Now it's safe to update the board
        Cell cellToUpdate = board.getCell(row, col);
        cellToUpdate.setPlayer(currentMovePlayer);
        cellToUpdate.setCellState(CellState.FILLED);

        // Store the move
        Move lastMove = new Move(currentMovePlayer, cellToUpdate);
        moves.add(lastMove);

        // Update player turn
        nextMovePlayerIndex = (nextMovePlayerIndex + 1) % players.size();

        // Check for win/draw
        if (checkWin(lastMove)) {
            gameState = GameState.WIN;
            winner = currentMovePlayer;
        } else if (moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }
    }

    private boolean validateCellState(int row, int col) {
        // Ensure row and col are within board boundaries
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            System.out.println("Move is out of bounds!");
            return false;
        }

        // Ensure the cell is empty before allowing the move
        if (board.getCell(row, col).getCellState() != CellState.EMPTY) {
            System.out.println("Cell is already occupied!");
            return false;
        }

        return true;
    }

    private boolean checkWin(Move move) {
        for(WinningStrategy winningStrategy : winningStrategy) {
            if(winningStrategy.checkWin(board, move)){
                return true;
            }
        }
        return false; // Ensure it always returns a boolean
    }

    private boolean validateCellState(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Validating move at (" + row + ", " + col + ")");
        printBoard();

        //row and column in valid range
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            System.out.println("Move is out of bounds!");
            return false;
        }

        // Check if the cell is already occupied
        if (board.getCell(row, col).getCellState() != CellState.EMPTY) {
            System.out.println("Cell is already occupied!");
            return false;
        }

        System.out.println("Move is valid!");
        return true;
    }


    public void printBoard() {
        board.printBoard();
    }

    public GameState getGameState() {
        return gameState;
    }


    public Player getWinner() {
        return this.winner;
    }

    public void printBoardShowingCellState(){
        board.showingCellState();
    }
}
