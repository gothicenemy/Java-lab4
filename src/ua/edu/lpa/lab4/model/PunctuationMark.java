package ua.edu.lpa.lab4.model;

public class PunctuationMark implements SentenceMember {
    private final char symbol;

    public PunctuationMark(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}