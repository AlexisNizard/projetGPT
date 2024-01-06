package com.alexis;

public class Utils {
    // Valide si l'entrée est un terme (non vide et sans chiffres)
    public static boolean isValidTerm(String input) {
        return input != null && !input.isEmpty() && !input.matches(".*\\d.*");
    }
    public static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024 / 1024; // Mémoire en Mo
    }
}

