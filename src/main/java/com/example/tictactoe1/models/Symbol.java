package com.example.tictactoe1.models;

public class Symbol {
    private char character;

    public Symbol(char character) {
        this.character = character;
    }
    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }


}
