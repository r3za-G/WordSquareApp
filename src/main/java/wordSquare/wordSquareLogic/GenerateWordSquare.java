package wordSquare.wordSquareLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GenerateWordSquare {
    private List<String> wordSquare;
    private Set<String> words;
    private int wordSize;
    private List<String> filteredWordSquare;

    private Trie trie;

    // Constructor that initializes the wordSquare and trie data structures
    public GenerateWordSquare(Set<String> words) {
        this.words = words;
        this.wordSize = words.iterator().next().length();
        this.wordSquare = new ArrayList<>();

        // Create a Trie data structure to efficiently check prefixes
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
    }

    public List<List<String>> generateWordSquares() {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, result);
        return result;
    }

    // Backtracking method to build the word squares row by row
    private void backtrack(int row, List<List<String>> result) {
        if (row == wordSize) {
            result.add(new ArrayList<>(wordSquare)); // Add a copy of the wordSquare list
            return;
        }

        // Build the prefix for the current row from the words in the previous rows
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < row; i++) {
            prefix.append(wordSquare.get(i).charAt(row));
        }

        // Use the trie to find words with the matching prefix
        TrieNode node = trie.root;
        for (char ch : prefix.toString().toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return; // Prefix does not exist, backtrack
            }
            node = node.children[index];
        }

        // Try adding words that match the prefix to build the next row
        for (String word : words) {
            if (word.startsWith(prefix.toString())) {
                wordSquare.add(word);
                backtrack(row + 1, result);
                wordSquare.remove(wordSquare.size() - 1); // Backtrack by removing the last word
            }
        }
    }

    // Utility method to build a word square from the wordSquare list
    private List<String> buildWordSquare() {
        List<String> square = new ArrayList<>();
        for (int i = 0; i < wordSize; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < wordSize; j++) {
                word.append(wordSquare.get(i).charAt(j));
            }
            square.add(word.toString());
        }
        return square;
    }

    // Filter word squares and return the first valid word square
    public List<String> filterWordSquares(List<List<String>> wordSquares, String letters) {
        for (List<String> wordSquare : wordSquares) {
            if (isWordSquareValid(wordSquare, letters)) {
                filteredWordSquare = wordSquare;
                break;
            }
        }
        return filteredWordSquare;
    }

    // Utility method to concatenate words in a word list
    public static String concatenateWords(List<String> wordList) {
        StringBuilder concatenated = new StringBuilder();
        for (String word : wordList) {
            concatenated.append(word);
        }
        return concatenated.toString();
    }

    // Utility method to sort letters in alphabetical order
    public static List<String> sortLetters(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        List<String> sortedLettersList = new ArrayList<>();
        sortedLettersList.add(new String(charArray));
        return sortedLettersList;
    }
    
    // Check if a word square contains a valid word formed by the given letters
    public boolean isWordSquareValid(List<String> wordSquare, String letters) {

        Boolean isValid = false;
        
        // Sort the input letters in alphabetical order
        char[] sortedInputLetters = letters.toCharArray();
        Arrays.sort(sortedInputLetters);
        String sortedLetters = new String(sortedInputLetters);
    
        String concatenatedWords = concatenateWords(wordSquare);
        List<String> sortedWordSquare = sortLetters(concatenatedWords);
        
        // Check if any word in the word square contains the sortedLetters
        for(String wordString : sortedWordSquare) {
            if (wordString.contains(sortedLetters)) {
                isValid = true;
            }
            else {
            isValid = false;
            }
        } 
        return isValid;       
    }
}
