package com.drigler.vicko.services;

import java.util.List;

import com.drigler.vicko.models.jokes.Joke;

public interface IJokeService {

    public List<Joke> getAllOrderByLikesMinusDislikes();

    public void saveJoke(Joke joke);

    public List<Joke> getAll();

}
