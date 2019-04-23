package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> nodeMap = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode rootNode = new TrieNode();

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode currentNode = rootNode;
        for(char c : word.toCharArray()) {
            currentNode.nodeMap.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.nodeMap.get(c);
        }
        currentNode.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(rootNode, 0, word);
    }

    public boolean searchHelper(TrieNode node, int pos, String word) {
        //reached to end of the word
        if(pos == word.length()) {
            return node.isWord;
        }

        //reached to lead node before finish scanning the word
        if(node.nodeMap.size() == 0) {
            return false;
        }

        //found . then recursively call all keysets
        if(word.charAt(pos) == '.') {
            for(char c : node.nodeMap.keySet()) {
                if(searchHelper(node.nodeMap.get(c), pos + 1, word)) {
                    return true;
                }
            }
        }

        //cannot find character
        if(!node.nodeMap.containsKey(word.charAt(pos))) {
            return false;
        }

        //did found character
        return searchHelper(node.nodeMap.get(word.charAt(pos)), pos+1, word);
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.t"));
    }
}
