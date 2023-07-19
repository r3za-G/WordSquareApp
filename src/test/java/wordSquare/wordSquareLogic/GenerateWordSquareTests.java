package wordSquare.wordSquareLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import wordSquare.wordSquareLogic.GenerateWordSquare;

class GenerateWordSquareTest {
    private GenerateWordSquare wordSquareGenerator;
    private Set<String> words;
    private List<String> wordSquare;
    String concatenatedWordSquare;

    @BeforeEach
    void setUp() {
        // Set up the word list for testing
        words = new HashSet<>(Arrays.asList("eeeeddoonnnsssrv"));
        wordSquare = List.of("rose", "oven", "send", "ends");
        wordSquareGenerator = new GenerateWordSquare(words);
    }

    @Test
    void testGenerateWordSquares() {
        // Test the generation of word squares
        List<List<String>> result = wordSquareGenerator.generateWordSquares();
        System.out.println("------------");
        System.out.println(result.size());
        assertEquals(1, result.size()); // Ensure there is exactly one word square in the result
        assertEquals(words.size(), result.get(0).size()); // Ensure the word square has the correct size
        // You can add more assertions based on specific test cases for word square generation
    }

    @Test
    void testisWordSquareValid() {
        // Test the filtering of word squares based on letters
        String letters = "eeeeddoonnnsssrv";
        assertTrue(wordSquareGenerator.isWordSquareValid(wordSquare, letters)); // Ensure the filtered word square is valid
    }

    @Test 
    void testConcatenateWords() {
        String concatenatedWordSquare = wordSquareGenerator.concatenateWords(wordSquare);
        assertEquals("roseovensendends", concatenatedWordSquare);
    }

    @Test 
    void testSortLetters() {

        List<String> sortedLetters = List.of("ddeeeennnoorsssv");

        assertEquals(sortedLetters, wordSquareGenerator.sortLetters("roseovensendends"));
    }
}
