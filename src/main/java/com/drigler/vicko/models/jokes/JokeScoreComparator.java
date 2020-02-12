package com.drigler.vicko.models.jokes;

import java.util.Comparator;

public class JokeScoreComparator implements Comparator<Joke> {

    @Override
    public int compare(Joke o1, Joke o2) {

        return o1.computePopularity().compareTo(o2.computePopularity());
    }
}
