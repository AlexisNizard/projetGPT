package com.alexis;
import java.util.Scanner;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        final int CHUNK_SIZE = 1000000; // Définissez la taille du chunk ici
        Scanner scanner = new Scanner(System.in);

        Consumer<Trie> chunkProcessor = (trie) -> {
            System.out.println("Utilisation de la mémoire avant le chargement: " + Utils.getMemoryUsage() + " Mo");
            LexicalNetProcessor processor = new LexicalNetProcessor(trie);
            System.out.println("Utilisation de la mémoire après le chargement: " + Utils.getMemoryUsage() + " Mo");
            
            while (true) {
                System.out.println("Enter a term to check (or 'exit' to quit):");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                if (Utils.isValidTerm(input)) {
                    int id = processor.getTermId(input);
                    if (id != -1) {
                        System.out.println("Term ID: " + id);
                    } else {
                        List<Term> termsWithPrefix = processor.getTermsWithPrefix(input);
                        if (termsWithPrefix != null) {
                            System.out.println("Terms starting with '" + input + "':");
                            for (Term term : termsWithPrefix) {
                                System.out.println(term.getTerm() + " - " + term.getId());
                            }
                        } else {
                            System.out.println("No terms found.");
                        }
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid term.");
                }
            }
        };

        FileHandler.loadTermsFromChunk("20231214-LEXICALNET-JEUXDEMOTS-ENTRIES-MWE.txt", new Trie(), CHUNK_SIZE, chunkProcessor);
        scanner.close();
    }
}
