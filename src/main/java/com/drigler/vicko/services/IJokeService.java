package com.drigler.vicko.services;

import java.util.List;
import java.util.Optional;

import com.drigler.vicko.models.jokes.Joke;

public interface IJokeService {

    public List<Joke> getAllOrderByLikesMinusDislikes();

    public void saveJoke(Joke joke);

    public List<Joke> getAll();

    public Optional<Joke> getById(Integer id);

}
