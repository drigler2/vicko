package com.drigler.vicko.factory;

import com.drigler.vicko.models.jokes.Category;
import com.drigler.vicko.models.jokes.Joke;

public class JokeFactory {

    public static Joke newFunnyJoke(Category cat) {

        return new Joke(null, cat, "Why did the chicken cross the road? To get to the other side.",
            0, 0);
    }

}
