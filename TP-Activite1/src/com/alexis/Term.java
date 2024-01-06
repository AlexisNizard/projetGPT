package com.alexis;

public class Term {
    private String term;
    private int id;

    public Term(String term, int id) {
        this.term = term;
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public int getId() {
        return id;
    }
}
