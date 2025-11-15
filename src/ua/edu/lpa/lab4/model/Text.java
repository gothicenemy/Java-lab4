package ua.edu.lpa.lab4.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Text {
    private final Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return Arrays.stream(sentences)
                .map(Sentence::toString)
                .collect(Collectors.joining(" "));
    }
}