package com.drigler.vicko.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.drigler.vicko.models.jokes.Category;

@SpringBootTest
public class CategoryServiceTest {

    private final ICategoryService catService;

    @Autowired
    public CategoryServiceTest(ICategoryService catService) {

        this.catService = catService;
    }

    @Test
    void insertCategoryTest() {

        Category cat = new Category("not funny");
        catService.saveCategory(cat);

    }

}
