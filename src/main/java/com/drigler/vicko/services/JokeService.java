package com.drigler.vicko.services;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drigler.vicko.models.jokes.Joke;
import com.drigler.vicko.models.jokes.JokeScoreComparator;
import com.drigler.vicko.repositories.IJokeRepository;

@Service
public class JokeService implements IJokeService {

    private final IJokeRepository jokeRepo;

    @Autowired
    public JokeService(IJokeRepository jokeRepo) {

        this.jokeRepo = jokeRepo;
    }

    @Override
    public List<Joke> getAllOrderByLikesMinusDislikes() {

        List<Joke> ordered = new LinkedList<>();
        Iterable<Joke> jokeList = jokeRepo.findAll();

        jokeList.forEach(j -> ordered.add(j));
        Collections.sort(ordered, new JokeScoreComparator());

        return ordered;
    }

    @Override
    public void saveJoke(Joke joke) {

        jokeRepo.save(joke);
    }

    @Override
    public List<Joke> getAll() {

        List<Joke> unordered = new LinkedList<>();
        jokeRepo.findAll().forEach(j -> unordered.add(j));

        return unordered;
    }

}
