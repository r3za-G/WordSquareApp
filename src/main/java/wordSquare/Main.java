package wordSquare;

import java.util.List;
import java.util.Set;

import wordSquare.wordSquareLogic.GenerateWordSquare;
import wordSquare.wordSquareLogic.WordDictionary;


public class Main {

    public static void main(String[] args) {
        // Check if the correct number of command-line arguments is provided
        if (args.length != 2) {
            System.out.println("Usage: java Main <number_of_rows> <input_letters>");
            return;
        }

        int wordSquareSize = Integer.parseInt(args[0]);
        String wordSquareLetters = args[1].toLowerCase();

        // Create a WordDictionary instance and filter words based on size and input letters
        WordDictionary wordDictionary = new WordDictionary("http://norvig.com/ngrams/enable1.txt");
        Set<String> filteredWords = wordDictionary.filterWords(wordSquareSize, wordSquareLetters);

        // Generate word squares from the filtered words
        GenerateWordSquare wordSquareGenerator = new GenerateWordSquare(filteredWords);
        List<List<String>> wordSquares = wordSquareGenerator.generateWordSquares();

        // Filter valid word square(s) based on input letters
        String letters = wordSquareLetters;
        List<String> filteredWordSquare = wordSquareGenerator.filterWordSquares(wordSquares, letters);

        // Print the word square
        if (filteredWordSquare != null) {
            for (String words : filteredWordSquare) {
                System.out.println(words);
            }
        } else {
            System.out.println("Could not find word square from the given input.");
        }
    }
}
