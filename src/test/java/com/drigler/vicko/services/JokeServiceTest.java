package com.drigler.vicko.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.drigler.vicko.factory.JokeFactory;
import com.drigler.vicko.models.jokes.Joke;

@SpringBootTest
public class JokeServiceTest {

    private final IJokeService jService;

    @Autowired
    public JokeServiceTest(IJokeService jokeService) {

        this.jService = jokeService;
    }

    // @Test
    void insertJoke() {

        Joke joke = JokeFactory.newFunnyJoke();
        jService.saveJoke(joke);

        List<Joke> jokes = jService.getAll();
        assertThat(jokes).isNotEmpty();
    }

    @Test
    void getAllOrdered() {

        List<Joke> jList = jService.getAllOrderByLikesMinusDislikes();
        assertThat(jList).isNotEmpty();
    }

    @Test
    void getAll() {

        List<Joke> jList = jService.getAll();
        assertThat(jList).isNotEmpty();
    }

    @Test
    void getById() {

        Optional<Joke> result = jService.getById(1);
        assertThat(result).isNotEmpty();
    }

}
