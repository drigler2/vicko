package com.drigler.vicko.repositories;

import org.springframework.data.repository.CrudRepository;

import com.drigler.vicko.models.jokes.Category;

public interface ICategoryRepository extends CrudRepository<Category, Integer> {

}
