package wordSquare.wordSquareLogic;

public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming words consist of lowercase English letters
        isEndOfWord = false;
    }
}