package wordSquare.wordSquareLogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GenerateWordSquare {
    private char[][] wordSquare;
    private Set<String> words;
    private int wordSize;
    private List<String> filteredWordSquare;
    
    private Trie trie;

    public GenerateWordSquare(Set<String> words) {
        this.words = words;
        this.wordSize = words.iterator().next().length();
        this.wordSquare = new char[wordSize][wordSize];

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

    private void backtrack(int row, List<List<String>> result) {
        if (row == wordSize) {
            result.add(buildWordSquare());
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < row; i++) {
            prefix.append(wordSquare[i][row]);
        }

        TrieNode node = trie.root;
        for (char ch : prefix.toString().toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return; // Prefix does not exist, backtrack
            }
            node = node.children[index];
        }

        for (String word : words) {
            if (word.startsWith(prefix.toString())) {
                wordSquare[row] = word.toCharArray();
                backtrack(row + 1, result);
            }
        }
    }

    private List<String> buildWordSquare() {
        List<String> square = new ArrayList<>();
        for (int i = 0; i < wordSize; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < wordSize; j++) {
                word.append(wordSquare[i][j]);
            }
            square.add(word.toString());
        }
        return square;
    }

    public List<String> filterWordSquares(List<List<String>> wordSquares, String letters) {
        for (List<String> wordSquare : wordSquares) {
            if (isWordSquareValid(wordSquare, letters)) {
                filteredWordSquare = wordSquare;
                break;
            }
        }
        return filteredWordSquare;
    }

    public static String concatenateWords(List<String> wordList) {
        StringBuilder concatenated = new StringBuilder();
        for (String word : wordList) {
            concatenated.append(word);
        }
        return concatenated.toString();
    }

    public static List<String> sortLetters(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        List<String> sortedLettersList = new ArrayList<>();
        sortedLettersList.add(new String(charArray));
        return sortedLettersList;
    }
    
    public boolean isWordSquareValid(List<String> wordSquare, String letters) {

        Boolean isValid = false;
        
        // Sort the input letters in alphabetical order
        char[] sortedInputLetters = letters.toCharArray();
        Arrays.sort(sortedInputLetters);
        String sortedLetters = new String(sortedInputLetters);
    
        String concatenatedWords = concatenateWords(wordSquare);
        List<String> sortedWordSquare = sortLetters(concatenatedWords);
        
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