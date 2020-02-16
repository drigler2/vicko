package com.drigler.vicko.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.drigler.vicko.models.jokes.Joke;
import com.drigler.vicko.repositories.IJokeRepository;

@Service
public class JokeService implements IJokeService {

    private final IJokeRepository jokeRepo;

    @Autowired
    public JokeService(IJokeRepository jokeRepo) {

        this.jokeRepo = jokeRepo;
    }

    @Override
    public Page<Joke> getAllOrderByLikesMinusDislikes(Pageable pageable) {

        return jokeRepo.findAllOrdered(pageable);
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

    @Override
    public Optional<Joke> getById(Integer id) {

        return jokeRepo.findById(id);
    }

    @Override
    public void like(Integer idJoke) {

        jokeRepo.like(idJoke);
    }

    @Override
    public void dislike(Integer IdJoke) {

        jokeRepo.dislike(IdJoke);

    }

    @Override
    public void like(Joke joke) {

        joke.setLikes(joke.getLikes() + 1);
        jokeRepo.save(joke);
    }

    @Override
    public void dislike(Joke joke) {

        joke.setDislikes(joke.getDislikes() + 1);
        jokeRepo.save(joke);
    }

}
