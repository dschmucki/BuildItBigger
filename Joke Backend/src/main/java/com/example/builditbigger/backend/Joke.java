package com.example.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class Joke {

    private String joke;

    public Joke(final String joke) {
        this.joke = joke;
    }

    public String getJoke() {
        return this.joke;
    }
}