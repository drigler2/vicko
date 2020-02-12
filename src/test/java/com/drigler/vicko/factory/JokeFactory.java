package com.drigler.vicko.factory;

import com.drigler.vicko.models.jokes.Category;
import com.drigler.vicko.models.jokes.Joke;

public class JokeFactory {

    public static Joke newFunnyJoke() {

        Category cat = new Category("funny");
        return new Joke(cat, "Why did the chicken cross the road? To get to the other side.");
    }

}
