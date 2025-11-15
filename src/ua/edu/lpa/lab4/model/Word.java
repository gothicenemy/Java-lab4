package ua.edu.lpa.lab4.model;

public class Word implements SentenceMember {
    private final Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public Word(String word) {
        this.letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.letters[i] = new Letter(word.charAt(i));
        }
    }

    public Letter[] getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getCharacter());
        }
        return sb.toString();
    }
}