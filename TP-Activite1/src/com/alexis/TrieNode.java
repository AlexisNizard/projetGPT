package com.alexis;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    int id; // Pour stocker l'ID du terme

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        id = -1;
    }
}

class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word, int id) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
        current.id = id;
    }

    public TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }

    public List<Term> getTermsWithPrefix(String prefix) {
        List<Term> results = new ArrayList<>();
        TrieNode current = searchNode(prefix);
        if (current != null) {
            findAllTerms(current, prefix, results);
        }
        return results;
    }

    private void findAllTerms(TrieNode current, String prefix, List<Term> results) {
        if (current.isEndOfWord) {
            results.add(new Term(prefix, current.id));
        }
        for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
            findAllTerms(entry.getValue(), prefix + entry.getKey(), results);
        }
    }
}
