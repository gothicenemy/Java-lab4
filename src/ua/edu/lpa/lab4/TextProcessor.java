package ua.edu.lpa.lab4;

import ua.edu.lpa.lab4.model.Sentence;
import ua.edu.lpa.lab4.model.SentenceMember;
import ua.edu.lpa.lab4.model.Text;
import ua.edu.lpa.lab4.model.Word;
import ua.edu.lpa.lab4.service.TextParser;

/**
 * Лабораторна робота №4.
 * Виконавець: Максимовський Назар Русланович
 * Група: ІМ-31
 */
public class TextProcessor {

    public static void main(String[] args) {

        String inputText = "This is the first sentence. This is the second sentence, which contains the word 'Java'. " +
                "The third sentence also has 'Java' and the word 'code'. " +
                "Java is a programming language. JavaScript is another language. " +
                "This final sentence has no keywords.";

        String[] wordsToSearch = {"Java", "sentence", "code", "word", "language"};

        System.out.println("--- Lab 4 Analysis (using Class Composition) ---");

        try {
            if (inputText == null || wordsToSearch == null) {
                throw new NullPointerException("Input text or word array cannot be null.");
            }

            String cleanedText = replaceMultipleWhitespace(inputText);
            System.out.println("Cleaned text: " + cleanedText);

            Text text = TextParser.parse(cleanedText);

            if (text.getSentences().length == 0) {
                System.out.println("Input text is empty. Analysis is not possible.");
                return;
            }

            System.out.println("Sentences to analyze: " + text.getSentences().length);
            System.out.println("Words to search for: " + String.join(", ", wordsToSearch));
            System.out.println("---------------------------");

            performLab2Action(text, wordsToSearch);

        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Метод, що виконує дію з ЛР №2 (C17=9).
     */
    public static void performLab2Action(Text text, String[] wordsToSearch) {

        for (String wordToFind : wordsToSearch) {
            int sentenceCount = 0;

            for (Sentence sentence : text.getSentences()) {
                if (sentenceContainsWord(sentence, wordToFind)) {
                    sentenceCount++;
                }
            }
            System.out.println("The word '" + wordToFind + "' was found in " + sentenceCount + " sentences.");
        }
    }

    /**
     * Допоміжний метод, що перевіряє наявність слова в об'єкті Sentence.
     */
    public static boolean sentenceContainsWord(Sentence sentence, String wordToFind) {
        for (SentenceMember member : sentence.getMembers()) {

            // Нас цікавлять тільки об'єкти типу Word
            if (member instanceof Word) {
                Word word = (Word) member;

                if (word.toString().equalsIgnoreCase(wordToFind)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Замінює послідовності пробілів та табуляцій одним пробілом.
     */
    public static String replaceMultipleWhitespace(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }
}