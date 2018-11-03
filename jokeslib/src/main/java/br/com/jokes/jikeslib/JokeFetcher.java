package br.com.jokes.jikeslib;

import java.util.Random;

public class JokeFetcher {
    String[] jokes = {"What's the best time to go to the dentist?\n- Tooth hurty",
                      "What kind of shoes does a thief wear?\n- Sneakers",
                      "How do you organize an outer space party?\n- You planet",
                      "What do you call a singling Laptop\n-A Dell"};


    public String requestJoke() {
        Random r = new Random();
        return jokes[r.nextInt(3)];
    }
}
