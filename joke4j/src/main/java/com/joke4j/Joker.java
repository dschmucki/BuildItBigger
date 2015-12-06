package com.joke4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    private List<String> jokes;

    private Random random = new Random();

    public Joker() {
        initJokes();
    }

    public String getJoke() {
        int i = random.nextInt(jokes.size());
        return jokes.get(i);
    }

    private void initJokes() {
        jokes = new ArrayList<>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("protolol.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                jokes.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            fallback();
        }
    }

    private void fallback() {
        jokes.clear();
        jokes.addAll(
                Arrays.asList("I tried to come up with an IPv4 joke, but the good ones were all already exhausted.",
                        "The best thing about UDP jokes is that I don't care if you get them or not.",
                        "The worst thing about Perl jokes is that next morning you can't understand why they seemed so funny.",
                        "The worst part about token ring jokes is that if someone starts telling one while you are telling yours, all joking stops.",
                        "The awesome thing about BGP jokes is that the intended audience will likely get them, one way or another.",
                        "The great thing about SQL transaction jokes is that once you BEGIN, you can ROLLBACK if nobody gets them.",
                        "People who tell routing jokes always exceed their time-to-live.",
                        "order best is tell that The you thing can about jokes BitTorrent  them in any.",
                        "The problem with telling a boolean joke is that everyone wants to know if it's true or false.",
                        "The great thing about BGP jokes ? Anyone can claim they are their own, all you can do is hope your neighbours like them."));
    }
}
