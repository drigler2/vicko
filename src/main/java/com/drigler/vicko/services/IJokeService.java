package com.drigler.vicko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.drigler.vicko.models.jokes.Joke;

public interface IJokeService {

    public Page<Joke> getAllOrderByLikesMinusDislikes(Pageable pageable);

    public void saveJoke(Joke joke);

    public List<Joke> getAll();

    public Optional<Joke> getById(Integer id);

    public void like(Joke joke);

    public void dislike(Joke joke);

    void like(Integer idJoke);

    void dislike(Integer IdJoke);

}
