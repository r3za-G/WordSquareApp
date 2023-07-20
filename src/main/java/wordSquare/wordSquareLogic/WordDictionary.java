package wordSquare.wordSquareLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
    private Set<String> validWords;

    // Constructor that loads valid words from a given URL
    public WordDictionary(String wordURL) {
        validWords = loadWordsFromURL(wordURL);
    }

    // Load words from a URL and create a set of valid words
    public Set<String> loadWordsFromURL(String wordURL) {
        Set<String> filteredWords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(wordURL).openStream()))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.trim().toLowerCase();
                filteredWords.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filteredWords;
    }

    // Check if a word is in the set of valid words
    public boolean isValidWord(String word) {
        return validWords.contains(word.toLowerCase());
    }

    // Filter words of a given size that contain specified letters
    public Set<String> filterWords(int wordSize, String letters) {
        Set<String> filteredWords = new HashSet<>();
        for (String word : validWords) {
            if (word.length() == wordSize && containsLetters(letters, word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }

    // Check if a word contains all the letters in a given set of letters
    public boolean containsLetters(String letters, String word) {
        Set<Character> lettersSet = new HashSet<>();
        for (char c : letters.toCharArray()) {
            lettersSet.add(c);
        }
        for (char c : word.toCharArray()) {
            if (!lettersSet.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
