package com.drigler.vicko.repositories;

import org.springframework.data.repository.CrudRepository;

import com.drigler.vicko.models.jokes.Joke;

public interface IJokeRepository extends CrudRepository<Joke, Integer> {

}
