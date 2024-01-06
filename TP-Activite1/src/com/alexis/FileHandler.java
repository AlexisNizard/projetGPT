package com.alexis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class FileHandler {
    public static void loadTermsFromChunk(String filename, Trie trie, int chunkSize, Consumer<Trie> chunkProcessor) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("//") || !line.contains(";")) {
                    continue;
                }
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String term = parts[1].trim().replace("\"", "");
                        trie.insert(term, id);
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid line: " + line);
                    }
                }
                if (++count == chunkSize) {
                    chunkProcessor.accept(trie);
                    trie = new Trie(); // Reset trie for the next chunk
                    count = 0;
                }
            }
            if (count > 0) {
                chunkProcessor.accept(trie); // Process the last chunk
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
