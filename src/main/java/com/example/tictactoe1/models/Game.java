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
        Player currentMovePlayer = players.get(nextMovePlayerIndex); // This line retrieves the player whose turn it is based on nextMovePlayerIndex.
        System.out.println("It is "+ currentMovePlayer.getName()+ "turn. Please make your move. ");

        Move move = currentMovePlayer.inputMove(board); // capture and store a player's move so that it can be validated and processed later.

        printBoardShowingCellState();

        if(!validateCellState(move)){
            System.out.println("Move is invalid. Try again!");
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        // 🔹 Retrieving the Cell from the Board, and updating the Cell

        Cell cellToUpdate = board.getCell(row, col); //This retrieves a specific cell.
        cellToUpdate.setPlayer(currentMovePlayer);   // Set Player
        cellToUpdate.setCellState(CellState.FILLED); // Changing Cell State

        //A new Move object is created to store the move. Updating the Board (Modifying the Cell)

        Move lastMove = new Move(currentMovePlayer, board.getCell(row, col));
        //board.getCell(row, col).setCellState(CellState.FILLED);
        // board.getCell(row, col).setPlayer(currentMovePlayer);
        moves.add(lastMove); //Storing the Move in the Game

        // we are calling setCellState() and setPlayer() twice: the below code is not required and can be removed
        // board.getCell(row, col).setCellState(CellState.FILLED);
        //board.getCell(row, col).setPlayer(currentMovePlayer);

        nextMovePlayerIndex = (nextMovePlayerIndex + 1) % players.size();


        if(checkWin(lastMove)) {
            gameState = GameState.WIN;
            winner = currentMovePlayer; // Winner Set
        } else if(moves.size() == board.getSize() * board.getSize()) {
            gameState = GameState.DRAW;
        }

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
