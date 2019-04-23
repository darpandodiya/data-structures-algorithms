package leetcode;

import java.util.*;

public class ReplaceWords {

    class TrieNode {
        Map<Character, TrieNode> nodeMap = new HashMap<>();
        boolean isRoot = false;
    }

    TrieNode rootNode = new TrieNode();

    public void insertRoot(String root) {
        TrieNode currentNode = rootNode;
        for(char c : root.toCharArray()) {
            currentNode.nodeMap.putIfAbsent(c, new TrieNode());
            currentNode = currentNode.nodeMap.get(c);
        }
        currentNode.isRoot = true;
    }

    public String findPrefix(String word) {
        TrieNode currentNode = rootNode;
        StringBuilder prefixSoFar = new StringBuilder();

        for(char c : word.toCharArray()) {
            if(!currentNode.nodeMap.containsKey(c)) {
                return word;
            }

            prefixSoFar.append(c);

            currentNode = currentNode.nodeMap.get(c);

            if(currentNode.isRoot) {
                return prefixSoFar.toString();
            }
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {

        for(String root : dict) {
            insertRoot(root);
        }

        String[] splitSentence = sentence.split(" ");
        StringBuilder newSentence = new StringBuilder();

        for(String splitWord : splitSentence) {
            newSentence.append(findPrefix(splitWord)).append(" ");
        }

        return newSentence.toString().trim();
    }

    public String replaceWordsHashset(List<String> dict, String sentence) {

        Set<String> rootSet = new HashSet<>();

        for(String root : dict) {
            rootSet.add(root);
        }

        StringBuilder newSentence = new StringBuilder();

        for(String splitWord : sentence.split("\\s+")) {
            StringBuilder currentPrefix = new StringBuilder();

            for(char c : splitWord.toCharArray()) {
                currentPrefix.append(c);

                if(rootSet.contains(currentPrefix.toString())) {
                    break;
                }
            }
            if(newSentence.length() > 0) {
                newSentence.append(" ");
            }
            newSentence.append(currentPrefix.toString());
        }

        return newSentence.toString().trim();
    }


    public static void main(String[] args) {
        List<String> roots = new ArrayList<>();
        roots.add("cat");
        roots.add("bat");
        roots.add("rat");
        String sentence = "the cattle was rattled by the battery";

        System.out.println(new ReplaceWords().replaceWordsHashset(roots, sentence));
    }
}
