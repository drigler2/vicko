package com.drigler.vicko.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.drigler.vicko.models.jokes.Category;

@Repository
public interface ICategoryRepository extends CrudRepository<Category, Integer> {

}
