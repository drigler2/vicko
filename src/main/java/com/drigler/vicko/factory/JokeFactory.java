package com.drigler.vicko.factory;

import com.drigler.vicko.models.forms.JokeForm;
import com.drigler.vicko.models.jokes.Category;
import com.drigler.vicko.models.jokes.Joke;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JokeFactory {

    public static Joke newFunnyJoke(Category cat) {

        return new Joke(null, cat, "Why did the chicken cross the road? To get to the other side.",
            0, 0);
    }

    public static Joke newJokeFromForm(JokeForm jokeForm) {

        return new Joke(null, jokeForm.getCategory(), jokeForm.getContent(), jokeForm.getLikes(),
            jokeForm.getDislikes());
    }

}
