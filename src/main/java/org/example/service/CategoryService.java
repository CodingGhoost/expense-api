package org.example.service;

import org.example.pojo.Category;

import java.util.List;

public interface CategoryService {

    // Add a new expense category
    void add(Category category);

    // Get the list of all categories
    List<Category> list();

    // Get category details by id
    Category findById(Integer id);

    // Update category
    void update(Category category);

    // Delete category
    void deleteById(Integer id);
}
