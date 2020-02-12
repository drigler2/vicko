package com.drigler.vicko.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.drigler.vicko.models.jokes.Category;
import com.drigler.vicko.repositories.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository catRepo;

    public CategoryService(ICategoryRepository catRepo) {

        this.catRepo = catRepo;
    }

    @Override
    public List<Category> getAll() {

        List<Category> categories = new LinkedList<>();
        catRepo.findAll().forEach(c -> categories.add(c));
        return categories;
    }

    @Override
    public void saveCategory(Category category) {

        catRepo.save(category);
    }

}
