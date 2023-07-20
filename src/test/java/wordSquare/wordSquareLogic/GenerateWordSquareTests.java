package wordSquare.wordSquareLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import wordSquare.wordSquareLogic.GenerateWordSquare;

class GenerateWordSquareTest {

    private GenerateWordSquare generator;
    private Set<String> words;

    @BeforeEach
    void setUp() {
        // Sample word set
        words = new HashSet<>(Arrays.asList("ball", "area", "lead", "lady"));
        generator = new GenerateWordSquare(words);
    }

    @Test
    void testGenerateWordSquares() {
        List<List<String>> wordSquares = generator.generateWordSquares();
        assertNotNull(wordSquares);
        assertFalse(wordSquares.isEmpty());
    }

    @Test
    void testFilterWordSquares() {
        String letters = "ldyallbaealdaaer";
        List<List<String>> wordSquares = generator.generateWordSquares();
        List<String> filteredWordSquare = generator.filterWordSquares(wordSquares, letters);
        assertNotNull(filteredWordSquare);
        assertFalse(filteredWordSquare.isEmpty());
        
    }

    @Test
    void testIsWordSquareValid() {
        List<String> wordSquare = Arrays.asList("ball", "area", "lead", "lady");
        String letters = "ldyallbaealdaaer";
        assertTrue(generator.isWordSquareValid(wordSquare, letters));
    }

    @Test
    void testConcatenateWords() {
        List<String> wordList = Arrays.asList("hello", "world");
        String concatenated = GenerateWordSquare.concatenateWords(wordList);
        assertEquals("helloworld", concatenated);
    }

    @Test
    void testSortLetters() {
        String input = "hello";
        List<String> sortedLettersList = GenerateWordSquare.sortLetters(input);
        assertEquals(Arrays.asList("ehllo"), sortedLettersList);
    }


}
