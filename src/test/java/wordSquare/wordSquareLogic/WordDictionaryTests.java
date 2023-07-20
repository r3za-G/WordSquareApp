package wordSquare.wordSquareLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {

    private WordDictionary dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new WordDictionary("http://norvig.com/ngrams/enable1.txt");
    }

    @Test
    void testIsValidWord() {
        assertTrue(dictionary.isValidWord("apple"));
        assertFalse(dictionary.isValidWord("evensdsfwd"));
    }

    @Test
    void testFilterWords() {
        // Test filtering words based on word size and letters
        Set<String> filteredWords = dictionary.filterWords(5, "pplae");
        assertTrue(filteredWords.contains("apple"));
        assertFalse(filteredWords.contains("orange"));
    }

    @Test
    void testContainsLetters() {
        assertTrue(dictionary.containsLetters("bannana", "nabanna"));
        assertTrue(dictionary.containsLetters("apple", "pale"));
        assertFalse(dictionary.containsLetters("apple", "orange"));
    }
}
