package com.example.ungdungblog.service;

import com.example.ungdungblog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void delete(int deleteId);
}
