package ua.edu.lpa.lab4.model;

public class Letter {
    private final char character;

    public Letter(char character) {
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