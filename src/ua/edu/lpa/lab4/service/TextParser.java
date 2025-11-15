package ua.edu.lpa.lab4.service;

import ua.edu.lpa.lab4.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final Pattern SENTENCE_MEMBER_PATTERN = Pattern.compile("(\\w+)|([.,:;!?])");

    private static final Pattern SENTENCE_SPLIT_PATTERN = Pattern.compile("(?<=[.!?])\\s+");

    public static Text parse(String textData) {
        if (textData == null || textData.isEmpty()) {
            return new Text(new Sentence[0]);
        }

        List<Sentence> sentences = new ArrayList<>();
        String[] sentenceStrings = SENTENCE_SPLIT_PATTERN.split(textData);

        for (String sentenceString : sentenceStrings) {
            if (!sentenceString.trim().isEmpty()) {
                sentences.add(parseSentence(sentenceString.trim()));
            }
        }
        return new Text(sentences.toArray(new Sentence[0]));
    }

    private static Sentence parseSentence(String sentenceString) {
        List<SentenceMember> members = new ArrayList<>();
        Matcher matcher = SENTENCE_MEMBER_PATTERN.matcher(sentenceString);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                members.add(new Word(matcher.group(1)));
            } else if (matcher.group(2) != null) {
                members.add(new PunctuationMark(matcher.group(2).charAt(0)));
            }
        }
        return new Sentence(members.toArray(new SentenceMember[0]));
    }
}