package com.alexis;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LexicalNetProcessor {
    private Map<String, Term> terms;
    private Trie termsTrie;

    public LexicalNetProcessor(Trie trie) {
        this.termsTrie = trie;
    }


    public int getTermId(String term) {
        long startTime = System.currentTimeMillis();
        TrieNode foundTerm = termsTrie.searchNode(term);

        int result = (foundTerm != null && foundTerm.isEndOfWord) ? foundTerm.id : -1;


        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution pour getTermId: " + (endTime - startTime) + " ms");

        return result;
    }

    public List<Term> getTermsWithPrefix(String prefix) {
        long startTime = System.currentTimeMillis();

        // Appel à la méthode getTermsWithPrefix de l'objet Trie
        List<Term> matchingTerms = termsTrie.getTermsWithPrefix(prefix);

        long endTime = System.currentTimeMillis();
        System.out.println("Temps d'exécution pour getTermsWithPrefix: " + (endTime - startTime) + " ms");

        // Renvoie null si la liste est vide, sinon renvoie la liste
        return matchingTerms.isEmpty() ? null : matchingTerms;
    }

}
