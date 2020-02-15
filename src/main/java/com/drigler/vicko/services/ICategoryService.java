package com.drigler.vicko.services;

import java.util.List;
import java.util.Optional;

import com.drigler.vicko.models.jokes.Category;

public interface ICategoryService {

    public List<Category> getAll();

    public void saveCategory(Category category);

    public Optional<Category> getById(Integer id);

}
