package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode {
        Map<Character, TrieNode> node = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode rootNode;

    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new TrieNode();
    }

    /** Inserts a word into the rootNode. */
    public void insert(String word) {
        TrieNode currentNode = rootNode;

        for (char c : word.toCharArray()) {
            //If character doesn't exist
            if (!currentNode.node.containsKey(c)) {
                currentNode.node.put(c, new TrieNode());
            }
            currentNode = currentNode.node.get(c);
        }

        currentNode.isWord = true;
    }


    /** Returns if the word is in the rootNode. */
    public boolean search(String word) {
        TrieNode currentNode = rootNode;

        for(char c : word.toCharArray()) {
            //If character doesn't exist
            if (!currentNode.node.containsKey(c)) {
                return false;
            }

            //Advance otherwise
            currentNode = currentNode.node.get(c);
        }
        return currentNode.isWord;
    }

    /** Returns if there is any word in the rootNode that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currentNode = rootNode;

        for(char c : prefix.toCharArray()) {
            //If character doesn't exist
            if (!currentNode.node.containsKey(c)) {
                return false;
            }

            //Advance otherwise
            currentNode = currentNode.node.get(c);
        }
        //If no error, then yes it exists
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        System.out.println(param_2);
        boolean param_3 = obj.startsWith("ap");
        System.out.println(param_3);
    }
}
