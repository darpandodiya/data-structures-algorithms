package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    class TrieNode {
        Map<Character, TrieNode> node = new HashMap<>();
        int value = 0;
    }

    TrieNode rootNode;
    Map<String, Integer> prefixScore;

    /** Initialize your data structure here. */
    public MapSum() {
        rootNode = new TrieNode();
        prefixScore = new HashMap<>();
    }

    public void insert(String key, int val) {

        int delta = val - prefixScore.getOrDefault(key, 0);
        prefixScore.put(key, val);

        TrieNode currentNode = rootNode;
        currentNode.value += delta;

        for (char c : key.toCharArray()) {
            currentNode.node.putIfAbsent(c, new TrieNode());
            currentNode.value += delta;
            currentNode = currentNode.node.get(c);
        }

        currentNode.value += delta;
    }

    public int sum(String prefix) {

        TrieNode currentNode = rootNode;

        for (char c : prefix.toCharArray()) {
            if(!currentNode.node.containsKey(c)) {
                return 0;
            }
            currentNode = currentNode.node.get(c);
        }
        return currentNode.value;
    }


    public static void main(String[] args) {

        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }
}
