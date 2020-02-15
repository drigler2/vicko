package com.drigler.vicko.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drigler.vicko.models.jokes.Joke;

@Repository
public interface IJokeRepository extends CrudRepository<Joke, Integer> {

    static final String LIKE_QUERY = "update Joke set likes=likes+1 where id=?1";
    static final String DISLIKE_QUERY = "update Joke set dislikes=dislikes+1 where id=?1";

    @Transactional
    @Modifying
    @Query(LIKE_QUERY)
    public void like(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(DISLIKE_QUERY)
    public void dislike(@Param("id") Integer id);

}
